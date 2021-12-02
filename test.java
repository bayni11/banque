package packBanque;

public class test {

	public static void main(String[] args) {
		banque B = new banque();
		Client CL1 = new Client();
		CL1.setNomClient(null);
		CL1.afficheClient();
		
		CompteEpargne E = new CompteEpargne();
		E.saisir();
		CL1.ajouterCompte(E);
		B.ajouterClient(CL1);
		CL1.afficheClients();
		

	}

}
