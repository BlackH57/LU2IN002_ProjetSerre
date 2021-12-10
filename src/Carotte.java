public class Carotte extends Legume {
    private final static double poidsg = (int)(Math.random()*11)+100;;
    private final static double prixkg = 0.65 ;
    private static int cpt=1;

    public Carotte(){
        super("Carotte"+" n°"+cpt,poidsg,prixkg,"graine");
        cpt++;
    }
    
}
    

