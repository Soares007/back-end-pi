package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record CourseResponse (
    Long id,
    String name,
    int course_year,
    int semester,
    String shift,
    String discipline
) {
}