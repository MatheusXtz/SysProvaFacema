package controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import models.Questao;
import models.QuestaoGerada;

public class Aleatorio {
	
	public static void main(String[] args) {
		Questao q= new Questao();
		Questao q1= new Questao();
		Questao q2= new Questao();
		Questao q3= new Questao();
		q.setEnunciado("Primeira");
		q1.setEnunciado("Segunda");
		q2.setEnunciado("Terceira");
		q3.setEnunciado("Quarta");
		List<Questao> questoes = new LinkedList<Questao>();
		questoes.add(q);
		questoes.add(q1);
		questoes.add(q2);
		questoes.add(q3);
		
		
		System.out.println(questoes);
		System.out.println(embaralharQuestoes(questoes));
	}

	public static Collection<QuestaoGerada> embaralharQuestoes(List<Questao> questoes) {
		Random r = new Random();
		for (Questao q : questoes) {
			q.setAuxiliar(r.nextInt()); 
		}
		
		Comparator<Questao> comp = new Comparator<Questao>() {
			@Override
			public int compare(Questao q1, Questao q2) {
				return q1.getAuxiliar().compareTo(q2.getAuxiliar());
			}
		};
		
		Collections.sort(questoes, comp);
		
		Collection<QuestaoGerada> questoesGeradas = new LinkedList<QuestaoGerada>();
		int i = 1;
		for (Questao q : questoes) {
			QuestaoGerada qg = new QuestaoGerada(q);
			qg.ordem = i++;
			questoesGeradas.add(qg);
		}
		
		return questoesGeradas;
	}
}
