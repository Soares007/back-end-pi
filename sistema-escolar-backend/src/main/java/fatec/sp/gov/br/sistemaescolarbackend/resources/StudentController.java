package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.StudentRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Student;
import fatec.sp.gov.br.sistemaescolarbackend.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody StudentRequest student,
                                       @PathVariable long id
    ){
        studentService.update(id, student);
        return ResponseEntity.ok().build();
    }
}
