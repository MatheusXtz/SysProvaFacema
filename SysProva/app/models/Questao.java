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
import play.db.ebean.Model.Finder;

@Entity
public class Questao extends Model {

	@Id
	@GeneratedValue
	private Long idQuestao;
	
	private String enunciado;

	public static Model.Finder<Long, Questao> find = new Model.Finder<Long, Questao>(
			Long.class, Questao.class);
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questao")
	private List<Alternativa> alternativas;
	
	@ManyToOne
	private Disciplina disciplina;

	public Long getIdQuestao() {
		return idQuestao;
	}

	public void setIdQuestao(Long idQuestao) {
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