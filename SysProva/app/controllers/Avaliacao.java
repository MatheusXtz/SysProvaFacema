package controllers;

import java.util.List;

import models.Questao;
import play.mvc.Controller;
import play.mvc.Result;

public class Avaliacao extends Controller{

	public static Result avaliacaoCoord(){
		return ok(views.html.avaliacaoCoord.render());
	}
	
	public static Result avaliacaoNU(){
		return ok(views.html.avaliacaoNucleo.render());
	}
	
	public static Result avaliarQuestao(Long idDiscip){
		
		List<Questao> lista = Questao.find.where().eq("disciplina_id_disciplina", idDiscip).findList();
		return ok(views.html.listaQuestao.render(idDiscip, lista));
	}
}
