package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.SchedulingRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Scheduling;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.SchedulingRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    public List<Scheduling> getAllSchedules() {
        return schedulingRepository.findAll();
    }

    public Scheduling createScheduling(Scheduling scheduling) {
        return schedulingRepository.save(scheduling);
    }

    public Scheduling getSchedulingById(Long id) {
        return schedulingRepository.findById(id).orElse(null);
    }

    public void deleteScheduling(Long id) {
        schedulingRepository.deleteById(id);
    }

    public void update(long id, SchedulingRequest schedulingRequest) {
        try {
            var updateScheduling = this.schedulingRepository.getReferenceById(id);
            updateScheduling.setCourseId(schedulingRequest.courseId());
            updateScheduling.setClassSubjectId(schedulingRequest.classSubjectId());
            updateScheduling.setProfessor(schedulingRequest.professor());
            updateScheduling.setStartTime(schedulingRequest.startTime());
            updateScheduling.setEndTime(schedulingRequest.endTime());
            updateScheduling.setDayOfWeek(schedulingRequest.dayOfWeek());
            updateScheduling.setRoom(schedulingRequest.room());
            updateScheduling.setLaboratory(schedulingRequest.laboratory());
            this.schedulingRepository.save(updateScheduling);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Scheduling not found");
        }
    }
}
