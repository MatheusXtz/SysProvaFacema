package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Turma {

	@Id
	@GeneratedValue
	private long idTurma;
	private String descricaoTurma;
	private int qtdQuestaoTurma;
	
	public long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(long idTurma) {
		this.idTurma = idTurma;
	}
	public String getDescricao() {
		return descricaoTurma;
	}
	public void setDescricao(String descricao) {
		this.descricaoTurma = descricao;
	}
	public int getQtdQuestaoTurma() {
		return qtdQuestaoTurma;
	}
	public void setQtdQuestaoTurma(int qtdQuestaoTurma) {
		this.qtdQuestaoTurma = qtdQuestaoTurma;
	}
	
	
	
}
