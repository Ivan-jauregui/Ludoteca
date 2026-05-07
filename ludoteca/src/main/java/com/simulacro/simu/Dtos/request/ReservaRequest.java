    package com.simulacro.simu.Dtos.request;

    import com.simulacro.simu.Estado;
    import com.simulacro.simu.validator.Group;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.FutureOrPresent;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Positive;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDateTime;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ReservaRequest {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @NotNull(groups = Group.Actualizar.class,message = "El ID es requerido para actualizar")
        private Long id;

        @NotNull(groups = {Group.Actualizar.class},message = "Error en la fecha")
        private LocalDateTime fecha_reserva ;

        @PrePersist
        public void prePersist() {
            if (this.fecha_reserva == null) {
                this.fecha_reserva = LocalDateTime.now();
            }
        }

        @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "La fecha de retiro es requerida")
        @FutureOrPresent(groups = Group.Crear.class, message = "La fecha de retiro no puede ser en el pasado")
        private LocalDateTime fecha_retiro;

        @NotNull(groups = {Group.Crear.class, Group.Actualizar.class},message = "La cantidad es requerida")
        @Positive(message = "El numero debe ser positivo")
        private Integer cantidad;

        @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El estado es requerido")
        @Enumerated(EnumType.STRING)
        private Estado estado;

        @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El socio es obligatorio")
        private Long socioId;

        @NotNull(groups = {Group.Crear.class, Group.Actualizar.class}, message = "El juego es obligatorio")
        private Long juegoId;
    }
