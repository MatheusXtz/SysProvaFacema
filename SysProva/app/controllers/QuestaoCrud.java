package controllers;

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

public class QuestaoCrud extends Controller{
	
	private static final Form<Questao> formQuest = Form.form(Questao.class);
	private static final Form<Alternativa> formAlter = Form.form(Alternativa.class);
	
	
	public static Result listagem(){
//		List<Curso> curso = Curso.find.findList();
		List<Turma> lTuma = Turma.find.where().eq("curso_id_curso", 1).findList();
		System.out.println("Turma: "+lTuma.size()+" --- "+"Curso: "+lTuma.get(4).getIdCurso());
		List<Prova> lProva = Prova.find.where().eq("turma_id_turma", 1).findList();
		System.out.println("Prova: "+lProva.size());
		System.out.println(lProva.get(0).getIdTurma());
		
//		for(Curso c : Curso.find.findList()){
//		for(Turma t : lTuma){
//		 List<Prova> list = Prova.find.where().eq("turma_id_turma", t.getIdTurma()).findList();
//		 System.out.println(list.size());
//		}
//		}
		return ok(views.html.listagem.render());
	}
	
	public static Result parseId(Long idDiscip){
		
		return ok(views.html.questao.render(idDiscip));
	}
public static Result teste(Long idDiscip){
		
		return ok(views.html.questao.render(idDiscip));
	}
	
	public static Result gravarQuestao(){
		Form<Questao> formQuestao = formQuest.bindFromRequest();
		Form<Alternativa> formAlternativa = formAlter.bindFromRequest();
		
		
		String idDiscip = Form.form().bindFromRequest().get("idDiscip");
		String idProva = Form.form().bindFromRequest().get("idProva");
		
		if(formQuestao.hasErrors() && formAlternativa.hasErrors()){
			flash("erro", "Erro ao gravar dados");
			return ok(views.html.questao.render(Long.parseLong(idDiscip)));
		}		
			
		
		Questao questao = formQuestao.get();		
		questao.setIdDisciplina(Long.parseLong(idDiscip));
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
