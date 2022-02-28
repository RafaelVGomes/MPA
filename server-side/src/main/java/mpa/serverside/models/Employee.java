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
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_employee;

  @Column(nullable = false)
  private String name;

  @Column(nullable = true)
  private String role;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name="id_contractor", nullable = false)
  private Contractor contractor;
  
}
