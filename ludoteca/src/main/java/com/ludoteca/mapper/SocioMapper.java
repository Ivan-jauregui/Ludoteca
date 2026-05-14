package com.ludoteca.mapper;

import com.ludoteca.dtos.request.SocioRequest;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.models.Socio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface SocioMapper {
    SocioResponse toDto(Socio socio);
    Socio toEntity(SocioRequest request);

}
