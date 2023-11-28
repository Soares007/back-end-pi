package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import java.util.Collections;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

public record CourseRequest (
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    String courseYear,
    String semester,
    @NotBlank(message = "Turno não pode ser em branco")
    String shift,
   List<String> classSubjects
) {

    public List<String> classSubjects() {
        return this.classSubjects != null ? this.classSubjects : Collections.emptyList();
    }
    
}
