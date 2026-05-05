package com.simulacro.simu.controller;

import com.simulacro.simu.Service.socioService;
import com.simulacro.simu.models.Socio;
import com.simulacro.simu.validator.Group;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/socio")
public class SocioController {
    private final socioService service;

    @PostMapping()
    public ResponseEntity<Socio> save(@Valid @Validated({Group.Crear.class,Group.Actualizar.class})@RequestBody Socio s){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(s));
    }


    @GetMapping("/{id}")
    public Socio findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping()
    public ResponseEntity<List<Socio>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Socio update(@Validated(Group.Actualizar.class) @RequestBody Socio s,@RequestParam Long id){
        return service.save(s);
    }
}
