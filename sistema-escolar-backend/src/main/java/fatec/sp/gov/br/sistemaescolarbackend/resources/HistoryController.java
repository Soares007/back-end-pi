package fatec.sp.gov.br.sistemaescolarbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.HistoryRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.HistoryResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.History;
import fatec.sp.gov.br.sistemaescolarbackend.mappers.HistoryMapper;
import fatec.sp.gov.br.sistemaescolarbackend.services.HistoryService;

import java.util.List;

@RestController
@RequestMapping("/histories")
@CrossOrigin
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping
    public List<HistoryResponse> getAllHistories() {
        List<History> histories = historyService.getAllHistories();
        return HistoryMapper.toDTOList(histories);
    }

    @GetMapping("/{id}")
    public HistoryResponse getHistory(@PathVariable Long id) {
        History history = historyService.getHistoryById(id);
        return HistoryMapper.toDTO(history);
    }

    @PostMapping
    public HistoryResponse createHistory(@RequestBody HistoryRequest request) {
        History history = HistoryMapper.toEntity(request);
        History createdHistory = historyService.createHistory(history);
        return HistoryMapper.toDTO(createdHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteHistory(@PathVariable Long id) {
        historyService.deleteHistory(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody HistoryRequest request, @PathVariable long id) {
        historyService.update(id, request);
        return ResponseEntity.ok().build();
    }
}
