package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class QuestoesProva extends Model {

	@ManyToOne(cascade = CascadeType.ALL)
	private Prova provas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Questao questoes;

	private static Model.Finder<Long, QuestoesProva> find = new Model.Finder<Long, QuestoesProva>(
			Long.class, QuestoesProva.class);

	/**
	 * Gets e Sets
	 */
	public Prova getProvas() {
		return provas;
	}

	public void setProvas(Prova provas) {
		this.provas = provas;
	}

	public Questao getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao questoes) {
		this.questoes = questoes;
	}

}
