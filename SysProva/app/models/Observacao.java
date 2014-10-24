package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Observacao extends Model{
	
	@Id
	@GeneratedValue
	private Long idObs;
	private String descricao;
	
	@ManyToOne
	private Questao questao = new Questao();
	
	private boolean coord;
	private boolean nucleoA;
	
	/**
	 * 
	 * Gets e Sets
	 */
	
	public Long getIdObs() {
		return idObs;
	}
	public void setIdObs(Long idObs) {
		this.idObs = idObs;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public long getIdQuestao() {
		return questao.getIdQuestao();
	}
	public void setIdQuestao(long idQuestao) {
		this.questao.setIdQuestao(idQuestao);;
	}
	public boolean isCoord() {
		return coord;
	}
	public void setCoord(boolean coord) {
		this.coord = coord;
	}
	public boolean isNucleoA() {
		return nucleoA;
	}
	public void setNucleoA(boolean nucleoA) {
		this.nucleoA = nucleoA;
	}

	
}
