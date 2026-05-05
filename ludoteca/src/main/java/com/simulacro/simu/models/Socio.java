package com.simulacro.simu.models;

import com.simulacro.simu.validator.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = Group.Actualizar.class ,message = "El ID es requerido para actualizar")
    private Long id;
    @NotBlank(groups = {Group.Actualizar.class,Group.Crear.class},message = "El nombre es requerido")
    private String name;
    @Column(nullable = false,unique = true)
    @NotNull(groups = {Group.Actualizar.class,Group.Crear.class},message = "El DNI es requerido")
    private String dni;
    @Email(groups = {Group.Actualizar.class,Group.Crear.class})
    @Column(nullable = false,unique = true)
    private String email;
    @Builder.Default
    @Column(updatable = false)
    private LocalDateTime fechaAlta=LocalDateTime.now();
    @Builder.Default
    @NotNull(groups = Group.Actualizar.class)
    private Boolean activo=true;

    @OneToMany(mappedBy = "socio")
    private List<Reserva> reservas;
}
