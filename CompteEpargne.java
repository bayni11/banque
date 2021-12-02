package packBanque;

public class CompteEpargne extends CompteBancaire {
	
	private final double tauxInteret;

	public double getTauxInteret() {
		return tauxInteret;
	}
	
	public CompteEpargne() {
		super();
		this.tauxInteret = 1.0;
	}
	
	public CompteEpargne(double solde) {
		super(solde);
		this.tauxInteret = 1.0;
	}
	
	@Override
	public boolean debiter(double montant) {
		if(montant>this.solde) {
			return false;
		}
		else
		{
			this.solde-=montant;
			this.ListMvt.add("Retrait de"+ montant);
			return true;
		}
	}
	
	public void verserInteret() {
		this.solde+=(this.solde*this.tauxInteret/100);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + "\n le taux d'interet" + this.tauxInteret;
	}
	


}
