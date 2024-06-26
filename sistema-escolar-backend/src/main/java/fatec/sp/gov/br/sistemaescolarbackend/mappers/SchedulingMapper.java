package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.SchedulingRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.SchedulingResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Scheduling;

public class SchedulingMapper {

    public static Scheduling toEntity(SchedulingRequest request) {
        Scheduling scheduling = new Scheduling();
        scheduling.setCourseId(request.courseId());
        scheduling.setClassSubjectId(request.classSubjectId());
        scheduling.setTeacher(request.teacher());
        scheduling.setStartTime(request.startTime());
        scheduling.setEndTime(request.endTime());
        scheduling.setCalendar(request.calendar());
        scheduling.setRoomAndLaboratory(request.roomAndLaboratory());
        return scheduling;
    }

    public static SchedulingResponse toDTO(Scheduling scheduling) {
        return new SchedulingResponse(
                scheduling.getId(),
                scheduling.getCourseId(),
                scheduling.getClassSubjectId(),
                scheduling.getTeacher(),
                scheduling.getStartTime(),
                scheduling.getEndTime(),
                scheduling.getCalendar(),
                scheduling.getRoomAndLaboratory()
        );
    }
}
