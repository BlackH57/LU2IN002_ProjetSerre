public class Serre{
	public final int taille;
	private Vegetaux[][] plantation;
	
	///private static int nbVegetaux = 0; je l'ai mis dans la classe Vegetaux
	
	public Serre(int taille) {
		this.taille = taille;
		
		plantation = new Vegetaux[taille][taille];
		
		for(int i = 0; i<taille; i++) {
			for(int j = 0; j<taille;j++) {
				plantation[i][j] = null;
			}
		}
	}
	
	public Serre() {
		this(3);
	}
	
	public void planter(Vegetaux v) {
		///On vérifie qu'il n y a de la place sur la plantation
		if(Vegetaux.nbVegetaux <= taille*taille) {
			
			///On parcourt le terrain et des qu'on trouve une place libre on plante
			for(int i = 0; i<taille;i++) {
				for(int j = 0; j<taille;j++) {
					if(plantation[i][j] == null) {
						plantation[i][j] = v;
						return;
					}
				}
			}			
		}
		else System.out.println("Il n'y a plus de place sur la plantation");
	}
	
	public void recolter(Object vegetaux, Stockage stock) {
		///On pourra mettre un catch ici
		if(!(vegetaux instanceof Vegetaux)) {
			System.out.println("Le premier argument n'est pas un vegetal.");
			return;
		}
		for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
           		if((plantation[i][j] != null) && (plantation[i][j].getClass() == vegetaux.getClass())) {
           			if(plantation[i][j].getEtat() == "mur") {
           				if(stock.stocker(plantation[i][j]));
           					plantation[i][j] = null;
           					Vegetaux.nbVegetaux--;
           			}
           			else System.out.println("Pas encore mur");
            	}
            }
		}
	}
	
	public void recolter(Stockage stock) {
		for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
            	if((plantation[i][j] != null) && (plantation[i][j].getEtat() == "mur")) {
            		if(stock.stocker(plantation[i][j]));
            			plantation[i][j] = null;
            			Vegetaux.nbVegetaux--;           	
            	}
            	else if(plantation[i][j] instanceof Vegetaux){System.out.println("Pas encore mur");}            	
            }
		}
	}
	
	public void rafraichirSerre(){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                if(plantation[i][j] != null){

                    if(plantation[i][j].getEtat()=="perime"){
                        plantation[i][j] = null;
                        Vegetaux.nbVegetaux--;
                    }
                    else {
                        plantation[i][j].Pousser();
                    }
                }
            }
        }
    }
	
    public String toString(){
        String res="+";
        for(int i=0;i<taille;i++){
            res+="---";
        }
        res+="+\n";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v == null) res+= " . ";
                else res+= " "+plantation[i][j].getNom().charAt(0)+" ";
            }
            res+="|\n";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="---";
        }
        res+="+\n";
        return res;
    }

}
