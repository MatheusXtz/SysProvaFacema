package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	// Metodo da pagina principal
	public static Result index() {
		return TODO;
	}

	public static Result inicio() {
		return ok(index.render());
	}

}
