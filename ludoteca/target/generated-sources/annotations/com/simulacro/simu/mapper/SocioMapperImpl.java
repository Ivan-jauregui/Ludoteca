package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.socioDTO;
import com.simulacro.simu.models.Socio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-07T19:55:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class SocioMapperImpl implements SocioMapper {

    @Override
    public socioDTO socioToSocioDTO(Socio socio) {
        if ( socio == null ) {
            return null;
        }

        socioDTO socioDTO = new socioDTO();

        return socioDTO;
    }
}
