package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.JuegoDTO;
import com.simulacro.simu.Dtos.request.JuegoRequest;
import com.simulacro.simu.models.Juego;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-07T19:55:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class JuegoMapperImpl implements JuegoMapper {

    @Override
    public Juego toEntity(JuegoRequest request) {
        if ( request == null ) {
            return null;
        }

        Juego.JuegoBuilder juego = Juego.builder();

        juego.id( request.getId() );
        juego.nombre( request.getNombre() );
        juego.categoria( request.getCategoria() );
        juego.edad_minima( request.getEdad_minima() );
        juego.stock( request.getStock() );
        juego.activo( request.getActivo() );

        return juego.build();
    }

    @Override
    public JuegoDTO toDto(Juego juego) {
        if ( juego == null ) {
            return null;
        }

        JuegoDTO juegoDTO = new JuegoDTO();

        return juegoDTO;
    }
}
