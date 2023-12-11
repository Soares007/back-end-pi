package fatec.sp.gov.br.sistemaescolarbackend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SchedulingRequest(
        @NotNull Long courseId,
        @NotNull Long classSubjectId,
        @NotBlank(message = "Professor não pode ser em branco")
        String teacher,
        @NotBlank(message = "Hora de início não pode ser em branco")
        String startTime,
        @NotBlank(message = "Hora de término não pode ser em branco")
        String endTime,
        @NotBlank(message = "Data não pode ser em branco")
        String calendar,
        @NotBlank(message = "Sala/Laboratório não pode ser em branco")
        String roomAndLaboratory
) {

}
