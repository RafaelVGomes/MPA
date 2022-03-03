package mpa.serverside.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tab {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id_tab;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "id_room", nullable = false, unique = true)
  private Room room;

  public Integer getId_tab() {
    return id_tab;
  }

  public void setId_tab(Integer id_tab) {
    this.id_tab = id_tab;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

}
