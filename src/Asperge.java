public class Asperge extends Legume implements Automne {
    private final static double prixkg = 0.90 ;
    private static int cpt=1;
    
    public Asperge(){
        super("Asperge"+" n°"+cpt,(int)(Math.random()*11)+150,prixkg,"graine");
        cpt++;
    }
    
    public int getCpt(){
        return cpt;
    }
    
    @Override
    public boolean isAutomne(Serre s) {
        return s.getSaison() == "Automne";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s)){
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
