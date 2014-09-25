package controllers;

import java.util.List;

import models.Alternativa;
import models.Disciplina;
import models.Professor;
import models.Questao;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class QuestaoCrud extends Controller{
	
	private static final Form<Questao> formQuest = Form.form(Questao.class);
	private static final Form<Alternativa> formAlter = Form.form(Alternativa.class);
	
	public static Result questao(){
		return ok(views.html.questao.render(null, formQuest, formAlter));
	}
	
	public static Result listagem(){
		List<Disciplina> object = Disciplina.find.findList();
		return ok(views.html.listagem.render(object));
	}
	
	public static Result parseId(Long id){
		
		return ok(views.html.questao.render(id, formQuest, formAlter));
	}
	
	public static Result gravarQuestao(){
		Form<Questao> formQuestao = formQuest.bindFromRequest();
		Form<Alternativa> formAlternativa = formAlter.bindFromRequest();
		
		String alterCorreta = Form.form().bindFromRequest().get("alterCorreta");
		String idDiscip = Form.form().bindFromRequest().get("idDiscip");
		
		if(formQuestao.hasErrors() && formAlternativa.hasErrors()){
			flash("erro", "Erro ao gravar dados");
			return ok(views.html.questao.render(Long.parseLong(idDiscip), formQuest, formAlter));
		}		
			
		
		Questao questao = formQuestao.get();
		questao.setAlterCorreta(alterCorreta);
		questao.setIdDisciplina(Long.parseLong(idDiscip));
		questao.save();
		List<Questao> listQuest = Questao.find.findList();
		long idQuest = listQuest.get(listQuest.size() - 1).getIdQuestao();
				
		Alternativa alternativa = formAlternativa.get();
		alternativa.setAlter01(alterCorreta);
		alternativa.setIdQuestao(idQuest);
		alternativa.save();
		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.QuestaoCrud.listagem());
	}

}
