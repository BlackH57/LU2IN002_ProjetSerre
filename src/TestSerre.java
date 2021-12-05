public class TestSerre {
    public static void main(String[] args){

        // création de la Serre

        Serre s = new Serre();
        
        // création de vegetaux

        int nbVegetauxMax = s.taille*s.taille;

        for(int i=0;i<=nbVegetauxMax;i++){
            s.planter(new Carotte());
        
        }
        
        // faire pousser les vegetaux

        s.rafraichirSerre();
        s.rafraichirSerre();

        // recolter les vegetaux murs

        s.recolter();

        System.out.println(s.toString());
    }
    
}
