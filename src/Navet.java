public class Navet extends Legume{
    private final static double poidsg=(int)(Math.random()*11)+300;
    private final static double prixkg = 1.38 ;
    private static int cpt=1;
    
    public Navet(){
        super("Navet"+" n°"+cpt,poidsg,prixkg,"graine");
        cpt++;
    }
    public double getPrix(){
        return Navet.prixkg*Navet.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    
}
