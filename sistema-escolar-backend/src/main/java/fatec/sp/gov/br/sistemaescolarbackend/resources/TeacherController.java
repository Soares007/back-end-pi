package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeacherRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Teacher;
import fatec.sp.gov.br.sistemaescolarbackend.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody TeacherRequest teacher,
                                       @PathVariable long id
    ){
        teacherService.update(id, teacher);
        return ResponseEntity.ok().build();
    }
}

