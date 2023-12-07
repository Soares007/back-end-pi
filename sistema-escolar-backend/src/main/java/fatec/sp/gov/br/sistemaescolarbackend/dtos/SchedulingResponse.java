package fatec.sp.gov.br.sistemaescolarbackend.dtos;

public record SchedulingResponse(
        Long id,
        Long courseId,
        Long classSubjectId,
        String teacher,
        String startTime,
        String endTime,
        String dayOfWeek,
        String roomAndLaboratory
) {

}
