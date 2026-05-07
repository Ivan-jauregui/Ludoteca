package com.simulacro.simu.Dtos.request;

import com.simulacro.simu.models.Reserva;
import com.simulacro.simu.validator.Group;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocioRequest {

    @NotNull(groups = Group.Actualizar.class ,message = "El ID es requerido para actualizar")
    private Long id;
    @NotBlank(groups = {Group.Actualizar.class,Group.Crear.class},message = "El nombre es requerido")
    private String name;

    @NotNull(groups = {Group.Actualizar.class,Group.Crear.class},message = "El DNI es requerido")
    private String dni;
    @Email(groups = {Group.Actualizar.class,Group.Crear.class})
    private String email;

    @NotNull(groups = {Group.Actualizar.class,Group.Crear.class},message = "la fecha es requerida")
    private LocalDateTime fechaAlta;
    @NotNull(groups = Group.Actualizar.class)
    private Boolean activo=true;

}
