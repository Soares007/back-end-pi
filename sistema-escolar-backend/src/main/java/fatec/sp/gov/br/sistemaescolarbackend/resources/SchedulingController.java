package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.SchedulingRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Scheduling;
import fatec.sp.gov.br.sistemaescolarbackend.services.SchedulingService;

import java.util.List;

@RestController
@RequestMapping("/schedulings")
@CrossOrigin
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    public List<Scheduling> getAllSchedulings() {
        return schedulingService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public Scheduling getScheduling(@PathVariable Long id) {
        return schedulingService.getSchedulingById(id);
    }

    @PostMapping
    public Scheduling createScheduling(@RequestBody Scheduling scheduling) {
        return schedulingService.createScheduling(scheduling);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduling(@PathVariable Long id) {
        schedulingService.deleteScheduling(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody SchedulingRequest scheduling,
                                       @PathVariable long id
    ){
        this.schedulingService.update(id, scheduling);
        return ResponseEntity.ok().build();
    }
}
