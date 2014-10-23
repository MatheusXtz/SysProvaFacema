
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
public class Status extends Model {

	@Id
	@GeneratedValue
	private Long idStatus;
	
	private String descricao;
	

	private String data;
		
    @OneToOne
	private Usuario usuario;
    
    @ManyToOne
  	private Questao questao;

	public static Model.Finder<Long, Status> find = new Model.Finder<Long, Status>(
			Long.class, Status.class);

	/**
	 * Gets e Sets
	 */
	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	
	

}

