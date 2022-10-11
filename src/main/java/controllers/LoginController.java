package controllers;

import model.RepositorioUsuarios;
import model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.NoSuchElementException;

public class LoginController {

  public ModelAndView mostrarLogin() {
    return new ModelAndView(null, "login.html.hbs");
  }

  public ModelAndView iniciarSesion(Request req, Response res) {
    try {
      Usuario usuario = RepositorioUsuarios.instancia.buscarPorUsuarioYContrasenia(req.queryParams("user"), req.queryParams("pass"));
      res.redirect("/home");
      //res.cookie("user_id", usuario.getId());
    } catch (NoSuchElementException e) {
      res.redirect("/login"); //redirigir agregando un mensaje de error
    }
    return null;
  }
}
