package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class ColecaoStatus  extends Model{

	private static final long serialVersionUID = -288558695065055852L;
	
	@Id
	@GeneratedValue
	private Long idColecaoS;

	
	/**
	 * 
	 * Gets e Sets
	 */
	public Long getIdColecaoS() {
		return idColecaoS;
	}
	public void setIdColecaoS(Long idColecaoS) {
		this.idColecaoS = idColecaoS;
	}

	
	

	
}
