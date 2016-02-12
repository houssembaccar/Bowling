package com.bowling.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Joueur {
	private String name;
	private  ArrayList <Tour> historique = new ArrayList<Tour>();
	
	public Joueur(String name){
		this.name=name;
	}

	public int InitNbTargets()
	{
		int NbTargets=10;
		return NbTargets;
	}

	public void gestionLancer(Tour tour,int quilleTombees){
		
		int lanceEffectue = tour.getNbLanceEffectue();
		int quilleRestantes=tour.getQuilleRestantes();
		// Si c'est la première lancée du tour 
		if (lanceEffectue == 0){
			tour.setQuilleTombee1(quilleTombees);
			// si le joueur a réaliser un strike 
			if (quilleTombees==10){
				tour.setTypeLance(TypeLance.STRIKE);
			}
			tour.setQuilleRestantes(quilleRestantes-quilleTombees);
			tour.setNbLanceEffectue(1);
		}else if (lanceEffectue == 1){// si c'est le deuxième lancé
			 tour.setQuilleTombee2(quilleTombees);
			 // si c'est un spare
			 if (quilleTombees+tour.getQuilleTombee1() == 10){
				 tour.setTypeLance(TypeLance.SPARE);
			 }
			 tour.setQuilleRestantes(quilleRestantes-quilleTombees);
			 tour.setNbLanceEffectue(2);
		}		
				
	}
	
	public void calculScore(Tour tour, ArrayList <Tour> historqiue){
		
		tour.setPoint(tour.getQuilleTombee1() + tour.getQuilleTombee2());
		// si le lancé précédent est un SPARE
		if (tour.getNumeroTour() > 1 && historique.get(tour.getNumeroTour()-2).getTypeLance().equals(TypeLance.SPARE)){
			historique.get(tour.getNumeroTour()-2).setPoint(10+tour.getQuilleTombee1());
		}// si le lancé précédent est un strike
 		if (tour.getNumeroTour() >1 && historique.get(tour.getNumeroTour()-2).getTypeLance().equals(TypeLance.STRIKE )){
			int numeroTourCourant=tour.getNumeroTour()-2;
			int pointCourant=0;
			while (numeroTourCourant >= 0 && historique.get(numeroTourCourant).getTypeLance().equals(TypeLance.STRIKE)){
				
				pointCourant = historique.get(numeroTourCourant+1).getPoint();
				historique.get(numeroTourCourant).setPoint(pointCourant + 10);
				numeroTourCourant--;
			}
		}
 		System.out.println(historique);
	}
	
	public void gererScoreDernierStrike(ArrayList <Tour> historique){
		Tour tourSup= historique.get(10);
		Tour dernierTour = historique.get(9);
		dernierTour.setPoint(dernierTour.getPoint() + tourSup.getQuilleTombee1()+tourSup.getQuilleTombee2());
		System.out.println(historique);
	}
	public void gererScoreDernierSpare(ArrayList <Tour> historique){
		Tour tourSup= historique.get(10);
		Tour dernierTour = historique.get(9);
		dernierTour.setPoint(dernierTour.getPoint() + tourSup.getQuilleTombee1());
		System.out.println(historique);
	}

	
	
	public ArrayList<Tour> getHistorique() {
		return historique;
	}

	public void setHistorique(ArrayList<Tour> historique) {
		this.historique = historique;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Joueur [name=" + name + ", historique=" + historique + "]";
	}

}
