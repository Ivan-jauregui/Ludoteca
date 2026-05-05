package com.simulacro.simu.Service;

import com.simulacro.simu.exception.RecursoNoEncontradoException;
import com.simulacro.simu.exception.ReglaNegocioException;
import com.simulacro.simu.models.Juego;
import com.simulacro.simu.models.Reserva;
import com.simulacro.simu.models.Socio;
import com.simulacro.simu.repository.juegoRepository;
import com.simulacro.simu.repository.reservaRepository;
import com.simulacro.simu.repository.socioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class reservaService {
    private final reservaRepository repository;
    private final socioRepository socioRepository;
    private final juegoRepository juegoRepository;

    public Reserva save(Reserva r) {
        Socio socio = socioRepository.findById(r.getSocio().getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("El socio no existe"));

        // Buscamos y validamos al juego
        Juego juego = juegoRepository.findById(r.getJuego().getId())
                .orElseThrow(() -> new RecursoNoEncontradoException("El juego no existe"));

        if(!socio.getActivo() && !juego.getActivo()){
            throw new ReglaNegocioException("No se puede realizar la reserva: El socio o el juego están inactivos");
        } else if (r.getCantidad()>r.getJuego().getStock()) {
            throw new ReglaNegocioException("Stock insuficiente ");
        }
        juego.setStock(r.getJuego().getStock()- r.getCantidad());
        juegoRepository.save(juego);

        return repository.save(r);
    }

    public Reserva findById(Long id){
        return repository.findById(id).
                orElseThrow(()-> new RecursoNoEncontradoException("La reserva no fue encontrado"));
    }

    public List<Reserva> findAll(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        Reserva reserva = repository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("La reserva no fue encontrado"));

        if(reserva.getEstado().equals("CONFIRMADA")){
            repository.deleteById(id);
        }

    }

    public Reserva update(Reserva r,Long id){
        Reserva reservaDB=repository.findById(id) .
                orElseThrow(()-> new RuntimeException("La reserva no fue encontrado"));
        reservaDB.setEstado(r.getEstado());
        reservaDB.setFecha_retiro(r.getFecha_retiro());
        reservaDB.setSocio(r.getSocio());
        reservaDB.setJuego(r.getJuego());

        return repository.save(reservaDB);
    }
}
