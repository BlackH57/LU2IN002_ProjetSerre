public abstract class Legume extends Vegetaux{
    
    public Legume(String nom,double poids,double prixPoids,String etat){
        super(nom,poids,prixPoids,etat);
    }
    
    public abstract void pousse(Vegetaux v, Serre s);
}
