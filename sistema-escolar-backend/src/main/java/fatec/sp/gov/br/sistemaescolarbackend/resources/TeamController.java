package fatec.sp.gov.br.sistemaescolarbackend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TeamRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Team;
import fatec.sp.gov.br.sistemaescolarbackend.services.TeamService;

@RestController
@RequestMapping("/teams")
@CrossOrigin
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody TeamRequest team,
                                       @PathVariable long id
    ){
        teamService.update(id, team);
        return ResponseEntity.ok().build();
    }
}
