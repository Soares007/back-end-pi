package fatec.sp.gov.br.sistemaescolarbackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomRequest;
import fatec.sp.gov.br.sistemaescolarbackend.dtos.RoomResponse;
import fatec.sp.gov.br.sistemaescolarbackend.services.RoomService;

@RestController
@RequestMapping("/rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    private RoomService service;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getRooms() {
        var rooms = this.service.getRoomResponses();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("{id}")
    public ResponseEntity<RoomResponse> getRoom(@PathVariable long id) {
        var room = this.service.getRoomResponse(id);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable long id) {
        this.service.deleteRoomById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<RoomResponse> save(@Validated @RequestBody RoomRequest room) {
        var savedRoom = this.service.save(room);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedRoom.id())
                .toUri();
        return ResponseEntity.created(location).body(savedRoom);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@RequestBody RoomRequest room,
                                       @PathVariable long id
    ){
        this.service.update(id, room);
        return ResponseEntity.ok().build();
    }
}
