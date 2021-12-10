public class Melon extends Fruit  implements Automne, Ete {
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

    @Override
    public boolean isEte(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public boolean isAutomne(Serre s){
        return s.getSaison() == "Automne";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s) || isEte(s)){
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
