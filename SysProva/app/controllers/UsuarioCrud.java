package controllers;

import java.util.List;

import models.Curso;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UsuarioCrud extends Controller {
	private static Form<Usuario>userForm=Form.form(Usuario.class);
	
	public static Result listarUsuario(){
		List<Usuario> usuarios = Usuario.find.findList();
		return ok(views.html.usuario.render(usuarios,userForm));
	}
	
	public static Result gravarUsuario(){
		Form<Usuario> form=userForm.bindFromRequest();
		if(form.hasErrors()){
			flash("erro","Erro ao cadastrar usuário");
			return redirect(routes.UsuarioCrud.listarUsuario());
		}
		Usuario user=form.get();
		user.save();
		flash("sucesso","usuario cadastrado com sucesso");
		return redirect(routes.UsuarioCrud.listarUsuario());
	}
	public static Result detalhar(Long id) {
		Form<Usuario> userForm = Form.form(Usuario.class).fill(Usuario.find.byId(id));
		return ok(views.html.alterarUsuario.render(id, userForm));
	}
	
	public static Result alterarUsuario(Long id){
		Form<Usuario>form= userForm.bindFromRequest();
		Form.form(Usuario.class).fill(Usuario.find.byId(id));
		
		Form<Usuario>alterForm=Form.form(Usuario.class).bindFromRequest();
		if(alterForm.hasErrors()){
			flash("erro","erro ao alterar usuario");
			return badRequest(views.html.alterarUsuario.render(id, alterForm));
		}
		alterForm.get().update(id);
		flash("sucesso", "Usuario alterado com sucesso");

		return redirect(routes.UsuarioCrud.listarUsuario());
		
	}
	public static Result remover(Long id) {
		Usuario.find.ref(id).delete();
		flash("sucesso", "Usuario removido com sucesso");
		return listarUsuario();
	}

}
