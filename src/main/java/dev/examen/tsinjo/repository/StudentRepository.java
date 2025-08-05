package dev.examen.tsinjo.repository;
import dev.examen.tsinjo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

