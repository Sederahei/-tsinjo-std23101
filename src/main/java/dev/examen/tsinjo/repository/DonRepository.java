package dev.examen.tsinjo.repository;

import dev.examen.tsinjo.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonRepository extends JpaRepository<Don, Long> {
    List<Don> findByStatus(String status);
}

