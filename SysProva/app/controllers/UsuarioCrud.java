package controllers;

import java.util.List;

import models.Curso;
import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.usuario;

public class UsuarioCrud extends Controller {
	private static Form<Usuario> userForm = Form.form(Usuario.class);

	public static Result listarUsuario() {
		List<Usuario> usuarios = Usuario.find.findList();
		return ok(views.html.usuario.render(usuarios, userForm));
	}

	public static Result gravarUsuario() {
		Form<Usuario> form = userForm.bindFromRequest();
		if (form.hasErrors()) {
			flash("erro", "Erro ao cadastrar usuário");
			return redirect(routes.UsuarioCrud.listarUsuario());
		}
		Usuario user = form.get();
		user.save();
		flash("sucesso", "usuario cadastrado com sucesso");
		return redirect(routes.UsuarioCrud.listarUsuario());
	}

	public static Result detalhar(Long id) {
		Form<Usuario> userForm = Form.form(Usuario.class).fill(
				Usuario.find.byId(id));
		return ok(views.html.alterarUsuario.render(id, userForm));
	}

	public static Result alterarUsuario(Long id) {
		Form<Usuario> form = userForm.bindFromRequest();
		Form.form(Usuario.class).fill(Usuario.find.byId(id));

		Form<Usuario> alterForm = Form.form(Usuario.class).bindFromRequest();
		if (alterForm.hasErrors()) {
			flash("erro", "erro ao alterar usuario");
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

	// Verifica os dados, faz a comparação e redireciona pra página
	public static Result login() {
        //pegando o que vem do formulario da pagina de logar
		Form<Usuario> form = userForm.bindFromRequest();
		String matricula = Form.form().bindFromRequest().get("matricula");
		Integer matri = Integer.parseInt(matricula);
		String senha = Form.form().bindFromRequest().get("senha");

		List<Usuario> user = Usuario.find.findList();
		//Verificar a autenticidade
		for (Usuario usuario : user) {
			if (usuario.getMatricula().equals(matri)
					&& usuario.getSenha().equals(senha)) {
				flash("sucesso", "Login efetuado com sucesso");
				return redirect(routes.UsuarioCrud.listarUsuario());
			}
		}

		flash("erro", "Login ou senha errados");
		return redirect(routes.UsuarioCrud.autenticar());

	}

	// Chama a pagina de autenticação
	public static Result autenticar() {
		Form<Usuario> form = userForm.bindFromRequest();
		return ok(views.html.autenticar.render(form));

	}

}
