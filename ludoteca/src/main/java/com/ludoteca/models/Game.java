package com.ludoteca.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter  @Setter  @AllArgsConstructor  @NoArgsConstructor  @Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer minimunAge;

    @Column(nullable = false)
    private Integer availableStock;

    private LocalDateTime registrationDate;
    private Boolean active;


    @PrePersist
    private void onCreate(){
        if(registrationDate == null){
            registrationDate = LocalDateTime.now();
        }

        if(active==null){
            active=true;
        }
    }
}
