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

@Entity
public class Contractor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_contractor;

  @Column(nullable = false)
  private String name;

  @OneToOne
  @JoinColumn(name = "id_room", nullable = true, unique = true)
  private Room room;

  @OneToMany(mappedBy = "id_employee")
  private List<Employee> employees;

  public Integer getId_contractor() {
    return id_contractor;
  }

  public void setId_contractor(Integer id_contractor) {
    this.id_contractor = id_contractor;
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

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
  
}
