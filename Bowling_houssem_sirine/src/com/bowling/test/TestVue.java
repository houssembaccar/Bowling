package com.bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.model.Joueur;
import com.bowling.model.Partie;
import com.bowling.vue.Vue;

public class TestVue {
	
	@Test
	public void testSaisirNbJoueur(){
		
		Vue vue = new Vue();
		int nbJoueur = vue.saisirNbJoueur();
		assertTrue((nbJoueur > 1) && (nbJoueur <4) );
	}
	@Test
	public void testSaisirNomJoueur(){
		Vue vue = new Vue();
		Partie p = new Partie(2);
		p.ajouterJoueur(new Joueur("toto"));
		System.out.println("toto est déja un joueur, saisir un autre nom pour que le test passe");
		String nomJoueur = vue.saisirNomJoueur(p.getJoueurs(), p);
		assertFalse(p.nomJoueurExist(nomJoueur, p.getJoueurs()));
	}

}
