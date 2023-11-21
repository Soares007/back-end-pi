package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record CourseRequest (
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    int course_year,
    int semester,
    @NotBlank(message = "Turno não pode ser em branco")
    String shift,
    @NotBlank(message = "Disciplina não pode ser em branco")
    String discipline
) {

}
