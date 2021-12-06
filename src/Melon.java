public class Melon extends Fruit {
    private final static double poidsg = (int)(Math.random()*10)+150;
    private final static double prixkg = 2 ;
    private static int cpt=1;
    
    public Melon(){
        super("Melon"+" n°"+cpt,poidsg,prixkg,"graine");
        System.out.println("un plant de melon est planté");
        cpt++;
    }
    public double getPrix(){
        return Melon.prixkg*Melon.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    
    
}
