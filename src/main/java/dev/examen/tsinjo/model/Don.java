package dev.examen.tsinjo.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Don {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nom;
  private String telephone;
  private Integer montant;

  private String email; // Ajouté
  private String pspPaymentId; // Ajouté
  private String status = "VERIFYING"; // Ajouté (valeur par défaut)

  private Instant date = Instant.now();
}
