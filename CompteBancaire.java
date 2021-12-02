package packBanque;
import java.util.Scanner;
import java.util.ArrayList;

public abstract class CompteBancaire {
	
	protected long NumCompte;
	protected static int num;
	protected double solde;
	protected ArrayList<String> ListMvt = new ArrayList<String>();
	
	public long getNumCompte() {
		return NumCompte;
	}
	
	public static int getNum() {
		return num;
	}
	public static void setNum(int num) {
		CompteBancaire.num = num;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public ArrayList<String> getListMvt() {
		return ListMvt;
	}
	public void setListMvt(ArrayList<String> listMvt) {
		ListMvt = listMvt;
	}
	
	public CompteBancaire() {
		this.NumCompte = CompteBancaire.num;
		CompteBancaire.num = ++CompteBancaire.num;
		//this.ListMvt = new ArrayList<String>();
	}
	
	public CompteBancaire(double solde) {
		this.NumCompte = CompteBancaire.num;
		CompteBancaire.num = ++CompteBancaire.num;
		this.solde = solde;
		
		}
	
	public void saisir() {
		Scanner sc = new Scanner(System.in);
		double s;
		do {
			System.out.println("Saisir le solde");
			s = sc.nextDouble();
		}while(s<0);
		this.solde =s;
	}
	
	public void crediter(double montant) {
		this.solde += montant;
		this.ListMvt.add("Crédit"+ montant);
	}
	
	public abstract boolean debiter(double montant);
	
	
	public boolean virer(double montant, CompteBancaire C) {
		if(this.debiter(montant)) {
			C.crediter(montant);
			this.ListMvt.add("Virement de"+ montant);
			return true;
		}
		else
			return false;
	}
	
	
	@Override
	public String toString() {
		String ch= "";
		for(int i=0;i<this.ListMvt.size();i++) {
			ch = ch + "\n \t" + this.ListMvt.get(i);
		}
		
		return "NumCompte" +this.NumCompte + "Solde" + this.solde + "Liste Opérations"+ ch;
	}
	
	

}
