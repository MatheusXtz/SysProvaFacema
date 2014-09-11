package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue
	private long idDisciplina;
	private String descicaoDisciplina;
	private Integer qtdQuestaoDisciplina;
	private int cargaHoraria;
	
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
	

}
