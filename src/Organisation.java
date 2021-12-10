public class Organisation {
    private Stockage stock;
    private static double recettes;
    
    public  Organisation(Stockage s){
        this.stock=s;
        this.recettes=0.0;

    }
    public Organisation(){
        this(new Stockage());
    }

    public double vente(Vegetaux v){
        for(int i=0;i<stock.getTaille();i++){
            if(stock.getStockAtIndice(i).getClass()==v.getClass()){
                double benef=stock.getStockAtIndice(i).getPrix() * stock.getStockAtIndice(i).getPoids();
                stock.remove(i);
                return benef;

            }

        }
        System.out.println("Rupture de stock");
        return 0;
    
    }





}


