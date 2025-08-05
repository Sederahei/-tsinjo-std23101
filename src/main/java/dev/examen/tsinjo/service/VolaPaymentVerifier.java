package dev.examen.tsinjo.service;

import com.fasterxml.jackson.databind.JsonNode;
import dev.examen.tsinjo.model.Don;
import dev.examen.tsinjo.repository.DonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VolaPaymentVerifier {
    private final RestTemplate restTemplate;
    private final DonRepository donRepository;

    @Value("${vola.api.url}")
    private String volaApiUrl;

    @Value("${vola.api.key}")
    private String apiKey;

    @Scheduled(fixedDelay = 10000)
    public void verifierPaiements() {
        List<Don> donsAVerifier = donRepository.findByStatus("VERIFYING");

        for (Don don : donsAVerifier) {
            try {
                URI uri = UriComponentsBuilder.fromHttpUrl(volaApiUrl + "/payment")
                        .queryParam("apiKey", apiKey)
                        .queryParam("payerEmail", don.getEmail())
                        .queryParam("pspType", "ORANGE_MONEY")
                        .queryParam("pspPaymentId", don.getPspPaymentId())
                        .build().toUri();

                ResponseEntity<JsonNode> response = restTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        JsonNode.class
                );

                String status = response.getBody().get("verificationStatus").asText();

                if (!status.equals(don.getStatus())) {
                    don.setStatus(status);
                    donRepository.save(don);
                }

            } catch (Exception e) {
                System.out.println("Erreur lors de la vérification du don " + don.getId() + ": " + e.getMessage());
            }
        }
    }
}
