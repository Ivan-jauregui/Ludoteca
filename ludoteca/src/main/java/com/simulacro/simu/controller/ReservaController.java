package com.simulacro.simu.controller;

import com.simulacro.simu.Service.reservaService;
import com.simulacro.simu.Service.socioService;
import com.simulacro.simu.models.Reserva;
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
@RequestMapping("/api/v1/reserva")
public class ReservaController {
    private final reservaService service;

    @PostMapping()
    public ResponseEntity<Reserva> save(@Valid @Validated({Group.Crear.class,Group.Actualizar.class})@RequestBody Reserva r){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(r));
    }


    @GetMapping("/{id}")
    public Reserva findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping()
    public ResponseEntity<List<Reserva>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Reserva update(@Validated(Group.Actualizar.class) @RequestBody Reserva r,@RequestParam Long id){
        return service.save(r);
    }
}
