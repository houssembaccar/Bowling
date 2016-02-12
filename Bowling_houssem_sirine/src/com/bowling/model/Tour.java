package com.bowling.model;

public class Tour {
	
	private int numeroTour;
	private TypeLance typeLance;
	private int quilleTombee1;
	private int quilleTombee2;
	private int point;
	private int quilleRestantes;
	private int nbLanceEffectue;
	

	public Tour(){
		this.typeLance=TypeLance.TROU;
		this.quilleTombee1=0;
		this.quilleTombee2=0;
		this.point=0;
		this.quilleRestantes=10;
		this.nbLanceEffectue=0;
		this.numeroTour=0;
	}

	
	public int getNumeroTour() {
		return numeroTour;
	}

	public void setNumeroTour(int numeroTour) {
		this.numeroTour = numeroTour;
	}
	public TypeLance getTypeLance() {
		return typeLance;
	}

	public void setTypeLance(TypeLance typeLance) {
		this.typeLance = typeLance;
	}

	public int getQuilleTombee1() {
		return quilleTombee1;
	}

	public void setQuilleTombee1(int quilleTombee1) {
		this.quilleTombee1 = quilleTombee1;
	}

	public int getQuilleTombee2() {
		return quilleTombee2;
	}

	public void setQuilleTombee2(int quilleTombee2) {
		this.quilleTombee2 = quilleTombee2;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public int getQuilleRestantes() {
		return quilleRestantes;
	}

	public void setQuilleRestantes(int quilleRestantes) {
		this.quilleRestantes = quilleRestantes;
	}

	public int getNbLanceEffectue() {
		return nbLanceEffectue;
	}

	public void setNbLanceEffectue(int lanceEffectue) {
		this.nbLanceEffectue = lanceEffectue;
	}

	@Override
	public String toString() {
		return "Tour [typeLance=" + typeLance + ", quilleTombee1="
				+ quilleTombee1 + ", quilleTombee2=" + quilleTombee2
				+ ", point=" + point + ", quilleRestantes=" + quilleRestantes
				+ ", nbLanceEffectue=" + nbLanceEffectue + ", numeroTour="
				+ numeroTour + "]";
	}
	

}
