package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Prova extends Model {

	@Id
	@GeneratedValue
	private Long idProva;

	public static Model.Finder<Long, Prova> find = new Model.Finder<Long, Prova>(
			Long.class, Prova.class);
	
	@OneToOne
	private Turma turma;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataProva;
	
	
	/**
	 * Gets e Sets
	 */
	public Long getIdProva() {
		return idProva;
	}

	public void setIdProva(Long idProva) {
		this.idProva = idProva;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Calendar getDataProva() {
		return dataProva;
	}

	public void setDataProva(Calendar dataProva) {
		this.dataProva = dataProva;
	}

	

	

}
