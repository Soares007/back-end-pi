package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClassSubjectRequest (
    
@NotBlank(message = "Nome não pode ser em branco")
String name,

@NotBlank(message = "Descrição não pode ser em branco")
String description,

String teacher,

@NotBlank(message = "Horário não pode ser em branco")
String time

) {

}