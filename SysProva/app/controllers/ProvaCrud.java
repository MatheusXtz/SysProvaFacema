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

	public static Result gerarProva() throws JRException {
		List<QuestAlterAux> lista = new ArrayList<QuestAlterAux>();
		for (Turma turma : Turma.find.findList()) {

			for (Disciplina disci : Disciplina.find.where()
					.eq("turma_id_turma", turma.getIdTurma()).findList()) {

				for (Questao questao : Questao.find
						.where()
						.eq("disciplina_id_disciplina", disci.getIdDisciplina())
						.findList()) {

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
						q.setNomeTurma(turma.getNome());
						q.setNomeDisci(disci.getNome());

						lista.add(q);

					}
				}
			}
		}
		int cont = 0;

		ArrayList<QuestAlterAux> prova = new ArrayList<QuestAlterAux>();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNomeTurma().equals("Bloco 1-ADS")) {
				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			} else if (lista.get(i).getNomeTurma().equals("Bloco 3-ADS")) {
				QuestAlterAux q = new QuestAlterAux();
				q.setEnunciado(lista.get(i).getEnunciado());
				q.setAlter01(lista.get(i).getAlter01());
				q.setAlter02(lista.get(i).getAlter02());
				q.setAlter03(lista.get(i).getAlter03());
				q.setAlter04(lista.get(i).getAlter04());
				q.setAlter05(lista.get(i).getAlter05());
				q.setNomeTurma(lista.get(i).getNomeTurma());
				q.setNomeDisci(lista.get(i).getNomeDisci());
				prova.add(q);

				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			} else if (lista.get(i).getNomeTurma().equals("Bloco 2-ADS")) {
				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			} else if (lista.get(i).getNomeTurma().equals("Bloco 4-ADS")) {
				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			} else if (lista.get(i).getNomeTurma()
					.equals("Bloco 1-Fisioterapia")) {
				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			} else if (lista.get(i).getNomeTurma().equals("Bloco 1-Enfermagem")) {
				System.out.println(lista.get(i).getNomeTurma());
				System.out.println(lista.get(i).getNomeDisci());
				System.out.println(lista.get(i).getEnunciado());
				System.out.println(lista.get(i).getAlter01());
				System.out.println(lista.get(i).getAlter02());
				System.out.println(lista.get(i).getAlter03());
				System.out.println(lista.get(i).getAlter04());
				System.out.println(lista.get(i).getAlter05());
				System.out.println("_________________________________");
			}

		}
		gerarPdf(prova);
		flash("sucesso", "Prova do "+ prova.get(0).getNomeTurma()+" gerada com sucesso");
		return redirect(routes.ProvaCrud.gerar());

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
