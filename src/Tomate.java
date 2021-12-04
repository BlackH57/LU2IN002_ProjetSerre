public class Tomate extends Fruit {
    private final static double poidsg = (int)(Math.random()*10)+150;
    private final static double prixkg = 2 ;
    private static int cpt=1;
    
    public Tomate(){
        super("Tomate"+" n°"+cpt,poidsg,prixkg,"graine");
        System.out.println("un plant de tomate est planté");
        cpt++;
    }
    public double getPrix(){
        return Tomate.prixkg*Tomate.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    
    
}
