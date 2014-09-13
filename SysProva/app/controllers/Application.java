package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
//	Metodo da pagina principal
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result bemVindo() {
        return ok(index.render("Minha primeira aplição"));
    }

}
