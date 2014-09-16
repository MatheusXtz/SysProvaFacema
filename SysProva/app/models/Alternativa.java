package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
@Entity
public class Alternativa extends Model {

	@Id
	@GeneratedValue
	private long idAlternativa;
	private String alternativa;
	private boolean alterCorreta;
	@ManyToOne
	private Questao questao;
	
	public long getIdAlternativa() {
		return idAlternativa;
	}
	public void setIdAlternativa(long idAlternativa) {
		this.idAlternativa = idAlternativa;
	}
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	public boolean isAlterCorreta() {
		return alterCorreta;
	}
	public void setAlterCorreta(boolean alterCorreta) {
		this.alterCorreta = alterCorreta;
	}
	public Questao getQuestao() {
		return questao;
	}
	public void setQuestao(Questao questao) {
		this.questao = questao;
	}
}
