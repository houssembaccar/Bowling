package com.bowling.model;

import java.util.ArrayList;
import java.util.Scanner;

import com.bowling.vue.Vue;

public class Partie {
	
	private int nbJoueurs;
	private ArrayList <Joueur> joueurs= new ArrayList<Joueur>() ;

	public Partie(int nbJoueurs){		
		this.nbJoueurs=nbJoueurs;
	}
	
	public void ajouterJoueur(Joueur joueur){
				joueurs.add(joueur);		
	}
	
	public boolean nomJoueurExist(String nouveauNom, ArrayList<Joueur> joueurs){
		if (joueurs.size() == 0)
			return false;
		String nomCourant="";
		Boolean isEqual = false;
		int i = 0;
		do{
			nomCourant=joueurs.get(i).getName();
			if (nomCourant.equals(nouveauNom))
					isEqual=true;
			i++;
		}while(i < joueurs.size());
		return isEqual;
	}
	
	public void organiserJeux(){
		
		int quilleTombees=0;
		ArrayList<Tour> historique = null;
		Tour tourCourant;
		Vue vue = new Vue();
		for (int numeroTour=0;numeroTour<10;numeroTour++){
			for(Joueur joueur : joueurs){
				System.out.println(" C'est le tour "+ (numeroTour+1) +" de " + joueur.getName());
				historique = joueur.getHistorique();
				tourCourant = new Tour();
				historique.add(tourCourant);
				historique.get(numeroTour).setNumeroTour(numeroTour+1);
				System.out.println("lancée numéro 1");
				quilleTombees = vue.saisirNbQuillesATomber(historique.get(numeroTour));
				joueur.gestionLancer(historique.get(numeroTour), quilleTombees);
				if (!historique.get(numeroTour).getTypeLance().equals(TypeLance.STRIKE)){
					System.out.println("lancée numéro 2");
					quilleTombees = vue.saisirNbQuillesATomber(historique.get(numeroTour));
					joueur.gestionLancer(historique.get(numeroTour), quilleTombees);
					
				}
				joueur.calculScore(tourCourant, historique);
			}
		}
		//Gérer le cas d'un strike au dernier tour 
		for (Joueur joueur : joueurs){
			historique = joueur.getHistorique();
			if (joueur.getHistorique().get(9).getTypeLance().equals(TypeLance.STRIKE)){
				System.out.println(" C'est le tour supplémentaire de " + joueur.getName()+" Vous avez 2 lancées supplémentaires ");
				tourCourant = new Tour();
				historique.add(tourCourant);
				historique.get(10).setNumeroTour(11);
				System.out.println("lancée numéro 1");
				quilleTombees = vue.saisirNbQuillesATomber(historique.get(10));
				joueur.gestionLancer(historique.get(10), quilleTombees);
				if (!historique.get(10).getTypeLance().equals(TypeLance.STRIKE)){
					System.out.println("lancée numéro 2");
					quilleTombees = vue.saisirNbQuillesATomber(historique.get(10));
					joueur.gestionLancer(historique.get(10), quilleTombees);				
				}
				joueur.gererScoreDernierStrike(historique);
				System.out.println(historique);
			}
			if (joueur.getHistorique().get(9).getTypeLance().equals(TypeLance.SPARE)){
				System.out.println(" C'est le tour supplémentaire de " + joueur.getName()+" Vous avez 1 lancées supplémentaire ");
				tourCourant = new Tour();
				historique.add(tourCourant);
				historique.get(10).setNumeroTour(11);
				System.out.println("lancée numéro 1");
				quilleTombees = vue.saisirNbQuillesATomber(historique.get(10));
				joueur.gestionLancer(historique.get(10), quilleTombees);
				joueur.gererScoreDernierSpare(historique);
				System.out.println(historique);
			}
			
		}
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
	@Override
	public String toString() {
		return "Partie [nbJoueurs=" + nbJoueurs + ", joueurs=" + joueurs + "]";
	}
		

}
