package com.bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.model.Joueur;
import com.bowling.model.Partie;

public class TestPartie {
	
	@Test
	public void testPartie(){
		
		Partie partie= new Partie(3);		
		assertEquals(partie.getNbJoueurs(),3);
	}
	
	@Test
	public void testAjouterJoueur(){
		Partie partie= new Partie(3);
		
		Joueur joueur= new Joueur("Houssam");
		partie.ajouterJoueur(joueur);
		Joueur joueur2= new Joueur("sirine");
		partie.ajouterJoueur(joueur2);
		
		int nbJoueurs=partie.getJoueurs().size();
		Joueur joueurPremier = partie.getJoueurs().get(0);
		Joueur joueurDernier = partie.getJoueurs().get(nbJoueurs-1);
		assertEquals(nbJoueurs,2);
		assertEquals(joueurDernier.getName(),"sirine");
		assertEquals(joueurPremier.getName(),"Houssam");
		
	}
	
	@Test
	public void testLancer(){
		Joueur joueur = new Joueur("houssem");
		
		
	}

}
