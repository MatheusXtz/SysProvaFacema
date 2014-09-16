package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;
@Entity
public class Prova extends Model{

	@Id
	@GeneratedValue
	private long idProva;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="prova")
	private List<Disciplina> disciplinas;
	@OneToOne
	private Turma turma;
	

	public long getIdProva() {
		return idProva;
	}

	public void setIdProva(long idProva) {
		this.idProva = idProva;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Turma getTurma() {
		return turma;
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Prova() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
	
}
