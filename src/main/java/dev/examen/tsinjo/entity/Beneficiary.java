package dev.examen.tsinjo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String fullName;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private List<Help> helps;
}
