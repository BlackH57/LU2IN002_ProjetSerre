public class GrappeRaisin extends Fruit implements Automne{
    private final static double poidsg = (int)(Math.random()*10)+120;
    private final static double prixkg = 5 ;
    private static int cpt=1;
    
    public GrappeRaisin(){
        super("GrappeRaisin"+" n°"+cpt,poidsg,prixkg,"graine");
        System.out.println("une vigne est plantée");
        cpt++;
    }
    public double getPrix(){
        return GrappeRaisin.prixkg*GrappeRaisin.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    @Override
    public boolean isAutomne(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }
    
}
