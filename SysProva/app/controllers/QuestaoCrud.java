package controllers;

import models.Alternativa;
import models.Questao;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class QuestaoCrud extends Controller{
	
	private static final Form<Questao> formQuest = Form.form(Questao.class);
	private static final Form<Alternativa> formAlter = Form.form(Alternativa.class);
	
	public static Result questao(){
		return ok(views.html.questao.render(formQuest, formAlter));
	}

}
