package controllers;

import model.Cumpleanios;
import model.RepositorioCumpleanios;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CumpleaniosController implements WithGlobalEntityManager, TransactionalOps {

  public ModelAndView listarCumpleanios(Request req){
    String filtro = req.queryParams("filtro");
    List<Cumpleanios> cumpleanios;

    if (filtro == null) {
      cumpleanios = RepositorioCumpleanios.instancia.listar();
    } else {
      cumpleanios = RepositorioCumpleanios.instancia.buscarPorNombre(filtro);
    }

    Map<String,Object> model = new HashMap<>();
    model.put("cumpleanios", cumpleanios);
    model.put("filtro", filtro);
    return new ModelAndView(model, "cumpleanios.html.hbs");
  }

  public ModelAndView detalleCumpleanios(Request req) {
    Cumpleanios cumpleanios = RepositorioCumpleanios.instancia.buscar(Long.parseLong(req.params("cumpleaniosID")));
    return new ModelAndView(cumpleanios, "detalle-cumpleanios.html.hbs");
  }

  public ModelAndView nuevoCumpleaniosVista() {
    return new ModelAndView(null, "nuevo-cumpleanios.html.hbs");
  }

  public ModelAndView crearNuevoCumpleanios(Request req, Response res) {
    Cumpleanios cumpleanios = new Cumpleanios(req.queryParams("nombre"), LocalDate.parse(req.queryParams("fecha")));
    withTransaction(() -> {
        RepositorioCumpleanios.instancia.agregar(cumpleanios);
    });
    res.redirect("/cumpleanios");
    return null;
  }
}
