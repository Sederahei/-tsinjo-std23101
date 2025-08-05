package dev.examen.tsinjo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Help {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date;

    private String description;

    @ManyToOne
    private Beneficiary beneficiary;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
}
