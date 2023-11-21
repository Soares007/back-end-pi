package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SchedulingRequest(
        @NotNull Long courseId,
        @NotNull Long classSubjectId,
        @NotBlank(message = "Professor não pode ser em branco")
        String professor,
        @NotBlank(message = "Hora de início não pode ser em branco")
        String startTime,
        @NotBlank(message = "Hora de término não pode ser em branco")
        String endTime,
        @NotBlank(message = "Dia da semana não pode ser em branco")
        String dayOfWeek,
        @NotBlank(message = "Sala não pode ser em branco")
        String room,
        String laboratory
) {

}
