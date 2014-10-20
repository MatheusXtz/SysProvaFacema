package controllers;

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
		return ok(views.html.listaQuestao.render(idDiscip));
	}
}
