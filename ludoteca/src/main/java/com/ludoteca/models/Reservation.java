package com.ludoteca.models;

import com.ludoteca.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reservationDate;

    @Column(nullable = false)
    private LocalDateTime retirementDate;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated
    @Column(nullable = false)
    private ReservationStatus status;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private void onCreate(){
        if(reservationDate==null){
            reservationDate=LocalDateTime.now();
        }

        if(status==null){
            status=ReservationStatus.CONFIRMED;
        }
    }
}
