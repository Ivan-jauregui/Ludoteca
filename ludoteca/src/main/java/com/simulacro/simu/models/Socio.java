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
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String dni;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(updatable = false)
    private LocalDateTime fechaAlta=LocalDateTime.now();

    @PrePersist
    public void prePersistDate() {
        if (this.fechaAlta == null ) {
            this.fechaAlta = LocalDateTime.now();
        }
    }

    private Boolean activo=true;

    @PrePersist
    public void prePersistStatus() {
        if (this.activo == null ) {
            this.activo = true;
        }
    }

    @OneToMany(mappedBy = "socio")
    private List<Reserva> reservas;
}
