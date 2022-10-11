package main;

import model.Cumpleanios;
import model.RepositorioCumpleanios;
import model.Usuario;
import org.uqbarproject.jpa.java8.extras.EntityManagerOps;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import java.time.LocalDate;

/**
 * Ejecutar antes de levantar el servidor por primera vez
 * 
 * @author flbulgarelli
 */
public class Bootstrap implements WithGlobalEntityManager, EntityManagerOps, TransactionalOps {

  public static void main(String[] args) {
    new Bootstrap().run();
  }

  public void run() {
    withTransaction(() -> {
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("dblandit", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("2diseños", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("chakanalabs", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("consultoraLoca", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("rolicusulting", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("francoconsulting", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("otraConsultora", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("pirulo.com", LocalDate.now()));
      RepositorioCumpleanios.instancia.agregar(new Cumpleanios("blah", LocalDate.now()));
      persist(new Usuario("fran", "1234"));
    });
  }

}
