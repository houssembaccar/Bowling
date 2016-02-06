package com.bowling.model;

import java.util.Scanner;

public class Joueur {
	private String name;
	private  Tour historique [];
	
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
			 if (quilleTombees+tour.getQuilleTombee1() == 10){
				 tour.setTypeLance(TypeLance.SPARE);
			 }
			 tour.setQuilleRestantes(quilleRestantes-quilleTombees);
			 tour.setNbLanceEffectue(2);
		}
	
		
				
	}
	
	public Tour[] getHistorique() {
		return historique;
	}

	public void setHistorique(Tour[] historique) {
		this.historique = historique;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
