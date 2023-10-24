package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.ClassSubjectRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;
import fatec.sp.gov.br.sistemaescolarbackend.services.ClassSubjectService;

import java.util.List;

@RestController
@RequestMapping("/class_subjects")
@CrossOrigin
public class ClassSubjectController {
    @Autowired
    private ClassSubjectService classSubjectService;

    @GetMapping
    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectService.getAllClassSubjects();
    }

    @GetMapping("/{id}")
    public ClassSubject getCourse(@PathVariable Long id) {
        return classSubjectService.getClassSubjectById(id);
    }

    @PostMapping
    public ClassSubject createCourse(@RequestBody ClassSubject class_subject) {
        return classSubjectService.createClassSubject(class_subject);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        classSubjectService.deleteClassSubject(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody ClassSubjectRequest class_subject,
                                       @PathVariable long id
    ){
        this.classSubjectService.update(id, class_subject);
        return ResponseEntity.ok().build();
    }
}

