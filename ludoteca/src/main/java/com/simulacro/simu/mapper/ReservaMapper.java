package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.reservaDTO;
import com.simulacro.simu.models.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    reservaDTO toDto(Reserva reserva);
    Reserva toEntity(reservaDTO reservaDTO);
}
