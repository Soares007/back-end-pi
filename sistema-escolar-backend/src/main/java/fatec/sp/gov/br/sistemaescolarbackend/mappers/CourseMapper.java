package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CourseResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Course;

public class CourseMapper {

    public static Course toEntity(CourseRequest request) {
        Course course = new Course();
        course.setName(request.name());
        course.setYear(request.course_year());
        course.setSemester(request.semester());
        course.setShift(request.shift());
        course.setDiscipline(request.discipline());
        return course;
    }

    public static CourseResponse toDTO(Course course) {
        return new CourseResponse(
            course.getId(),
            course.getName(),
            course.getYear(),
            course.getSemester(),
            course.getShift(),
            course.getDiscipline()
        );
    }
}
