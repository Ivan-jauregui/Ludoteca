package com.simulacro.simu.models;

import com.simulacro.simu.validator.Group;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false,length = 100)
    private String nombre;

    private String categoria;

    private Integer edad_minima;

    private Integer stock;

    private Boolean activo;
    @PrePersist
    public void prePersist() {
        if (this.activo == null ) {
            this.activo = true;
        }
    }


}
