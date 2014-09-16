package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Professor extends Model {

	@Id
	@GeneratedValue
	private long idProf;
	private String nome;
	@Column(unique = false)
	private Integer cpf;
	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="professor")	
	private List<Disciplina>disciplinas;
	
	
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
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
	
	public Professor() {
		this.disciplinas = new ArrayList<Disciplina>();
	}
}
