public class Navet extends Legume implements Printemps {
    private final static double prixkg = 1.38 ;
    private static int cpt=1;
    
    public Navet(){
        super("Navet"+" n°"+cpt,(int)(Math.random()*11)+300,prixkg,"graine");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }

    
    @Override
    public boolean isPrintemps(Serre s) {
        if(s.getSaison() == "Printemps"){
            return true;
        }
        return false;
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isPrintemps(s)){
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
