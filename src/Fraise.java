public class Fraise extends Fruit implements Printemps, Ete {
    private final static double prixkg = 7 ;
    private static int cpt=1;
    
    public Fraise(){
        super("Fraise"+" n°"+cpt,(int)(Math.random()*2)+10,prixkg,"graine");
        System.out.println("un fraisier est planté");
        cpt++;
    }
    public double getPrix(){
        return Fraise.prixkg*Fraise.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }
    
    
    @Override
    public boolean isPrintemps(Serre s) {
        return s.getSaison() == "Printemps";
    }

    public boolean isEte(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isPrintemps(s) || isEte(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.1){
                v.pousser();
            }
        }
    }
    
}
