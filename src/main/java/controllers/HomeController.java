package controllers;

import model.Cumpleanios;
import model.RepositorioCumpleanios;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeController {

  public ModelAndView mostrarHome(){
    List<Cumpleanios> cumpleanios = new ArrayList<>();
    cumpleanios.add(RepositorioCumpleanios.instancia.listar().get(0));
    cumpleanios.add(RepositorioCumpleanios.instancia.listar().get(1));
    cumpleanios.add(RepositorioCumpleanios.instancia.listar().get(2));
    Map<String,Object> model = new HashMap<>();
    model.put("cumpleanios", cumpleanios);
    return new ModelAndView(model, "home.html.hbs");
  }
}
