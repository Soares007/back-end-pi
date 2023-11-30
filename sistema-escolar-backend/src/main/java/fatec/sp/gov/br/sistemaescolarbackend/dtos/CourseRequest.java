package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.List;
import jakarta.validation.constraints.NotBlank;

public record CourseRequest (
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    String courseYear,
    String semester,
    @NotBlank(message = "Turno não pode ser em branco")
    String shift,
    List<Integer> classSubjects
) {
    
}
