package com.simulacro.simu.Dtos.request;

import com.simulacro.simu.validator.Group;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuegoRequest {

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
    @NotNull(groups = {Group.Actualizar.class},message = "Error:)")
    private Boolean activo;
    @PrePersist
    public void prePersist() {
        if (this.activo == null) {
            this.activo = true;
        }
    }

}
