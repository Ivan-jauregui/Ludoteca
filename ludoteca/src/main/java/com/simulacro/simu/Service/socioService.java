package com.simulacro.simu.Service;

import com.simulacro.simu.exception.RecursoNoEncontradoException;
import com.simulacro.simu.models.Socio;
import com.simulacro.simu.repository.socioRepository;
import com.simulacro.simu.validator.Group;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;



@AllArgsConstructor
@Service
public class socioService {
    private final socioRepository repository;

    public Socio save(Socio s) {
        return repository.save(s);
    }

    public Socio findById(Long id){
        return repository.findById(id).
                orElseThrow(()-> new RecursoNoEncontradoException("El socio no fue encontrado"));
    }
    public List<Socio> findAll(){
        return repository.findAll();
    }

    public void deleteById(Long id){
        Optional<Socio> socio = repository.findById(id);
        if(socio!=null){
            repository.deleteById(id);
        }

    }

    public Socio update(Socio s,Long id){
        Socio socioBD=repository.findById(id) .
                orElseThrow(()-> new RecursoNoEncontradoException("El socio no fue encontrado"));
        socioBD.setName(s.getName());
        socioBD.setDni(s.getDni());
        socioBD.setEmail(s.getEmail());
        socioBD.setReservas(s.getReservas());
        socioBD.setActivo(s.getActivo());
        return repository.save(socioBD);
    }
}
