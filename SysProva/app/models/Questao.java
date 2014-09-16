package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.h2.engine.Mode;

import play.db.ebean.Model;

@Entity
public class Questao extends Model{

	@Id
	@GeneratedValue
	private long idQuestao;
	private String enunciado;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="questao")
	private List<Alternativa> alternativas;
	@ManyToOne
	private Disciplina disciplina;
	
	public long getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(long idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	public String getEnunciado() {
		return enunciado;
	}	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}	
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
	
	public Questao() {
		this.alternativas = new ArrayList<Alternativa>();
	}
}