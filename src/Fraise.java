public class Fraise extends Fruit{
    private final static double poidsg = (int)(Math.random()*2)+10;
    private final static double prixkg = 7 ;
    private static int cpt=1;
    
    public Fraise(){
        super("Fraise"+" n°"+cpt,poidsg,prixkg,"graine");
        System.out.println("un fraisier est planté");
        cpt++;
    }
    public double getPrix(){
        return Fraise.prixkg*Fraise.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    
}
