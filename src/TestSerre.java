public class TestSerre {
    public static void main(String[] args){
        
        int taille = 10;

        // creation de la Serre
        Serre s = Serre.creationSerre(taille, "Hiver");
        // creation de l'organisation
        Organisation org = new Organisation(100);
        int nbVegetauxMax = s.taille*s.taille;

        // creation et plantation de vegetaux 
        for(int i=0;i<(int)(nbVegetauxMax/2) ;i++){
            s.planter(new Carotte());
            s.planter(new Navet());
        }
        
        int nbTours = 7;

        for(int i = 0; i<nbTours; i++){
            //System.out.println("Tour "+i+" : \n" + s.toString());
            //try {
            //    s.recolter(new Carotte(), org.getStockage());
            //    s.nextTour();
            //} catch (VegetauxException e){
            //    System.out.println("Pas le bon type d'objet");
            //    return;
            //}
            s.recolter(org.getStockage());
            s.nextTour();
        }

        System.out.println(org.getStockage());
        int len = org.getStockage().getStockeurSize();

        for(int i = 0; i<len;i++){
            try{
                double benef = org.vente();
                System.out.println("vente: +" + benef);
            }
            catch(VegetauxException e){
                System.out.println("Erreur: au tour" + i +" \ntaille : " + org.getStockage().getStockeurSize() + ", recette : " + org.getRecettes());
                break;
            }
            
        }

        System.out.println("recette : " + org.getRecettes());
    }
    
}
