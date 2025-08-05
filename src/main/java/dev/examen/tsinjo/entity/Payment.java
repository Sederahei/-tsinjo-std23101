package dev.examen.tsinjo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pspType; // e.g. "ORANGE_MONEY"
    private String pspPaymentId;

    private Integer amount; // en ariary ou centimes ?
    private Instant creationDate;

    @Enumerated(EnumType.STRING)
    private VerificationStatus status;

    public enum VerificationStatus {
        VERIFYING, SUCCEEDED, FAILED
    }
}

