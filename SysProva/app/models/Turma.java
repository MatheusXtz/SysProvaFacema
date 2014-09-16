package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Turma extends Model{

	@Id
	@GeneratedValue
	private long idTurma;
	private String descricaoTurma;
	private int qtdQuestaoTurma;
	
	@ManyToOne
	private Curso curso;
	
	
	public long getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(long idTurma) {
		this.idTurma = idTurma;
	}
	
	public String getDescricaoTurma() {
		return descricaoTurma;
	}
	public void setDescricaoTurma(String descricaoTurma) {
		this.descricaoTurma = descricaoTurma;
	}
	
	public int getQtdQuestaoTurma() {
		return qtdQuestaoTurma;
	}
	public void setQtdQuestaoTurma(int qtdQuestaoTurma) {
		this.qtdQuestaoTurma = qtdQuestaoTurma;
	}
	
	public Turma() {
		
	}
	
}
