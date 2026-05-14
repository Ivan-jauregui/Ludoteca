package com.ludoteca.repository;

import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    List<Game> findAllByActiveTrue();
}
