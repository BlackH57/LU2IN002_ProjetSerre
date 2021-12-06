public class Asperge extends Legume {
    private final static double poidsg = (int)(Math.random()*11)+150;
    private final static double prixkg = 0.90 ;
    private static int cpt=1;
    
    public Asperge(){
        super("Asperge"+" n°"+cpt,poidsg,prixkg,"graine");
        cpt++;
    }
    public double getPrix(){
        return Asperge.prixkg*Asperge.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }
    
}
