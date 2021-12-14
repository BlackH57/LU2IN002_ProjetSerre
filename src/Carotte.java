public class Carotte extends Legume implements Hiver {
    private final static double prixkg = 0.65 ;
    private static int cpt=0;

    public Carotte(){
        super("Carotte"+" n°"+cpt,(int)(Math.random()*11)+100,prixkg,"graine");
        cpt++;
    }
    
    @Override
    public boolean isHiver(Serre s) {
        return s.getSaison() == "Hiver";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isHiver(s)){
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
    

