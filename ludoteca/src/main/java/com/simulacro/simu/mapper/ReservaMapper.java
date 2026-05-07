package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.JuegoDTO;
import com.simulacro.simu.Dtos.request.ReservaRequest;
import com.simulacro.simu.Dtos.reservaDTO;
import com.simulacro.simu.Dtos.socioDTO;
import com.simulacro.simu.models.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {JuegoDTO.class, socioDTO.class})
public interface ReservaMapper {
    reservaDTO toDto(Reserva reserva);
    Reserva toEntity(ReservaRequest request);

}
