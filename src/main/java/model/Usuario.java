package model;

import model.Cumpleanios;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Usuarios")
public class Usuario {

  @Id
  @GeneratedValue
  private long id;

  private String username;

  private String password;

  @OneToMany
  @JoinColumn(name = "administrador")
  private Collection<Cumpleanios> cumpleaniosAdministrados = new ArrayList<>() ;

  public Usuario(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Usuario() {
  }

  public String getPassword() {
    return password;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public Collection<Cumpleanios> getConsultorasAdministrados() {
    return cumpleaniosAdministrados;
  }

  public void agregarConsultora(Cumpleanios cumpleanios) {
    cumpleaniosAdministrados.add(cumpleanios);
  }
}
