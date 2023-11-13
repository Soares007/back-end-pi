package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record HistoryRequest (
    @NotBlank(message = "Professor não pode estar em branco")
    String teacher,
    
    @NotBlank(message = "Disciplina não pode estar em branco")
    String class_subject,
    
    @NotBlank(message = "Horário não pode estar em branco")
    String time,
    
    @NotBlank(message = "Dia não pode estar em branco")
    String class_day,
    
    @NotBlank(message = "Sala não pode estar em branco")
    String room
) {
}
