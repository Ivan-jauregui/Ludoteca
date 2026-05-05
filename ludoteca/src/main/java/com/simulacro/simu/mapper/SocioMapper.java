package com.simulacro.simu.mapper;

import com.simulacro.simu.Dtos.socioDTO;
import com.simulacro.simu.models.Socio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocioMapper {
    socioDTO socioToSocioDTO(Socio socio);
    SocioMapper INSTANCE = Mappers.getMapper(SocioMapper.class);
}
