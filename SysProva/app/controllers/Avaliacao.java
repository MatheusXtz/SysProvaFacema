package controllers;

import java.util.List;

import models.Observacao;
import models.Questao;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Avaliacao extends Controller{

	public static Result avaliacaoCoord(){
		return ok(views.html.avaliacaoCoord.render());
	}
	
	public static Result avaliacaoNU(){
		return ok(views.html.avaliacaoNucleo.render());
	}
	
	public static Result avaliarQuestao(Long idDiscip, String responsavel){
		
		List<Questao> lista = Questao.find.where().eq("disciplina_id_disciplina", idDiscip).findList();
		return ok(views.html.listaQuestao.render(idDiscip, lista, responsavel));
	}
	
	public static Result registroObservacao(Long idQuestao){
		
		Observacao obs = new  Observacao();
		
		String responsavel = Form.form().bindFromRequest().get("resp");
		String idD = Form.form().bindFromRequest().get("resp");
		String descricao = Form.form().bindFromRequest().get("descricao");
		
		obs.setIdQuestao(idQuestao);
		obs.setDescricao(descricao);
		
		if(responsavel.equals("co")){
			obs.setCoord(true);
		}else{
			obs.setCoord(false);
		}
		if(responsavel.equals("nu")){
			obs.setNucleoA(true);
		}else{
			obs.setNucleoA(false);
		}
		
		obs.save();
		
		
		return redirect(routes.Avaliacao.avaliarQuestao(Long.parseLong(idD), responsavel));
	}
}
