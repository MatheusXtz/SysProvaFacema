package controllers;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Query;
import com.avaje.ebean.SqlQuery;

import models.Alternativa;
import models.Disciplina;
import models.Prova;
import models.QuestAlterAux;
import models.Questao;
import models.Turma;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


public class ProvaCrud extends Controller {

	public static Result prova() {
		List<Prova> provas = Prova.find.findList();
		return ok(views.html.prova.render(provas));
	}

	public static Result gerar() {
		return ok(views.html.gerarProva.render());
	}
    
	public static Result listarTurmas() {
		return ok(views.html.listaTurmas.render());
	}
	public static Result gravarProva() {

		List<Turma> turmas = Turma.find.findList();
		List<Prova> provas = Prova.find.findList();

		String dInicio = Form.form().bindFromRequest().get("dataInicial");
		String dFinal = Form.form().bindFromRequest().get("dataFinal");

		for (Turma turma : turmas) {
			if (turma != null) {
				Prova prova = new Prova();
				prova.setDataInicial(dInicio);
				prova.setDataFinal(dFinal);
				prova.setIdTurma(turma.getIdTurma());
				prova.save();
			}

		}

		return ok(views.html.prova.render(provas));
	}
	
	
	public static Result organizarProva(Long idTurma) throws JRException{
		List<QuestAlterAux>prova= new ArrayList<QuestAlterAux>();
	    Long idProva=Prova.findByIdProva(idTurma);
	    List<Questao>enunciado=Questao.find.where().eq("prova_id_prova", idProva).findList();
	    
	   for (Questao questao : enunciado) {
		for (Alternativa alter : Alternativa.find.where()
				.eq("questao_id_questao", questao.getIdQuestao())
				.findList()){
			  QuestAlterAux q= new QuestAlterAux();
			  q.setEnunciado(questao.getEnunciado());
			  q.setAlter01(alter.getAlter01());
			  q.setAlter02(alter.getAlter02());
			  q.setAlter03(alter.getAlter03());
			  q.setAlter04(alter.getAlter04());
			  q.setAlter05(alter.getAlter05());
			  q.setNomeDisci("AAAA");
			  prova.add(q);
			  
		}
	}
      gerarPdf(prova);
      return ok(views.html.gerarProva.render());
	}
	

	public static void gerarPdf(List<QuestAlterAux> teste) throws JRException {
		JasperReport report = JasperCompileManager
				.compileReport("ireport/Relatorio.jrxml");

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(teste));

		JasperExportManager.exportReportToPdfFile(print, "ireport/prova.pdf");
		System.out.println("Relatorio gerado.");

	}

}
