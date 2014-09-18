package controllers;


import java.util.List;

import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class TurmaCrud extends Controller {
	public static final Form<Turma> tForm=Form.form(Turma.class);
	public static Result listarTurma(){
		List<Turma>turmas= Turma.find.findList();
		return ok(views.html.turma.render(turmas));
	}
	public static Result novaTurma(){
		return ok(views.html.novaTurma.render(tForm));
	}
	
	public static Result gravarTurma(){
		Form<Turma>form=tForm.bindFromRequest();
		if(form.hasErrors()){
			flash("erro","Erro ao tentar salvar turma");
			return ok(views.html.novaTurma.render(tForm));
		}
		Turma turma=form.get();
		turma.save();
		System.out.println(turma.getDescricaoTurma());
		flash("sucessor","Turma salva com sucesso");
		return redirect(routes.TurmaCrud.listarTurma());
		
	}

}
