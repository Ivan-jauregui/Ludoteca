package com.ludoteca.service;

import com.ludoteca.dtos.request.GameRequest;
import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.exceptions.response.RecourseNotFoundException;
import com.ludoteca.mapper.GameMapper;
import com.ludoteca.mapper.SocioMapper;
import com.ludoteca.models.Game;
import com.ludoteca.models.Socio;
import com.ludoteca.repository.GameRepository;
import com.ludoteca.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository repository;
    private final GameMapper mapper;

    public GameResponse save(GameRequest request){
        Game game = mapper.toEntity(request);

        return mapper.toDto(game);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public GameResponse findById(Long id){
        Game game = repository.findById(id)
                .orElseThrow(()-> new RecourseNotFoundException("El juego con " +  id+  " no fue encontrado"));

        GameResponse response = mapper.toDto(game);
        return response;
    }

    public List<GameResponse> findAll(){
        return repository.findAllByActiveTrue().stream()
                .map(mapper::toDto)
                .toList();
    }
}
