package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.request.ReservaRequest;
import com.simulacro.simu.Dtos.reservaDTO;
import com.simulacro.simu.models.Reserva;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-07T19:55:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public reservaDTO toDto(Reserva reserva) {
        if ( reserva == null ) {
            return null;
        }

        reservaDTO reservaDTO = new reservaDTO();

        return reservaDTO;
    }

    @Override
    public Reserva toEntity(ReservaRequest request) {
        if ( request == null ) {
            return null;
        }

        Reserva.ReservaBuilder reserva = Reserva.builder();

        reserva.id( request.getId() );
        reserva.fecha_reserva( request.getFecha_reserva() );
        reserva.fecha_retiro( request.getFecha_retiro() );
        reserva.cantidad( request.getCantidad() );
        reserva.estado( request.getEstado() );

        return reserva.build();
    }
}
