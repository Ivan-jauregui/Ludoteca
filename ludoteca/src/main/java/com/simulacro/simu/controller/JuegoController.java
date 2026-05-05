package com.simulacro.simu.controller;

import com.simulacro.simu.Service.juegoService;
import com.simulacro.simu.Service.socioService;
import com.simulacro.simu.models.Juego;
import com.simulacro.simu.models.Socio;
import com.simulacro.simu.validator.Group;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/juego")
public class JuegoController {
    private final juegoService service;

    @PostMapping()
    public ResponseEntity<Juego> save(@Valid @Validated({Group.Crear.class,Group.Actualizar.class})@RequestBody Juego j){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(j));
    }


    @GetMapping("/{id}")
    public Juego findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping()
    public ResponseEntity<List<Juego>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Juego update(@Validated(Group.Actualizar.class) @RequestBody Juego j,@RequestParam Long id){
        return service.save(j);
    }
}
