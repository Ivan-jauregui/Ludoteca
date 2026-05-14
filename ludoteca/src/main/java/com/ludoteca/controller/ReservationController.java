package com.ludoteca.controller;

import com.ludoteca.dtos.request.GameRequest;
import com.ludoteca.dtos.request.ReservationRequest;
import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.ReservationResponse;
import com.ludoteca.enums.ReservationStatus;
import com.ludoteca.service.GameService;
import com.ludoteca.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping()
    public ResponseEntity<ReservationResponse> save(@Valid @RequestBody ReservationRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(String dni){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ReservationResponse>> findAllBySocioName(@PathVariable String name){
        return ResponseEntity.ok(service.findAllBySocioName(name));
    }

    @GetMapping
    public ResponseEntity<List<ReservationResponse>> findAll(@RequestParam String status){
        return ResponseEntity.ok(service.findAll(ReservationStatus.valueOf(status)));
    }

    @PatchMapping("/{id}/cancel")
    public ResponseEntity<ReservationResponse> cancel(@PathVariable long id,@RequestBody ReservationRequest request){
        return ResponseEntity.ok( service.cancel(id,request) );
    }
}
