package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questao {

	@Id
	@GeneratedValue
	private long idQuestao;
	private String enunciado;
	private char alternativaCorreta;
	
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
	public char getAlternativaCorreta() {
		return alternativaCorreta;
	}
	public void setAlternativaCorreta(char alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
}
