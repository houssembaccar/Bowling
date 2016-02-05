package com.bowling.model;

import java.util.Scanner;

public class Joueur {
	private String name;
	
	public Joueur(String name){
		this.name=name;
	}

	public int InitNbTargets()
	{
		int NbTargets=10;
		return NbTargets;
	}
	
	
	
	public int lancer (int quilleRestant){
		
		Scanner sc = new Scanner(System.in);
		int quilleTombees=0;
		do{
			System.out.println("Faire une lancée");
			quilleTombees = sc.nextInt();
		}while (quilleTombees > quilleRestant);
		System.out.println("il vous reste "+(quilleRestant - quilleTombees)+" quilles");
		return quilleTombees;		
	}
	
	 
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
