package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record TeamRequest (
    @NotBlank(message = "Curso não pode ser em branco")
    String course,
    @NotBlank(message = "Semestre não pode ser em branco")
    String semester,
    @NotBlank(message = "Turno não pode ser em branco")
    String shift,
    @NotBlank(message = "Estudantes não pode ser em branco")
    String students
)
{

}