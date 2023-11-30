package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseResponse;
import fatec.sp.gov.br.sistemaescolarbackend.services.CourseService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourses() {
        var courses = this.service.getCourseResponses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable long id) {
        var course = this.service.getCourseResponse(id);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {
        this.service.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CourseResponse> save(@Validated @RequestBody CourseRequest course) {
        var savedCourse = this.service.save(course);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCourse.id())
                .toUri();
        return ResponseEntity.created(location).body(savedCourse);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody CourseRequest course,
                                       @PathVariable long id
    ){
        this.service.update(id, course);
        return ResponseEntity.ok().build();
    }
}