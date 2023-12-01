package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;

public record CourseResponse (
    Long id,
    String name,
    String courseYear,
    String semester,
    String shift,
    List<Integer> classSubjects
) {
}