package com.ludoteca.controller;

import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.service.SocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/socio")
@RequiredArgsConstructor
public class SocioController {
    private final SocioService service;

    @PostMapping
    public ResponseEntity<SocioResponse> save(@Valid @RequestBody SocioRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> deleteByDni(@PathVariable  String dni){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{dni}")
    public ResponseEntity<SocioResponse> findByDni(@PathVariable  String dni){
        return ResponseEntity.ok(service.findByDni(dni));
    }

    @GetMapping
    public ResponseEntity<List<SocioResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
