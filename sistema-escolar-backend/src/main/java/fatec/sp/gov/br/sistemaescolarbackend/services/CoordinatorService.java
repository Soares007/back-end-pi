package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.CoordinatorRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Coordinator;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.CoordinatorRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class CoordinatorService {
    @Autowired
    private CoordinatorRepository coordinatorRepository;

    public List<Coordinator> getAllCoordinators() {
        return coordinatorRepository.findAll();
    }

    public Coordinator createCoordinator(Coordinator coordinator) {
        return coordinatorRepository.save(coordinator);
    }

    public Coordinator getCoordinatorById(Long id) {
        return coordinatorRepository.findById(id).orElse(null);
    }

    public void deleteCoordinator(Long id) {
        coordinatorRepository.deleteById(id);
    }

    public void update(long id, CoordinatorRequest coordinator) {
        try {
            var updateCoordinator = this.coordinatorRepository.getReferenceById(id);
            updateCoordinator.setUser(coordinator.user());
            updateCoordinator.setPassword(coordinator.password());
            this.coordinatorRepository.save(updateCoordinator);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Coordinator not found");
        }
    }
}

