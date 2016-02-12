package com.bowling.vue;

import java.util.ArrayList;
import java.util.Scanner;

import com.bowling.model.Joueur;
import com.bowling.model.Partie;
import com.bowling.model.Tour;

public class Vue {
	
	public void main(String args[]){
		
	}
	
	public int saisirNbJoueur(){
		
		Scanner sc = new Scanner (System.in);
		int nbJoueur;
		do{
			System.out.println("Saisir le nombre de joueur (entre 2 et 3):");
			nbJoueur = sc.nextInt();
		}while (nbJoueur<= 1 || nbJoueur >=4);
		return nbJoueur;
	}
	
	public int saisirNbQuillesATomber(Tour tour){
		
		Scanner sc = new Scanner (System.in);
		int nbQuilleATomber;
		do{
			System.out.println("saisir le nombre de quille à tomber (entre 0 et "+tour.getQuilleRestantes()+" ) :");
			nbQuilleATomber = sc.nextInt();
		}while(nbQuilleATomber > tour.getQuilleRestantes() || nbQuilleATomber < 0);
		return nbQuilleATomber;
	}
	public String saisirNomJoueur(ArrayList<Joueur> joueurs,Partie p){
		Scanner sc = new Scanner(System.in);
		String nomJoueur="";
		do{
			System.out.println("saisir un nouveau nom de joueur qui n'existe pas encore:");
			nomJoueur = sc.next();
		}while ( p.nomJoueurExist(nomJoueur,joueurs));
		return nomJoueur;
	}

}
