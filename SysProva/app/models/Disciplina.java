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
import play.db.ebean.Model.Finder;

@Entity
public class Disciplina extends Model{
	
	@Id
	@GeneratedValue
	private Long idDisciplina;
	private String descicaoDisciplina;
	private Integer qtdQuestaoDisciplina;
	private int cargaHoraria;
	
	public static Model.Finder<Long, Disciplina> find= new Model.Finder<Long, Disciplina>(Long.class,Disciplina.class);
	
	@ManyToOne
	private Professor professor;	
	@ManyToOne
	private Prova prova;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="disciplina")
	private List<Questao> questoes;
	
	public Long getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(Long idDisciplina) {
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
