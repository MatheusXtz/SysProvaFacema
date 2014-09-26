package controllers;

import models.Usuario;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	// Metodo da pagina principal
	 private static final Form<Usuario> formUser = Form.form(Usuario.class);
	public static Result index() {
		return TODO;
	}

	public static Result inicio() {
		return ok(index.render());
	}
	
	public static Result login(){
		return ok(login.render(formUser));
	}

}
