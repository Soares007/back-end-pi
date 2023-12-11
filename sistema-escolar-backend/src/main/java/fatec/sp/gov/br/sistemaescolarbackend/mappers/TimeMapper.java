package fatec.sp.gov.br.sistemaescolarbackend.mappers;


import fatec.sp.gov.br.sistemaescolarbackend.dtos.TimeRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TimeResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Time;


public class TimeMapper {
    public static Time toEntity(TimeRequest request) {
        Time time = new Time();
        time.setClassSubjectId(request.classSubjectId());
        time.setDaysofweek(request.daysofweek());
        time.setStartTimes(request.startTimes());
        time.setEndTimes(request.endTimes());

        return time;
    }

    public static TimeResponse toDTO(Time time) {

        return new TimeResponse(
                time.getId(),
                time.getClassSubjectId(),
                time.getDaysofweek(),
                time.getStartTimes(),
                time.getEndTimes());
    }
}
