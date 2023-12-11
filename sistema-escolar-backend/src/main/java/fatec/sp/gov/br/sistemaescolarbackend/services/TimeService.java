package fatec.sp.gov.br.sistemaescolarbackend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.TimeRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Time;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.TimeRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TimeService {
    @Autowired
    private TimeRepository timeRepository;

    public List<Time> getAllTimes() {
        return timeRepository.findAll();
    }

    public Time createTime(Time time) {
        return timeRepository.save(time);
    }

    public Time getTimeById(Long id) {
        return timeRepository.findById(id).orElse(null);
    }

    public void deleteTime(Long id) {
        timeRepository.deleteById(id);
    }

  public void update(long id, TimeRequest time) {
    try {
        var updateTime = this.timeRepository.getReferenceById(id);
        updateTime.setClassSubjectId(time.classSubjectId());
        updateTime.setDaysofweek(time.daysofweek());

        // Substituir as listas existentes pelas novas
        updateTime.setStartTimes(new ArrayList<>(time.startTimes()));
        updateTime.setEndTimes(new ArrayList<>(time.endTimes()));

        this.timeRepository.save(updateTime);
    } catch (EntityNotFoundException e) {
        throw new EntityNotFoundException("Time not found");
    }
}

    
}