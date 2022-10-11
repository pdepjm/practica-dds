package model;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import java.util.List;

public class RepositorioCumpleanios implements WithGlobalEntityManager {

  public static RepositorioCumpleanios instancia = new RepositorioCumpleanios();

  public List<Cumpleanios> listar() {
    return entityManager()//
        .createQuery("from Cumpleanios", Cumpleanios.class) //
        .getResultList();
  }

  public Cumpleanios buscar(long id) {
    return entityManager().find(Cumpleanios.class, id);
  }

  public void agregar(Cumpleanios cumpleanios) {
    entityManager().persist(cumpleanios);
  }

  public List<Cumpleanios> buscarPorNombre(String nombre) {
    return entityManager() //
        .createQuery("from Cumpleanios where nombreCumpleaniero like :nombre", Cumpleanios.class) //
        .setParameter("nombre", "%" + nombre + "%") //
        .getResultList();
  }

}
