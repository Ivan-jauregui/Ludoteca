package com.ludoteca.dtos.response;

import com.ludoteca.models.Reservation;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocioResponse {
    private String dni;
    private String email;
    private String fullName;
    private List<Reservation> reservations;
}
