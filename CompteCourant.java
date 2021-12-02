package packBanque;

import java.util.Scanner;

public class CompteCourant extends CompteBancaire{
	
	private double decouvert;

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public CompteCourant() {
		super();
		this.decouvert = 0;
	}
	
	public CompteCourant(double solde, double decouvert) {
		super(solde);
		this.decouvert = decouvert;
	}
	
	@Override
	public void saisir() {
		super.saisir();
		Scanner sc = new Scanner(System.in);
		double d;
		do {
			System.out.println("Saisir le decouvert");
			d = sc.nextDouble();
		}while(d<0);
		this.decouvert = d;
		
	}
	
	@Override
	public void crediter(double montant) {
		super.crediter(montant-1.5);
		// ou bien this.solde +=(montant-1.5);
	}
	
	@Override
	public boolean debiter(double montant) {
		if(montant>this.solde+this.decouvert) {
			return false;
		}
		else
		{
			this.solde-= (montant+1.5);
			this.ListMvt.add("Retrait de"+ montant);
			return true;
		}
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n le decouvert" + this.decouvert;
	}

}