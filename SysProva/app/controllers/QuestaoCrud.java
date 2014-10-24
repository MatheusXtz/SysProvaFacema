package controllers;

import java.time.LocalDate;
import java.util.List;

import com.avaje.ebean.Ebean;

import models.Alternativa;
import models.Curso;
import models.Disciplina;
import models.Professor;
import models.Prova;
import models.Questao;
import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class QuestaoCrud extends Controller {

	private static final Form<Questao> formQuest = Form.form(Questao.class);
	private static final Form<Alternativa> formAlter = Form
			.form(Alternativa.class);

	public static Result listagem() {

		return ok(views.html.listagem.render());
	}

	public static Result parseId(Long idDiscip, Long idProva) {

		return ok(views.html.questao.render(idDiscip, idProva));
	}

	public static Result gravarQuestao() {
		Form<Questao> formQuestao = formQuest.bindFromRequest();
		Form<Alternativa> formAlternativa = formAlter.bindFromRequest();
	
		String idDiscip = Form.form().bindFromRequest().get("idDiscip");
		String idProva = Form.form().bindFromRequest().get("idProva");

		if (formQuestao.hasErrors() && formAlternativa.hasErrors()) {
			flash("erro", "Erro ao gravar dados");
			return ok(views.html.questao.render(Long.parseLong(idDiscip),
					Long.parseLong(idProva)));
		}

		Questao questao = formQuestao.get();
		questao.setIdDisciplina(Long.parseLong(idDiscip));
		questao.setIdProva(Long.parseLong(idProva));
		questao.setAvalCoord(true);
		questao.setAvalNucleo(true);

		int mes = LocalDate.now().getMonth().getValue();
		if (mes <= 6) {
			questao.setPeriodo(LocalDate.now().getYear() + ".1");
		} else {
			questao.setPeriodo(LocalDate.now().getYear() + ".2");
		}
		questao.save();

		List<Questao> listQuest = Questao.find.findList();
		long idQuest = listQuest.get(listQuest.size() - 1).getIdQuestao();

		Alternativa alternativa = formAlternativa.get();
		alternativa.setIdQuestao(idQuest);
		alternativa.save();
		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.QuestaoCrud.listagem());
	}

}
