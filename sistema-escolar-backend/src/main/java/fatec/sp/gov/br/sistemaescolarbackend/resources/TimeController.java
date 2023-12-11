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

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TimeRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Time;
import fatec.sp.gov.br.sistemaescolarbackend.services.TimeService;

@RestController
@RequestMapping("/times")
@CrossOrigin
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<Time> getAllTimes() {
        return timeService.getAllTimes();
    }

    @GetMapping("/{id}")
    public Time getTime(@PathVariable Long id) {
        return timeService.getTimeById(id);
    }

    @PostMapping
    public Time createTime(@RequestBody Time time) {
        return timeService.createTime(time);
    }

    @DeleteMapping("/{id}")
    public void deleteTime(@PathVariable Long id) {
        timeService.deleteTime(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody TimeRequest time,
                                       @PathVariable long id
    ){
        timeService.update(id, time);
        return ResponseEntity.ok().build();
    }
}