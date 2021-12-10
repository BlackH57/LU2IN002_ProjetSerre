public class Kiwi extends Fruit implements Hiver {
    private final static double poidsg=(int)(Math.random()*11)+150;
    private final static double prixkg = 0.49 ;
    private static int cpt=1;
    
    public Kiwi(){
        super("Kiwi"+" n°"+cpt,poidsg,prixkg,"graine");
        cpt++;
    }
    public double getPrix(){
        return Kiwi.prixkg*Kiwi.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
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
            if(Math.random() < 0.1){
                v.pousser();
            }
        }
    }
}
