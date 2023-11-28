package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.ClassSubjectRepository;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

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
            updateCourse.setCourseYear(courseRequest.courseYear());
            updateCourse.setSemester(courseRequest.semester());
            updateCourse.setShift(courseRequest.shift());

            // Mapeie as strings para objetos ClassSubject
            List<ClassSubject> classSubjects = courseRequest.classSubjects().stream()
                    .map(disciplineName -> {
                        ClassSubject classSubject = classSubjectRepository.findByName(disciplineName);
                        // Se a disciplina não existir, crie uma nova
                        if (classSubject == null) {
                            classSubject = new ClassSubject();
                            classSubject.setName(disciplineName);
                            // Outros campos da disciplina podem precisar ser preenchidos aqui
                            classSubjectRepository.save(classSubject);
                        }
                        return classSubject;
                    })
                    .collect(Collectors.toList());

            updateCourse.setClassSubjects(classSubjects);

            this.courseRepository.save(updateCourse);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Course not found");
        } 
    }
    
}
