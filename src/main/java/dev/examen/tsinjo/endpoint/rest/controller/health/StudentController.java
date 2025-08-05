package dev.examen.tsinjo.endpoint.rest.controller.health;

import dev.examen.tsinjo.model.Student;
import dev.examen.tsinjo.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    return studentService.createStudent(student);
  }
}
