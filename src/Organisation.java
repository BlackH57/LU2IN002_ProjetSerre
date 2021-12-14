public class Organisation {
    private Stockage stock;
    private double recettes;
    
    public  Organisation(Stockage s, double recette){
        this.stock=s;
        this.recettes=recette;

    }
    public Organisation(double recette){
        this(new Stockage(), recette);
    }

    public double vente(Vegetaux v) throws VegetauxException{
        if(stock.getStockeurSize() == 0){
            throw new VegetauxException("Rupture de stock");
        }
        
        int len = stock.getStockeurSize();
        
        for(int i=0;i<len;i++){
            if(stock.getStockAtIndice(i).getClass()==v.getClass()){
                double benef=stock.getStockAtIndice(i).getPrix();
                stock.remove(i);
                recettes += benef;
                return benef;
            }
        }
        
        return 0;    
    }

    public double vente() throws VegetauxException{
        if(stock.getStockeurSize() == 0){
            throw new VegetauxException("Rupture de stock");
        }
        double benef = stock.getStockAtIndice(0).getPrix();
        stock.remove(0);
        recettes += benef;
        return benef;
    }
        
    public double taxe(double pourcentage){
        double soustrait = recettes*pourcentage/100;
        this.recettes -= soustrait; 
        return soustrait;
    }   

    // Accesseurs 
    public Stockage getStockage(){
        return stock;
    }
        
    public double getRecettes(){
        return recettes;
    }

}