package dev.examen.tsinjo.repository;

import dev.examen.tsinjo.model.Don;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonRepository extends JpaRepository<Don, Long> {
  List<Don> findByStatus(String status);
}
