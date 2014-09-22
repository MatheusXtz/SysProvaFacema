package controllers;

import java.util.List;

import models.Disciplina;
import models.Professor;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class DisciplinaCrud extends Controller {

	private static final Form<Disciplina> formDiscip = Form
			.form(Disciplina.class);

	public static Result listarDisciplina() {
		List<Professor> professor = Professor.find.findList();
		List<Disciplina> disciplina = Disciplina.find.findList();
		return ok(views.html.disciplina.render(professor, formDiscip,
				disciplina));
	}

	public static Result gravarDisciplina() {
		Form<Disciplina> form = formDiscip.bindFromRequest();
		String idProf = Form.form().bindFromRequest().get("idProf");

		if (form.hasErrors()) {
			flash("erro", "Erro ao gravar dados");
			return redirect(routes.DisciplinaCrud.listarDisciplina());
		}

		Disciplina disciplina = form.get();
		disciplina.setIdProfessor(Long.parseLong(idProf));
		disciplina.save();
		flash("sucesso", "Dados Gravados com Sucesso");

		return redirect(routes.DisciplinaCrud.listarDisciplina());
	}

	public static Result detalharDisciplina(Long id) {
		
		Form<Disciplina> formD = Form.form(Disciplina.class).fill(
				Disciplina.find.byId(id));
		List<Professor> professor = Professor.find.findList();

		return ok(views.html.alterarDisciplina.render(id, formD, professor));
	}

	public static Result alterarDisciplina(Long id) {
		
		Form.form(Disciplina.class).fill(Disciplina.find.byId(id));
		List<Professor> professor = Professor.find.findList();
		Form<Disciplina> alterForm = Form.form(Disciplina.class)
				.bindFromRequest();
		if (alterForm.hasErrors()) {
			return badRequest(views.html.alterarDisciplina.render(id,
					alterForm, professor));
		}
		String idProf = Form.form().bindFromRequest().get("idProf");
		alterForm.get().setIdProfessor(Long.parseLong(idProf));
		alterForm.get().update(id);
		flash("sucesso", "Disciplina " + alterForm.get().getDescricaoDisciplina()
				+ " alterado com sucesso");

		return redirect(routes.DisciplinaCrud.listarDisciplina());
	}

	public static Result removerDisciplina(Long id) {
		Disciplina.find.ref(id).delete();
		flash("sucesso", "Disciplina removida com sucesso");
		return listarDisciplina();
	}
}
