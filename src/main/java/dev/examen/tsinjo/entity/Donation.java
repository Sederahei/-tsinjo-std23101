package dev.examen.tsinjo.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant date;

    @ManyToOne
    private Donor donor;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;
}
