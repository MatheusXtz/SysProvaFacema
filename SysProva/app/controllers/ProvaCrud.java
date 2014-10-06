package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.SqlQuery;

import models.Prova;
import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class ProvaCrud extends Controller{
	
	public static Result prova(){
		List<Prova> provas = Prova.find.findList();
		return ok(views.html.prova.render(provas));
	}

	public static Result gravarProva(){

		List<Turma> turmas = Turma.find.findList();
		List<Prova> provas = Prova.find.findList();
		
		String dInicio = Form.form().bindFromRequest().get("dataInicial");
		String dFinal = Form.form().bindFromRequest().get("dataFinal");
		
		
		
		for (Turma turma : turmas) {
			Prova prova = new Prova();			
			prova.setDataInicial(dInicio);
			prova.setDataFinal(dFinal);
			prova.setIdTurma(turma.getIdTurma());
			prova.save();
			
		}	

		return ok(views.html.prova.render(provas));
	}
}

