package dev.examen.tsinjo.endpoint.rest.controller.health;
import dev.examen.tsinjo.model.Don;
import dev.examen.tsinjo.repository.DonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class DonController {

    private final DonRepository donRepository;


    @GetMapping("/dons")
    public String listDons(Model model) {
        model.addAttribute("dons", donRepository.findAll());
        return "don-list";
    }

    @PostMapping("/don")
    public String saveDon(
            @RequestParam String nom,
            @RequestParam String telephone,
            @RequestParam String email,
            @RequestParam Integer montant,
            @RequestParam String pspPaymentId,
            Model model
    ) {
        Don don = Don.builder()
                .nom(nom)
                .telephone(telephone)
                .email(email)
                .montant(montant)
                .pspPaymentId(pspPaymentId)
                .status("VERIFYING")
                .build();

        donRepository.save(don);
        model.addAttribute("message", "Merci pour votre don !");
        return "don-form";
    }
}
