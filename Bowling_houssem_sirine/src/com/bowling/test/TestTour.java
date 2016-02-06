package com.bowling.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bowling.model.Tour;

public class TestTour {
	
	@Test
	public void testTour(){
		
		Tour tour = new Tour();
		assertEquals(tour.getNumeroTour(),0);
		assertEquals(tour.getPoint(),0);
		assertEquals(tour.getQuilleTombee1(),0);
		assertEquals(tour.getQuilleTombee2(),0);
		assertEquals(tour.getQuilleRestantes(),10);
		assertEquals(tour.getNbLanceEffectue(),0);
		
	}

}
