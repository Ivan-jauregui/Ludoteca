package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.JuegoDTO;
import com.simulacro.simu.Dtos.request.JuegoRequest;
import com.simulacro.simu.models.Juego;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JuegoMapper {
    Juego toEntity(JuegoRequest request);
    JuegoDTO toDto(Juego juego);
}
