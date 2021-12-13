public abstract class Vegetaux{
    private String nom;
    private double poidsg;
    private double prixkg;
    private String etat;
    public static int nbVegetaux;

    public Vegetaux(String nom,double poids,double prixPoids,String etat){
        this.nom=nom;
        this.poidsg=poids;
        this.prixkg=prixPoids;
        this.etat="graine";
        nbVegetaux++;
    }
    

	public void Pousser(){
        if(this.etat=="mûr") this.etat="Perime";
        if(this.etat=="preLeg") this.etat="mûr";
        if(this.etat=="graine") this.etat="preLeg";
        
    }
    public String toString(){
        return nom+" : "  + poidsg + " g, " + prixkg + "€ : " + etat;
    }

    public abstract void pousse(Vegetaux v, Serre s);
    // Accesseurs 
    
    public String getNom(){
        return nom;
    }
    public String getEtat(){
        return etat;
    }   
    public double getPrix(){
        return this.prixkg*this.getPoids();
    }
    public double getPoids(){
        return this.poidsg/1000;

    }

}
