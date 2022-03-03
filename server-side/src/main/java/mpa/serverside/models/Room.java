package mpa.serverside.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id_room;

  @Column(nullable = false)
  private String name;

  @JsonIgnore
  @OneToMany
  @JoinColumn(name = "id_tab", nullable = true)
  private List<Tab> tab;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "id_contractor", nullable = false, unique = true)
  private Contractor contractor;

  public Integer getId_room() {
    return id_room;
  }

  public void setId_room(Integer id_room) {
    this.id_room = id_room;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Tab> getTab() {
    return tab;
  }

  public void setTab(List<Tab> tab) {
    this.tab = tab;
  }

  public Contractor getContractor() {
    return contractor;
  }

  public void setContractor(Contractor contractor) {
    this.contractor = contractor;
  }

  
}
