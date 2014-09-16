package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Disciplina extends Model{
	
	@Id
	@GeneratedValue
	private long idDisciplina;
	private String descicaoDisciplina;
	private Integer qtdQuestaoDisciplina;
	private int cargaHoraria;
	
	@ManyToOne
	private Professor professor;	
	@ManyToOne
	private Prova prova;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="disciplina")
	private List<Questao> questoes;
	
	public long getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getDescicaoDisciplina() {
		return descicaoDisciplina;
	}
	public void setDescicaoDisciplina(String descicaoDisciplina) {
		this.descicaoDisciplina = descicaoDisciplina;
	}
	public Integer getQtdQuestaoDisciplina() {
		return qtdQuestaoDisciplina;
	}
	public void setQtdQuestaoDisciplina(Integer qtdQuestaoDisciplina) {
		this.qtdQuestaoDisciplina = qtdQuestaoDisciplina;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Disciplina() {
		this.questoes = new ArrayList<Questao>();
	}

}
