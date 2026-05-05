package com.simulacro.simu.Service;

import com.simulacro.simu.exception.RecursoNoEncontradoException;
import com.simulacro.simu.models.Juego;
import com.simulacro.simu.models.Socio;
import com.simulacro.simu.repository.juegoRepository;
import com.simulacro.simu.validator.Group;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class juegoService {
    private final juegoRepository repository;

    public Juego save(Juego j) {
        return repository.save(j);
    }

    public Juego findById(Long id){
        return repository.findById(id).
                orElseThrow(()-> new RecursoNoEncontradoException("El juego no fue encontrado"));
    }

    public List<Juego> findAll(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        Optional<Juego> juego = repository.findById(id);
        if(juego!=null){
            repository.deleteById(id);
        }

    }

    public Juego update(Juego j,Long id){
        Juego juegoBD=repository.findById(id) .
                orElseThrow(()-> new RecursoNoEncontradoException("El juego no fue encontrado"));
        juegoBD.setNombre(j.getNombre());
        juegoBD.setCategoria(j.getCategoria());
        juegoBD.setEdad_minima(j.getEdad_minima());
        juegoBD.setStock(j.getStock());
        juegoBD.setActivo(j.getActivo());

        return repository.save(juegoBD);
    }
}
