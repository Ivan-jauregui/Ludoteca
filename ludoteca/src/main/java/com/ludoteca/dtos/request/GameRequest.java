package com.ludoteca.dtos.request;


import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRequest {

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "La categoria es requerida")
    private String category;

    @Positive(message = "El stock debe ser mayor a cero")
    private Integer minimunAge;

    @PositiveOrZero(message = "El stock debe ser mayor o igual a cero")
    private Integer availableStock;

}
