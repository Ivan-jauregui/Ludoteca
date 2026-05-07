package com.simulacro.simu.Service;

import com.simulacro.simu.Dtos.request.SocioRequest;
import com.simulacro.simu.exception.RecursoNoEncontradoException;
import com.simulacro.simu.mapper.SocioMapper;
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
    private final SocioMapper mapper;

    public Socio save(SocioRequest s) {

        Socio nuevoSocio = mapper.toEntity(s);
        return repository.save(nuevoSocio);
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

    public Socio update(SocioRequest s,Long id){
        Socio socioBD=repository.findById(id) .
                orElseThrow(()-> new RecursoNoEncontradoException("El socio no fue encontrado"));
        socioBD.setName(s.getName());
        socioBD.setDni(s.getDni());
        socioBD.setEmail(s.getEmail());
        socioBD.setActivo(s.getActivo());
        return repository.save(socioBD);
    }
}
