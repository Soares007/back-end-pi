package fatec.sp.gov.br.sistemaescolarbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeamRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Team;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.TeamRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public void update(long id, TeamRequest team) {
        try {
            var updateTeam = this.teamRepository.getReferenceById(id);
            updateTeam.setCourse(team.course());
            updateTeam.setSemester(team.semester());
            updateTeam.setShift(team.shift());
            updateTeam.setStudents(team.students());
            this.teamRepository.save(updateTeam);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Team not found");
        }
    }
}