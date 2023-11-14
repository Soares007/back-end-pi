package fatec.sp.gov.br.sistemaescolarbackend.mappers;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.HistoryRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.HistoryResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.History;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryMapper {
    public static History toEntity(HistoryRequest request) {
        History history = new History();
        history.setTeacher(request.teacher());
        history.setClass_subject(request.class_subject());
        history.setEndtime(request.starttime());
        history.setEndtime(request.endtime());
        history.setDayofweek(request.dayofweek());
        history.setRoom(request.room());
        history.setLaboratory(request.laboratory());
        return history;
    }

    public static HistoryResponse toDTO(History history) {
        return new HistoryResponse(
                history.getId(),
                history.getTeacher(),
                history.getClass_subject(),
                history.getStarttime(),
                history.getEndtime(),
                history.getDayofweek(),
                history.getRoom(),
                history.getLaboratory()
        );
    }
    public static List<HistoryResponse> toDTOList(List<History> histories) {
        return histories.stream().map(HistoryMapper::toDTO).collect(Collectors.toList());
    }
}
