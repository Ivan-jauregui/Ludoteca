package com.ludoteca.mapper;

import com.ludoteca.dtos.request.ReservationRequest;
import com.ludoteca.dtos.response.GameResponse;
import com.ludoteca.dtos.response.ReservationResponse;
import com.ludoteca.dtos.response.SocioResponse;
import com.ludoteca.models.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {SocioResponse.class, GameResponse.class})
public interface ReservationMapper {
    ReservationResponse toDto(Reservation reservation);
    Reservation toEntity(ReservationRequest request);
}
