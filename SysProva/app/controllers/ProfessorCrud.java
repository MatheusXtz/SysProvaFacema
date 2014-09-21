package controllers;

import java.util.List;

import models.Curso;
import models.Professor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ProfessorCrud extends Controller {

	private static final Form<Professor> pForm = Form.form(Professor.class);

	public static Result listarProfessor() {
		List<Professor> professores = Professor.find.findList();
		
		return ok(views.html.professor.render(professores));

	}

	public static Result novoProfessor() {
		return ok(views.html.novoProfessor.render(pForm));
	}

	public static Result gravarProfessor() {

		Form<Professor> form = pForm.bindFromRequest();
		
		if (form.hasErrors()) {
			flash("erro", "Erro ao tentar salvar professor");
			
			return ok(views.html.novoProfessor.render(pForm));
		}
		
		Professor professor = form.get();
		professor.save();
		System.out.println(professor.getNome());
		flash("sucesso", "Professor Inserido com sucesso!");
		
		return redirect(routes.ProfessorCrud.listarProfessor());

	}

	public static Result detalhar(Long id) {
		Form<Professor> proForm = Form.form(Professor.class).fill(
				Professor.find.byId(id));
		
		return ok(views.html.alterarProfessor.render(id, proForm));
	}

	public static Result alterarProfessor(Long id) {
		Form<Professor> form = pForm.bindFromRequest();
		Form.form(Professor.class).fill(Professor.find.byId(id));

		Form<Professor> alterarProfe = Form.form(Professor.class)
				.bindFromRequest();
		
		if (alterarProfe.hasErrors()) {
			return badRequest(views.html.alterarProfessor.render(id,
					alterarProfe));
		}
		
		alterarProfe.get().update(id);
		flash("sucesso", "Professor " + alterarProfe.get().getNome()
				+ " alterado com sucesso");

		return redirect(routes.ProfessorCrud.listarProfessor());
	}

	public static Result removerProfessor(Long id) {
		Professor.find.ref(id).delete();
		flash("sucesso", "Professor removido com sucesso");
		
		return listarProfessor();
	}
}
