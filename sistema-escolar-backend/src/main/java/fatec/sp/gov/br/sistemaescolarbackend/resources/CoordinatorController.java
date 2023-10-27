package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.CoordinatorRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Coordinator;
import fatec.sp.gov.br.sistemaescolarbackend.services.CoordinatorService;

import java.util.List;

@RestController
@RequestMapping("/coordinators")
@CrossOrigin
public class CoordinatorController {
    @Autowired
    private CoordinatorService coordinatorService;

    @GetMapping
    public List<Coordinator> getAllCoordinators() {
        return coordinatorService.getAllCoordinators();
    }

    @GetMapping("/{id}")
    public Coordinator getCoordinator(@PathVariable Long id) {
        return coordinatorService.getCoordinatorById(id);
    }

    @PostMapping
    public Coordinator createCoordinator(@RequestBody Coordinator coordinator) {
        return coordinatorService.createCoordinator(coordinator);
    }

    @DeleteMapping("/{id}")
    public void deleteCoordinator(@PathVariable Long id) {
        coordinatorService.deleteCoordinator(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody CoordinatorRequest coordinator,
                                       @PathVariable long id
    ){
        coordinatorService.update(id, coordinator);
        return ResponseEntity.ok().build();
    }
}

