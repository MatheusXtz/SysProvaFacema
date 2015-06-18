
package controllers;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

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

		return redirect(routes.ProvaCrud.prova());
	}

	public static Result organizarProva(Long idTurma) throws JRException {
		List<QuestAlterAux> prova = new ArrayList<QuestAlterAux>();
		Long idProva = Prova.findByIdProva(idTurma);
		List<Questao> enunciado = Questao.find.where()
				.eq("prova_id_prova", idProva).findList();

		for (Questao questao : enunciado) {
			for (Alternativa alter : Alternativa.find.where()
					.eq("questao_id_questao", questao.getIdQuestao())
					.findList()) {
				QuestAlterAux q = new QuestAlterAux();
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
	
		flash("sucesso", "Prova gerada com sucesso!");
		teste();
		return redirect(routes.ProvaCrud.listarTurmas());
	}
	
	public static void gerarPdf(List<QuestAlterAux> teste) throws JRException {
		JasperReport report = JasperCompileManager
				.compileReport("ireport/Relatorio.jrxml");

//		Map<String, Object> parament = new HashMap<String, Object>();
//		parament.put("SUBREPORT_DIR", "ireport/questoes.jasper");

		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(teste));

		viewReportFrame(print);

//		 JasperExportManager.exportReportToPdfFile(print,
//		 "ireport/prova.pdf");
		System.out.println("Relatorio gerado.");

	}

	private static void viewReportFrame(JasperPrint print) {
		JRViewer view = new JRViewer(print);

		JFrame frameReport = new JFrame();

		frameReport.add(view, BorderLayout.CENTER);
		frameReport.setSize(500, 500);
		frameReport.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameReport.setVisible(true);
	}
	
	



	private static void teste(){
		
		
		List<Object> ids = Disciplina.find.where().eq("turma_id_turma", 1).findIds();
		
		List<Questao> a = null;
		for (Object object : ids) {
			System.out.println("Disciplina: "+object);
			List<Questao> q = Questao.find.where().eq("disciplina_id_disciplina", object).findList();			
			a = new ArrayList<Questao>();
			for (Questao questao : q) {
				a.add(questao);
				Collections.shuffle(a);
			}			
		}
		for (Questao questao : a) {
			System.out.println("Cod: "+questao.getIdQuestao());
			System.out.println("Enunciado: "+questao.getEnunciado());
			System.out.println("====================================");
		}
	}
	
}

