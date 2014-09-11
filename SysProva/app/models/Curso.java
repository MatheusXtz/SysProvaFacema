package models;

import java.util.ArrayList;
import java.util.Collection;
import javax.validation.Constraint;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Curso{

	@Id
	@GeneratedValue
	private long idCurso;

	private String nome;
	
    @OneToMany
    @JoinTable(name="Curs_Tur",
    joinColumns=@JoinColumn(name="Curs_Id"),
    inverseJoinColumns=@JoinColumn(name="Tur_id"))
	private Collection<Turma> turmas= new ArrayList<Turma>();
    
	public Collection<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Collection<Turma> turmas) {
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

}
