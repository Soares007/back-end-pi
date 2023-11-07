package fatec.sp.gov.br.sistemaescolarbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.HistoryRequest;
import fatec.sp.gov.br.sistemaescolarbackend.entities.History;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.HistoryRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAllHistories() {
        return historyRepository.findAll();
    }

    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    public History getHistoryById(Long id) {
        return historyRepository.findById(id).orElse(null);
    }

    public void deleteHistory(Long id) {
        historyRepository.deleteById(id);
    }

    public void update(long id, HistoryRequest request) {
        try {
            var updateHistory = this.historyRepository.getReferenceById(id);
            updateHistory.setTeacher(request.teacher());
            updateHistory.setClass_subject(request.class_subject());
            updateHistory.setTime(request.time());
            updateHistory.setDay(request.day());
            updateHistory.setRoom(request.room());
            this.historyRepository.save(updateHistory);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("History not found");
        }
    }
}
