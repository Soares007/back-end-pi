package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;
import fatec.sp.gov.br.sistemaescolarbackend.mappers.CourseMapper;
import fatec.sp.gov.br.sistemaescolarbackend.services.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody CourseRequest courseRequest) {
        Course course = CourseMapper.toEntity(courseRequest); // Convert CourseRequest to Course
        return courseService.createCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody CourseRequest courseRequest,
            @PathVariable long id) {
        this.courseService.update(id, courseRequest);
        return ResponseEntity.ok().build();
    }
}
