package mpa.serverside.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import mpa.serverside.models.Room;
import mpa.serverside.services.RoomService;

@CrossOrigin
@RestController
@RequestMapping("mpa")
public class RoomController {

  @Autowired
  RoomService roomService;

  @GetMapping("/rooms")
  public List<Room> listRooms(){
    List<Room> rooms = roomService.listRooms();
    return rooms;
  }

  @GetMapping("/room")
  public Room findByRoomId(@RequestBody Room room){
    return roomService.findByRoomId(room.getId_room());
  }

  @PostMapping("/room")
  public ResponseEntity<Room> createRoom(@RequestBody Room room){
    Room obj = room;
    Integer id_contractor = obj.getContractor().getId_contractor();
    room = roomService.createRoom(id_contractor, room);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(room.getId_room()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/room")
  public ResponseEntity<Room> editRoom(@RequestBody Room room){
    roomService.editRoom(room);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/room")
  public ResponseEntity<Void> deleteRoom(@RequestBody Room room){
    roomService.deleteRoom(room.getId_room());
    return ResponseEntity.noContent().build();
  }
  
}
