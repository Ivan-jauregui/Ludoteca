package com.simulacro.simu.models;

import com.simulacro.simu.validator.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Group.Actualizar.class,message = "El ID es requerido para actualizar")
    private Long id;
    @NotEmpty(groups = {Group.Actualizar.class,Group.Crear.class},message = "El nombre es requerido")
    private String nombre;
    @NotEmpty(groups = {Group.Actualizar.class,Group.Crear.class},message = "La categoria es requerida")
    private String categoria;
    @PositiveOrZero(groups = {Group.Actualizar.class,Group.Crear.class},message = "La edad debe ser mayor o igual a cero")
    private Integer edad_minima;
    @PositiveOrZero(groups = {Group.Actualizar.class,Group.Crear.class},message = "El stock debe ser mayor o igual a cero")
    private Integer stock;
    @Builder.Default // Para que el Builder respete el valor true
    @NotNull(groups = Group.Actualizar.class)
    private Boolean activo = true;
}
