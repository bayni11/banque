package packBanque;
import java.util.Scanner;


public class Client {
	private String nomClient;
	private String prenomClient;
	private String sexe;
	CompteBancaire [] TabCompte = new CompteBancaire[2] ;
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public CompteBancaire[] getTabCompte() {
		return TabCompte;
	}
	public void setTabCompte(CompteBancaire[] tabCompte) {
		TabCompte = tabCompte;
	}
	
	public Client () {}
	
	public Client(String nomClient, String prenomClient, String sexe, CompteBancaire[] TabCompte) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient ;
		this.sexe = sexe;
		this.TabCompte = TabCompte;
		
	}
	
	public void SaisirClient() {
	Scanner sc=new Scanner(System.in);
	String ch;
	System.out.println("Saisie des informations d'un client");
	do
	{
	System.out.println("Saisir le nom du client");
	this.nomClient = sc.nextLine();
	} while(nomClient.length()>30);
	do
	{
	System.out.println("Saisir le prenom du client");
	this.prenomClient = sc.nextLine();
	} while(prenomClient.length()>30);
	do
	{
	System.out.println("Saisir le sexe du client: Mr/Mme");
	ch= sc.nextLine();
	} while((ch.compareTo("Mr")!=0) &&
	(ch.compareTo("Mme")!=0));
	this.sexe=ch;

	int x ;
	do {
		System.out.println("inserer 1 :  pour compte courant et 2: pour compte epargne");
		x = sc.nextInt();
	}while(x!=1 && x!=2);
	if (x==1) {
		CompteCourant C= new CompteCourant();
		C.saisir();
		TabCompte [0] = C;
	}
	else {
		CompteEpargne E= new CompteEpargne();
		E.saisir();
		TabCompte [0] = E;
		
	}
	}
	
	public boolean RechercherCompte(CompteBancaire C) {
		boolean trouve = false;
		for (int i=0;i<this.TabCompte.length;i++) {
			
			if (TabCompte[i]!=null && this.TabCompte[i].getNumCompte()==C.getNumCompte()) {
				trouve = true ;
				break ;	
			}
		}
	return trouve;
	}
	 
	public boolean RechercherCompte2(long num) {
		boolean trouve = false;
		for (int i=0;i<this.TabCompte.length;i++) {
			
			if (TabCompte[i]!=null && this.TabCompte[i].getNumCompte()==num) {
				trouve = true ;
				break ;	
			}
		}
	return trouve;
	}
	
	public boolean ajouterCompte(CompteBancaire C ) {
		boolean vide = false ;
		if (!RechercherCompte(C)) {
			for(int i=0;i<this.TabCompte.length;i++) {
				if(TabCompte[i]==null ) {
					TabCompte[i]=C;
					vide =true;
					break ;
				}
			}
			
		}
		return vide;
		
	}
	
	public boolean fermerCompte(CompteBancaire C) {
		boolean vide= false;
		if(this.RechercherCompte(C)) {
			for(int i=0;i<this.TabCompte.length;i++) {
				if(TabCompte[i]==null && this.TabCompte[i].getNumCompte()==C.getNumCompte() ) {
					TabCompte[i] = null;
					vide = true ;
					break;
				}

		}
			
	}
		return vide ;
		
		
}
	
	public double soldeTotal() {
		double s=0.0;
		for(CompteBancaire x:TabCompte) {
		if(x!=null) {
		s=s+x.getSolde();

		}
		}
		return s;
		}

		public void afficheClient() {
		String ch="";
		for(CompteBancaire x:TabCompte) {
		if(x!=null) {
		ch=ch.toString();
		}
		}
		System.out.println("Nom:"+this.nomClient+"\n Prenom:"+this.prenomClient+"\n Sexe:"+this.sexe +"\n Comptes:"+ch+"\n solde total="+this.soldeTotal());
		}
}