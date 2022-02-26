package mpa.serverside.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id_user;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "id_tab")
  private List<Tab> tab = new ArrayList<>();
  
}
