package models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;

@Entity
public class StatusProva extends Model {

	@Id
	@GeneratedValue
	private Long idStatusProva;
	
	private String descricao;
	
	@OneToOne
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@ManyToOne
	private Prova prova;
	

	private static Model.Finder<Long, StatusProva> find = new Model.Finder<Long, StatusProva>(
			Long.class, StatusProva.class);

	/**
	 * Gets e Sets
	 */
	public Long getIdStatusProva() {
		return idStatusProva;
	}

	public void setIdStatusProva(Long idStatusProva) {
		this.idStatusProva = idStatusProva;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}
	
	

}
