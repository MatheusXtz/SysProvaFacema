package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Adicionar {
public static void main(String[] args) {
	//testando aqui
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("teste");
	EntityManager manager= factory.createEntityManager();
	
	manager.getTransaction().begin();
	Turma t= new Turma();
	t.setDescricao("Bloco 3");
	t.setQtdQuestaoTurma(8);
	
	Curso c= new Curso();
	c.setNome("ADS");
	c.getTurmas().add(t);
	
	manager.persist(t);
	manager.persist(c);
	
	manager.getTransaction().commit();
	manager.close();
	factory.close();
	
}
}
