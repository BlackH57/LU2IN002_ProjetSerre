public class Serre{
	public final int taille;
	private Vegetaux[][] plantation;
	private static int nbVegetaux = 0;
	
	private String saison;
	private static int nbTours;
	
	static int singleton = 0;

	// Constructeur
	public Serre(int taille, String saison) {
		this.saison = saison;
		this.taille = taille;
		
		plantation = new Vegetaux[taille][taille];
		
		for(int i = 0; i<taille; i++) {
			for(int j = 0; j<taille;j++) {
				plantation[i][j] = null;
			}
		}
	}
	
	public Serre(String saison) {
		this(3, saison);
	}

	public Serre(int taille) {
		this(taille, "Printemps");
	}

	public Serre(){
		this(3, "Printemps");
	}
	
	public static Serre creationSerre(int taille, String saison){
		if(singleton == 0){
			singleton ++;
			return new Serre(taille, saison);
		}

		return null;
	}

	public static Serre creationSerre(int taille){
		if(singleton == 0){
			singleton ++;
			return new Serre(taille);
		}

		return null;
	}

	public static Serre creationSerre(String saison){
		if(singleton == 0){
			singleton ++;
			return new Serre();
		}

		return null;
	}

	public static Serre creationSerre(){
		if(singleton == 0){
			singleton ++;
			return new Serre();
		}

		return null;
	}

	
	// Methodes gestion de la serre
	public void planter(Vegetaux v) {
		///On vérifie qu'il n y a de la place sur la plantation
		if(nbVegetaux <= taille*taille) {
			
			///On parcourt le terrain et des qu'on trouve une place libre on plante
			for(int i = 0; i<taille;i++) {
				for(int j = 0; j<taille;j++) {
					if(plantation[i][j] == null) {
						plantation[i][j] = v;
						nbVegetaux++;
						return;
					}
				}
			}			
		}
		else System.out.println("Il n'y a plus de place sur la plantation");
	}
	
	public void recolter(Object vegetaux, Stockage stock)  throws VegetauxException{
		///On pourra mettre un catch ici
		if(!(vegetaux instanceof Vegetaux)) {
			throw new VegetauxException("L'objet mis en paramètre n'est pas un végétal");			
		}
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				if((plantation[i][j] != null) && (plantation[i][j].getClass() == vegetaux.getClass())) {
					if(plantation[i][j].getEtat() == "mûr") {
						if(stock.stocker(plantation[i][j]));
							System.out.println(plantation[i][j].toString() + " a été récolté !" );
							plantation[i][j] = null;
							Serre.nbVegetaux--;
							Vegetaux.nbVegetaux--;
					}
					//else System.out.println("Pas encore mûr");
				}
			}
		}
	}
	
	public void recolter(Stockage stock){
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				if((plantation[i][j] != null) && (plantation[i][j].getEtat() == "mûr")) {
					if(stock.stocker(plantation[i][j])){
						System.out.println(plantation[i][j].toString() + " a été récolté ! \n" );
						plantation[i][j] = null;
						Serre.nbVegetaux--;
						Vegetaux.nbVegetaux--;

					}
				//else if(plantation[i][j] instanceof Vegetaux){System.out.println("Pas encore mur");}
				}
			}
		}
	}
	
	public void rafraichirSerre(Serre s){
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				if(plantation[i][j] != null){						
					if(plantation[i][j].getEtat()=="Perime"){
						plantation[i][j] = null;
						Serre.nbVegetaux--;
						Vegetaux.nbVegetaux--;
					}
					else {
						plantation[i][j].pousse(plantation[i][j], this);
					}
				}
			}
		}
    	}

	// Methodes gestion facteurs exterieurs
	public void setNextSaison(){
		if(saison == "Printemps"){ saison = "Ete"; return;}
		if(saison == "Ete") {saison = "Automne"; return;}
		if(saison == "Automne") {saison = "Hiver"; return;}
		if(saison == "Hiver") {saison = "Printemps"; return;}
	}

	public void updateSaison(){
		if(nbTours%3 == 0){
			setNextSaison();
			System.out.println("\nOn passe en " + this.getSaison() + "\n");
		}
	}

	public void nextTour(){
		nbTours++;
		updateSaison();
		rafraichirSerre(this);
		
	}


	// Methodes générique
    public String toString(){
        String res="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+\n";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v == null) res+= "    ";
                else res+= " "+plantation[i][j].getNom().charAt(0)+plantation[i][j].getEtat().charAt(0) + " ";
            }
            res+="|\n";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+\n";
        return res;
    }

	public String getSaison(){
		return this.saison;
	}

	public String toStringHTML(){
        String res="<html>+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+<br>";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v == null) res+= "....";
                else res+= "."+plantation[i][j].getNom().charAt(0)+plantation[i][j].getEtat().charAt(0) + ".";
            }
            res+="|<br>";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+<br>";
        return res;
    }

	public int getNbVegetaux(){
		return nbVegetaux;
	}
}
