package com.ludoteca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter  @Setter  @AllArgsConstructor  @NoArgsConstructor  @Builder
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String dni;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    @Column(unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "socio")
    List<Reservation> reservations;

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
