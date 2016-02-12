package com.bowling.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import com.bowling.model.Joueur;
import com.bowling.model.Tour;
import com.bowling.model.TypeLance;


public class TestJoueur {
	
	@Test
	public void testCreateJoueur(){
		Joueur joueur = new Joueur("houssem");
		Assert.assertEquals(joueur.getName(), "houssem");
	}
	@Test
	public void testGestionLance(){
		Joueur joueur = new Joueur("toto");
		Tour tour = new Tour();
		joueur.gestionLancer(tour, 10);
		System.out.println(tour.toString());
		assertEquals(TypeLance.STRIKE,tour.getTypeLance());
		assertEquals(10,tour.getQuilleTombee1());
		assertEquals(0,tour.getQuilleRestantes());
		assertEquals(1,tour.getNbLanceEffectue());
		assertEquals(10,tour.getQuilleTombee1()+tour.getQuilleTombee2()+tour.getQuilleRestantes());
		
		
		Tour tour2 = new Tour();
		joueur.gestionLancer(tour2,5);
		assertEquals(TypeLance.TROU,tour2.getTypeLance());
		assertEquals(5,tour2.getQuilleTombee1());
		assertEquals(5,tour2.getQuilleRestantes());
		assertEquals(1,tour2.getNbLanceEffectue());
		assertEquals(10,tour2.getQuilleTombee1()+tour2.getQuilleTombee2()+tour2.getQuilleRestantes());
		
		joueur.gestionLancer(tour2,5);
		assertEquals(TypeLance.SPARE,tour2.getTypeLance());
		assertEquals(5,tour2.getQuilleTombee2());
		assertEquals(0,tour2.getQuilleRestantes());
		assertEquals(2,tour2.getNbLanceEffectue());
		assertEquals(10,tour2.getQuilleTombee1()+tour2.getQuilleTombee2()+tour2.getQuilleRestantes());
		
		
		Tour tour3 = new Tour();
		joueur.gestionLancer(tour3,3);
		
		assertEquals(TypeLance.TROU,tour3.getTypeLance());
		assertEquals(3,tour3.getQuilleTombee1());
		assertEquals(7,tour3.getQuilleRestantes());
		assertEquals(1,tour3.getNbLanceEffectue());
		assertEquals(10,tour3.getQuilleTombee1()+tour3.getQuilleTombee2()+tour3.getQuilleRestantes());
		
		joueur.gestionLancer(tour3,3);
		
		assertEquals(TypeLance.TROU,tour3.getTypeLance());
		assertEquals(3,tour3.getQuilleTombee2());
		assertEquals(4,tour3.getQuilleRestantes());
		assertEquals(2,tour3.getNbLanceEffectue());
		assertEquals(10,tour3.getQuilleTombee1()+tour3.getQuilleTombee2()+tour3.getQuilleRestantes());
	}
	
	@Test
	public void testCalculScore()
	{
		Joueur joueur = new Joueur("toto");
		Tour tour1 = new Tour();
		Tour tour2 = new Tour();
		Tour tour3 = new Tour();
		Tour tour4 = new Tour();
		
		tour1.setNbLanceEffectue(2);
		tour1.setNumeroTour(1);
		tour1.setPoint(20);
		tour1.setQuilleRestantes(0);
		tour1.setQuilleTombee1(5);
		tour1.setQuilleTombee2(5);
		tour1.setTypeLance(TypeLance.SPARE);
		
		joueur.getHistorique().add(tour1);
		
		tour2.setNbLanceEffectue(1);
		tour2.setNumeroTour(2);
		tour2.setPoint(20);
		tour2.setQuilleRestantes(0);
		tour2.setQuilleTombee1(10);
		tour2.setQuilleTombee2(0);
		tour2.setTypeLance(TypeLance.STRIKE);
		
		joueur.getHistorique().add(tour2);
		
		tour3.setNbLanceEffectue(1);
		tour3.setNumeroTour(3);
		tour3.setPoint(10);
		tour3.setQuilleRestantes(0);
		tour3.setQuilleTombee1(10);
		tour3.setQuilleTombee2(0);
		tour3.setTypeLance(TypeLance.STRIKE);
		
		joueur.getHistorique().add(tour3);
		
		tour4.setNbLanceEffectue(10);
		tour4.setNumeroTour(4);
		tour4.setPoint(0);
		tour4.setQuilleRestantes(0);
		tour4.setQuilleTombee1(10);
		tour4.setQuilleTombee2(0);
		tour4.setTypeLance(TypeLance.STRIKE);
		
		joueur.getHistorique().add(tour4);
		
		joueur.calculScore(tour4, joueur.getHistorique());
		
		ArrayList <Tour> historique = joueur.getHistorique();
		assertEquals(historique.get(0).getPoint() , 20);
		assertEquals(historique.get(1).getPoint() , 30);
		assertEquals(historique.get(2).getPoint() , 20);
		assertEquals(historique.get(3).getPoint() , 10);
	}

}
