package fatec.sp.gov.br.sistemaescolarbackend.mappers;


import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeamRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeamResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Team;

public class TeamsMapper {
    public static Team toEntity(TeamRequest request) {
        Team team = new Team();
        team.setSemester(request.semester());
        team.setCourse(request.course());
        team.setStudents(request.students());
        team.setShift(request.shift());
        return team;
    }

    public static TeamResponse toDTO(Team team) {
        return new TeamResponse(
            team.getId(),
            team.getSemester(),
            team.getCourse(),
             team.getStudents(),
            team.getShift()
        );
    }
}
