package dev.examen.tsinjo.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Donor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;
  private String fullName;

  @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
  private List<Donation> donations;
}
