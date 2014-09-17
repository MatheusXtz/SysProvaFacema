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
import play.db.ebean.Model.Finder;

@Entity
public class Professor extends Model {

	@Id
	@GeneratedValue
	private Long idProf;
	private String nome;
	@Column(unique = false)
	private Long cpf;
	private String email;
	
	public static Model.Finder<Long, Professor>find= new Model.Finder<Long, Professor>(Long.class,Professor.class);
	
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
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
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
