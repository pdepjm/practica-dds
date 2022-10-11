package main;

import controllers.CumpleaniosController;
import controllers.HomeController;
import controllers.LoginController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.debug.DebugScreen;

public class Routes {

    public static void main(String[] args) {
        System.out.println("Corriendo bootstrap...");
        new Bootstrap().run();
        DebugScreen.enableDebugScreen();

        System.out.println("Iniciando servidor...");
        Spark.port(8080);
        Spark.staticFileLocation("/public");
        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        CumpleaniosController cumpleaniosController = new CumpleaniosController();
        HomeController homeController = new HomeController();
        LoginController loginController = new LoginController();

        Spark.get("/home", (req, res) -> homeController.mostrarHome(), engine);

        Spark.get("/cumpleanios", (req, res) -> cumpleaniosController.listarCumpleanios(req), engine);

        Spark.get("/cumpleanios/nuevo", (req, res) -> cumpleaniosController.nuevoCumpleaniosVista(), engine);

        Spark.get("/cumpleanios/:cumpleaniosID", (req, res) -> cumpleaniosController.detalleCumpleanios(req), engine);

        Spark.post("/cumpleanios", (req,res) -> cumpleaniosController.crearNuevoCumpleanios(req,res), engine);

        Spark.get("/login", (req, res) -> loginController.mostrarLogin(), engine);

        Spark.post("/login", (req, res) -> loginController.iniciarSesion(req, res), engine);

        System.out.println("Servidor iniciado!");

    }


}
