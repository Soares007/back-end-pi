package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void update(long id, CourseRequest courseRequest) {
        try {
            var updateCourse = this.courseRepository.getReferenceById(id);
            updateCourse.setName(courseRequest.name());
            updateCourse.setYear(courseRequest.course_year());
            updateCourse.setSemester(courseRequest.semester());
            updateCourse.setShift(courseRequest.shift());
            updateCourse.setDiscipline(courseRequest.discipline());
            this.courseRepository.save(updateCourse);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}
