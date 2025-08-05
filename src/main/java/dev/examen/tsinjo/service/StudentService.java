package dev.examen.tsinjo.service;

import dev.examen.tsinjo.model.Student;
import dev.examen.tsinjo.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }
}
