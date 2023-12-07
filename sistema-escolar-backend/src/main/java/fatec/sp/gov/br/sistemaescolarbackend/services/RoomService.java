package fatec.sp.gov.br.sistemaescolarbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomResponse;
import fatec.sp.gov.br.sistemaescolarbackend.entities.Room;
import fatec.sp.gov.br.sistemaescolarbackend.mappers.RoomMapper;
import fatec.sp.gov.br.sistemaescolarbackend.repositories.RoomRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public List<RoomResponse> getRoomResponses() {
        List<Room> rooms = repository.findAll();
        return rooms.stream()
                .map(RoomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomResponse getRoomResponse(long id) {
        Room room = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Room not found"));
        return RoomMapper.toDTO(room);
    }

    public void deleteRoomById(long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Room not found");
        }
    }
public RoomResponse save(RoomRequest room) {
        var entity = this.repository.save(RoomMapper.toEntity(room));
        return RoomMapper.toDTO(entity);
    }

    public void update(long id, RoomRequest room) {
        try {
            var updateRoom = this.repository.getReferenceById(id);
            updateRoom.setName(room.name());
            this.repository.save(updateRoom);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}