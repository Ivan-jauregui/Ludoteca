package com.ludoteca.service;

import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.exceptions.response.RecourseNotFoundException;
import com.ludoteca.mapper.SocioMapper;
import com.ludoteca.models.Socio;
import com.ludoteca.repository.SocioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SocioService {
    private final SocioRepository repository;
    private final SocioMapper mapper;

    public SocioResponse save(SocioRequest request){
        Socio socio = mapper.toEntity(request);

        return mapper.toDto(socio);
    }

    public void deleteByDni(String dni){
        repository.deleteByDni(dni);
    }

    public SocioResponse findByDni(String dni){
        Socio socio = repository.findByDni(dni)
                .orElseThrow(()-> new RecourseNotFoundException("El socio con " +  dni+  " no fue encontrado"));

        SocioResponse response = mapper.toDto(socio);
        return response;
    }

    public List<SocioResponse> findAll(){
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }
}
