package com.bowling.test;

import static org.junit.Assert.*;

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
		assertEquals(TypeLance.TROU,tour.getTypeLance());
		assertEquals(5,tour.getQuilleTombee1());
		assertEquals(5,tour.getQuilleRestantes());
		assertEquals(1,tour.getNbLanceEffectue());
		assertEquals(10,tour.getQuilleTombee1()+tour.getQuilleTombee2()+tour.getQuilleRestantes());
		
		joueur.gestionLancer(tour2,5);
		assertEquals(TypeLance.SPARE,tour.getTypeLance());
		assertEquals(5,tour.getQuilleTombee2());
		assertEquals(0,tour.getQuilleRestantes());
		assertEquals(2,tour.getNbLanceEffectue());
		assertEquals(10,tour.getQuilleTombee1()+tour.getQuilleTombee2()+tour.getQuilleRestantes());
		
		
		Tour tour3 = new Tour();
		joueur.gestionLancer(tour3,3);
		assertEquals(TypeLance.TROU,tour.getTypeLance());
		assertEquals(3,tour.getQuilleTombee1());
		assertEquals(7,tour.getQuilleRestantes());
		assertEquals(1,tour.getNbLanceEffectue());
		assertEquals(10,tour.getQuilleTombee1()+tour.getQuilleTombee2()+tour.getQuilleRestantes());
		
		joueur.gestionLancer(tour3,3);
		
		assertEquals(TypeLance.TROU,tour.getTypeLance());
		assertEquals(3,tour.getQuilleTombee1());
		assertEquals(7,tour.getQuilleRestantes());
		assertEquals(1,tour.getNbLanceEffectue());
		assertEquals(10,tour.getQuilleTombee1()+tour.getQuilleTombee2()+tour.getQuilleRestantes());

	}

}
