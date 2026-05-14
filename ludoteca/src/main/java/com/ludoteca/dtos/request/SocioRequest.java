package com.ludoteca.dtos.request;

import com.ludoteca.models.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor  @Builder
public class SocioRequest {

    @NotNull(message = "DNI is requerido")
    private String dni;

    @NotBlank(message = "nombre es requerido")
    @Size(min = 2, max = 15, message = "El nombre debe de tener entre 2 a 15 caracteres")
    private String firstName;

    @NotBlank(message = "nombre es requerido")
    @Size(min = 2, max = 20, message = "El apellido debe de tener entre 2 a 20 caracteres")
    private String lastName;

    @NotBlank(message = "El email es requerido")
    @Email(message = "Error en formato de email")
    private String email;

}
