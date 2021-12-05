public class TestSerre {
    public static void main(String[] args){
    	
        // creation de la Serre
        Serre s = new Serre(5);
        // creation du stockage
        Stockage stock = new Stockage();
        // creation de vegetaux
        int nbVegetauxMax = s.taille*s.taille;
        
        Carotte c = new Carotte();
        
        for(int i=0;i<nbVegetauxMax;i++){
            s.planter(new Carotte());
        
        }
        
        System.out.println(s.toString());
        // faire pousser les vegetaux

        s.rafraichirSerre();
        s.rafraichirSerre();
        
        // recolter les vegetaux murs
        s.recolter(c, stock);
        System.out.println(stock.toString());
        
        // faire pourrir les vegetaux
        ///s.rafraichirSerre();
        ///s.rafraichirSerre();
        

        System.out.println(s.toString());
    }
    
}
