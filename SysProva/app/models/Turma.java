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
import play.db.ebean.Model.Finder;

@Entity
public class Turma extends Model {

	@Id
	@GeneratedValue
	private Long idTurma;
	private String descricaoTurma;
	private int qtdQuestaoTurma;
	private int cargaHoraria;

	public static Model.Finder<Long, Turma> find = new Model.Finder<Long, Turma>(
			Long.class, Turma.class);

	@ManyToOne
	private Curso curso = new Curso();

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public void setIdTurma(long idTurma) {

		this.idTurma = idTurma;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoaria) {
		this.cargaHoraria = cargaHoaria;
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

	public long getIdCurso() {
		return curso.getIdCurso();
	}

	public void setIdCurso(Long idCurso) {
		this.curso.setIdCurso(idCurso);
	}

}
