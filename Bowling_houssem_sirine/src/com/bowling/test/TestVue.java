package com.bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.vue.Vue;

public class TestVue {
	
	@Test
	public void testSaisirNbJoueur(){
		
		Vue vue = new Vue();
		int nbJoueur = vue.saisirNbJoueur();
		assertTrue((nbJoueur > 1) && (nbJoueur <4) );
	}

}
