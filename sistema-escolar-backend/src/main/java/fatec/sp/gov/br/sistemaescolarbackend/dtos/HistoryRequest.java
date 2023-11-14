package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record HistoryRequest (
    @NotBlank(message = "Professor não pode estar em branco")
    String teacher,
    
    @NotBlank(message = "Disciplina não pode estar em branco")
    String class_subject, 
    String starttime,
    String endtime,
    String dayofweek,
    String room,
    String laboratory
) {
}
