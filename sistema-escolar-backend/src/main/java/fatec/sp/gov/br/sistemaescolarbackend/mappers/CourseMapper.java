package fatec.sp.gov.br.sistemaescolarbackend.mappers;
import java.util.List;
import java.util.stream.Collectors;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;
import fatec.sp.gov.br.sistemaescolarbackend.entities.ClassSubject;


public class CourseMapper {

    public static Course toEntity(CourseRequest request) {
        Course course = new Course();
        course.setName(request.name());
        course.setCourseYear(request.courseYear());
        course.setSemester(request.semester());
        course.setShift(request.shift());

        // Mapeie as strings para objetos ClassSubject
        List<ClassSubject> classSubjects = request.classSubjects().stream()
                .map(disciplineName -> {
                    ClassSubject classSubject = new ClassSubject();
                    classSubject.setName(disciplineName);
                    return classSubject;
                })
                .collect(Collectors.toList());

        course.setClassSubjects(classSubjects);

        return course;
    }

    public static CourseResponse toDTO(Course course) {
        return new CourseResponse(
            course.getId(),
            course.getName(),
            course.getCourseYear(),
            course.getSemester(),
            course.getShift(),
            course.getClassSubjects().stream().map(ClassSubject::getName).collect(Collectors.toList())
        );
    }
    
}