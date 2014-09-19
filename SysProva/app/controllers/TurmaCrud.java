package controllers;

import java.util.List;

import models.Curso;
import models.Turma;
import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class TurmaCrud extends Controller{

	private static final Form<Turma> pForm = Form.form(Turma.class);
	public static Result listarCursor() {
        List<Curso> curso = Curso.find.findList();
        
		return ok(views.html.turma.render(curso,pForm));

	}
	
	public static Result pegarTurma() {
		
		Form<Turma>form=pForm.bindFromRequest();
		
		Turma professor=form.get();
//		professor.save();
		System.out.println(professor.getIdTurma());
		System.out.println(professor.getDescricaoTurma());
		System.out.println(professor.getCargaHoaria());
		System.out.println(professor.getQtdQuestaoTurma());
		System.out.println(professor.getCurso());
		
		return redirect(routes.TurmaCrud.listarCursor());

	}


}



