package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Usuario extends Model {

	@Id
	@GeneratedValue
	private Long idUsuario;
	private String nome;
	@Column(nullable = false)
	private Integer matricula;
	@Column(nullable = false)
	private String senha;

	public static Model.Finder<Long, Usuario> find = new Model.Finder<Long, Usuario>(
			Long.class, Usuario.class);

	/**
	 * Gets e Sets
	 */	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
