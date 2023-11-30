package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;
import fatec.sp.gov.br.sistemaescolarbackend.mappers.CourseMapper;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public List<CourseResponse> getCourseResponses() {
        List<Course> courses = repository.findAll();
        return courses.stream()
                .map(CourseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseResponse getCourseResponse(long id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        return CourseMapper.toDTO(course);
    }

    public void deleteCourseById(long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Course not found");
        }
    }

    public CourseResponse save(CourseRequest course) {
        var entity = this.repository.save(CourseMapper.toEntity(course));
        return CourseMapper.toDTO(entity);
    }

    public void update(long id, CourseRequest course) {
        try {
            var updateCourse = this.repository.getReferenceById(id);
            updateCourse.setName(course.name());
            updateCourse.setCourseYear(course.courseYear());
            updateCourse.setSemester(course.semester());
            updateCourse.setShift(course.shift());
            updateCourse.setClassSubjects(course.classSubjects());
            this.repository.save(updateCourse);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}