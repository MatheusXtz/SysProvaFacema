package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Constraint;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Curso extends Model{

	@Id
	@GeneratedValue
	private long idCurso;

	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="curso")  
	private List<Turma> turmas;
    
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	

	public long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso() {
		this.turmas = new ArrayList<Turma>();
	}

}
