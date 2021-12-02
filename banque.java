package packBanque;

import java.util.ArrayList;

public class banque {
	private String nomBanque;
	private ArrayList<Client> ListeClient = new ArrayList<Client>();
	
	public String getNomBanque() {
		return nomBanque;
	}
	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	public ArrayList<Client> getListeClient() {
		return ListeClient;
	}
	public void setListeClient(ArrayList<Client> listeClient) {
		ListeClient = listeClient;
	}
	
	public banque() {}
	
	public banque(String nomBanque) {
		this.nomBanque = nomBanque;
	}
	
	public boolean ajouterClient(Client Cl)  {
		int i = this.ListeClient.indexOf(Cl);
		if ( i==-1) {
			this.ListeClient.add(Cl);
			return true;
		}
		else 
			return false;
	}
	
	public int rechercherPositionClient(String nom) {
		int i =-1;
		for (Client x:ListeClient) {
			if(x.getNomClient().equals(nom)) {
				i = this.ListeClient.indexOf(x);
				break;
			}
		}
		return i;
	}
	
	public boolean supprimerClient(Client Cl) {
		return this.ListeClient.remove(Cl);
	}
	
	public boolean supprimerClient2(String nom) {
		int i = this.rechercherPositionClient(nom);
		if(i==-1) {
			return false ;
		}
		else {
			this.ListeClient.remove(i);
			return true ;
		}
	
	}
	
	
	

}
