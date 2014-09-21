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
public class Curso extends Model {

	@Id
	@GeneratedValue
	private Long idCurso;

	@Constraints.Required
	private String nome;

	// Model.finder pra auxiliar nas consultas
	public static Model.Finder<Long, Curso> find = new Model.Finder<Long, Curso>(
			Long.class, Curso.class);

	// @OneToMany(cascade=CascadeType.ALL, mappedBy="curso")
	// private List<Turma> turmas;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return idCurso + ", " + nome;
	}

	public Curso() {

	}

}
