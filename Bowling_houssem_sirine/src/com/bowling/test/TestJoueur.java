package com.bowling.test;

import org.junit.*;

import com.bowling.model.Joueur;


public class TestJoueur {
	
	@Test
	public void testCreateJoueur(){
		Joueur joueur = new Joueur("houssem");
		Assert.assertEquals(joueur.getName(), "houssem");
	}

}
