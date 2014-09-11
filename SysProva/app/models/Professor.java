package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@GeneratedValue
	private long idProf;
	private String nome;
	@Column(unique = false)
	private Integer cpf;
	private String email;
	
	public long getIdProf() {
		return idProf;
	}
	public void setIdProf(long idProf) {
		this.idProf = idProf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
