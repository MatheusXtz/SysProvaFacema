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
public class Disciplina extends Model {

	@Id
	@GeneratedValue
	private Long idDisciplina;
	private String descricaoDisciplina;
	private Integer qtdQuestaoDisciplina;
	private int cargaHoraria;

	public static Model.Finder<Long, Disciplina> find = new Model.Finder<Long, Disciplina>(
			Long.class, Disciplina.class);

	@ManyToOne
	private Professor professor = new Professor();
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
	private List<Questao> questoes;

	/**
	 * Gets e Sets
	 */
	public Long getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getDescricaoDisciplina() {
		return descricaoDisciplina;
	}

	public void setDescricaoDisciplina(String descricaoDisciplina) {
		this.descricaoDisciplina = descricaoDisciplina;
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
	
	public long getIdProfessor(){
		return professor.getIdProf();
	}
	
	public void setIdProfessor(long idProf){
		this.professor.setIdProf(idProf);
	}

	public Disciplina() {
		this.questoes = new ArrayList<Questao>();
	}

}
