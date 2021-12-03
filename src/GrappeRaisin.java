public class GrappeRaisin extends Fruit{
    private final static double poidsg = (int)(Math.random()*10)+120;
    private final static double prixkg = 5 ;
    private static int cpt=1;
    
    public GrappeRaisin(){
        super("GrappeRaisin"+" n°"+cpt,poidsg,prixkg);
        System.out.println("une vigne est plantée");
        cpt++;
    }
    public double getPrix(){
        return GrappeRaisin.prixkg*GrappeRaisin.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    
    
}
