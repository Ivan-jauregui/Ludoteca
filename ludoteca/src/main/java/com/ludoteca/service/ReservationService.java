package com.ludoteca.service;

import com.ludoteca.dtos.request.ReservationRequest;
import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.ReservationResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.enums.ReservationStatus;
import com.ludoteca.exceptions.response.InvalidStockException;
import com.ludoteca.exceptions.response.RecourseNotFoundException;
import com.ludoteca.mapper.ReservationMapper;
import com.ludoteca.mapper.SocioMapper;
import com.ludoteca.models.Game;
import com.ludoteca.models.Reservation;
import com.ludoteca.models.Socio;
import com.ludoteca.repository.GameRepository;
import com.ludoteca.repository.ReservationRepository;
import com.ludoteca.repository.SocioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final SocioRepository socioRepository;
    private final GameRepository gameRepository;
    private final ReservationMapper mapper;

    @Transactional
    public ReservationResponse save(ReservationRequest request) {

        Socio socio = socioRepository.findById(request.getSocioId())
                .orElseThrow(() -> new RecourseNotFoundException("El socio con ID " + request.getSocioId() + " no fue encontrado"));

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(() -> new RecourseNotFoundException("El juego con ID " + request.getGameId() + " no fue encontrado"));

        if (request.getQuantity() > game.getAvailableStock()) {
            throw new InvalidStockException("Error la cantidad sobrepasa el stock actual");
        }

        game.setAvailableStock(game.getAvailableStock()-request.getQuantity());
        gameRepository.save(game);

        Reservation reservation = mapper.toEntity(request);
        reservation.setSocio(socio);
        reservation.setGame(game);

        repository.save(reservation);

        return mapper.toDto(reservation);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ReservationResponse findById(Long id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new RecourseNotFoundException("La reserva con " + id + " no fue encontrado"));

        ReservationResponse response = mapper.toDto(reservation);
        return response;
    }

    public List<ReservationResponse> findAll(ReservationStatus status) {
        return repository.findByStatus(status).stream()
                .map(mapper::toDto)
                .toList();
    }

    public List<ReservationResponse> findAllBySocioName(String name) {
        return repository.findBySocio_Name(name).stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    public ReservationResponse cancel(Long id,ReservationRequest request){
        Reservation reservation = repository.findById(id)
                .orElseThrow(()-> new RecourseNotFoundException("La reserva con " +  id+  " no fue encontrado"));

        Game game = reservation.getGame();
        game.setAvailableStock(game.getAvailableStock() + reservation.getQuantity());
        gameRepository.save(game);

        reservation.setStatus(ReservationStatus.CANCELLED);

        repository.save(reservation);

        return mapper.toDto(reservation);
    }

}
