package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClassSubjectRequest (
    @NotBlank(message = "Nome não pode ser em branco")
    String name,
    String description,
    String teacher
) {
    
}
