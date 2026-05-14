package com.ludoteca.controller;

import com.ludoteca.dtos.request.GameRequest;
import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.service.GameService;
import com.ludoteca.service.SocioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/game")
@RequiredArgsConstructor
public class GameController {
    private final GameService service;

    @PostMapping()
    public ResponseEntity<GameResponse> save(@Valid @RequestBody  GameRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String dni){
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<GameResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
