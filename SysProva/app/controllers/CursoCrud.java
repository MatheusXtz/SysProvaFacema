package controllers;

import java.util.List;

import models.Curso;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CursoCrud extends Controller {

	private static final Form<Curso>cursoForm=Form.form(Curso.class);
	
	//Listar oc cursos
	public static Result listaCurso(){
		List<Curso>cursos= Curso.find.findList();
		return ok(views.html.curso.render(cursos));
	}
	
	//Chamar a página de cadastro
	public static Result novoCurso(){
		return ok(views.html.novoCurso.render(cursoForm));
	}
	
	//Salvar o Curso
	public static Result gravar(){
		Form<Curso>form=cursoForm.bindFromRequest();
		
		if(form.hasErrors()){
			flash("erro", "Foram identificados erros no cadastro!");
			return ok(views.html.novoCurso.render(cursoForm));
		}
		Curso curso=form.get();
		curso.save();
		flash("sucesso","Dados Gravados com sucesso");
		return redirect(routes.CursoCrud.listaCurso());
	}
	
	//Detalhar pra depois poder alterar
	public static Result detalhar(Long id){
		Form<Curso>curForm=Form.form(Curso.class).fill(Curso.find.byId(id));
		return ok(views.html.alterarCurso.render(id,curForm));
	}
	
	//Alterar O curso pelo id
	public static Result alterar(Long id) {
		Form<Curso> form = cursoForm.bindFromRequest();
		Form.form(Curso.class).fill(Curso.find.byId(id));

		Form<Curso> alterarForm = Form.form(Curso.class).bindFromRequest();
		if (alterarForm.hasErrors()) {
			return badRequest(views.html.alterarCurso.render(id, alterarForm));
		}
		alterarForm.get().update(id);
		flash("sucesso", "Curso " + alterarForm.get().getNome()
				+ " alterado com sucesso");

		return redirect(routes.CursoCrud.listaCurso());
	}
	
	//remover o curso pelo id
	public static Result remover(Long id) {
		Curso.find.ref(id).delete();
		flash("sucesso", "Curso removido com sucesso");
		return listaCurso();
	}
}