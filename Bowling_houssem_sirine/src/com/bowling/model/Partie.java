package com.bowling.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {
	
	private int nbJoueurs;
	private ArrayList <Joueur> joueurs= new ArrayList<Joueur>() ;


	public Partie(int nbJoueurs){
		
		this.nbJoueurs=nbJoueurs;
	}
	
	public void ajouterJoueur(Joueur joueur){
				joueurs.add(joueur);
		
	}
	
	
	public int getNbJoueurs() {
		return nbJoueurs;
	}
	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
		
	

	

}
