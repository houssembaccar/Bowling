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
	@Test
	public void testNomJoueurExist(){
		Partie p = new Partie(2);
		assertFalse(p.nomJoueurExist("toto",p.getJoueurs()));
		Joueur joueur= new Joueur("toto");	
		System.out.println(joueur.toString());
		p.ajouterJoueur(joueur);
		System.out.println(p.getJoueurs().toString());
		assertTrue(p.nomJoueurExist("toto",p.getJoueurs()));
		assertFalse(p.nomJoueurExist("toto2",p.getJoueurs()));
	}
	@Test
	public void testGestionJeux(){
		
		Partie partie = new Partie (2);		
		Joueur joueur= new Joueur("Houssam");
		partie.ajouterJoueur(joueur);
		Joueur joueur2= new Joueur("sirine");
		partie.ajouterJoueur(joueur2);
		partie.organiserJeux();
	}

}
