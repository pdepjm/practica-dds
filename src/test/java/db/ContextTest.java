package db;

import model.Cumpleanios;
import org.junit.jupiter.api.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import java.time.LocalDate;

public class ContextTest extends AbstractPersistenceTest implements
    WithGlobalEntityManager {

  @Test
  public void contextUp() {
    Cumpleanios mstislav = new Cumpleanios("Mstislav", LocalDate.now());
 
    persist(mstislav);
  }

}
