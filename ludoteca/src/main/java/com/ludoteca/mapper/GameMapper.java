package com.ludoteca.mapper;

import com.ludoteca.dtos.request.GameRequest;
import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.models.Game;
import com.ludoteca.models.Socio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface GameMapper {
    GameResponse toDto(Game game);
    Game toEntity(GameRequest request);

}
