package models;

import models.Questao;


public class QuestaoGerada implements Comparable<QuestaoGerada> {

	public Integer ordem; 
	public Questao questao;
	
	public QuestaoGerada(Questao questao) {
		this.questao = questao;
		this.ordem = 0;
	}
	
	@Override
	public int compareTo(QuestaoGerada questao) {
		return this.ordem.compareTo(questao.ordem);
	}
	
	@Override
	public String toString() {
		return ordem + ": " + questao.getEnunciado()+ " " +questao.getAuxiliar() ;
	}
	
}