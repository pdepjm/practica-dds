package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cumpleanios")
public class Cumpleanios {

  @Id
  @GeneratedValue
  private long id;

  @Column(name = "nombre")
  private String nombreCumpleaniero;

  @Column(name = "fecha")
  private LocalDate fecha;

  protected Cumpleanios() {
  }

  public Cumpleanios(String nombreCumpleaniero, LocalDate fecha) {
    this.nombreCumpleaniero = nombreCumpleaniero;
    this.fecha = fecha;
  }

  public String getNombre() {
    return nombreCumpleaniero;
  }

  public long getId() {
    return id;
  }

  public LocalDate getFecha() { return fecha; }


}
