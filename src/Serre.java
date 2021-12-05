public class Serre{
    public final int taille = 3;
    private Vegetaux[][] plantation = new Vegetaux[taille][taille];
    private static int nbVegetaux=0;
    private static int x=0,y=0;

    public Serre(){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                plantation[i][j]=new Friche();
            }
        }    
    }

    public void planter(Vegetaux v){
        if(nbVegetaux<=taille*taille){
            if(x<taille){
                if(y<taille){
                    this.plantation[x][y] = v;
                    nbVegetaux++;
                    y++;
                }
                else{
                    x++;
                    y=0;
                    this.plantation[x][y] = v;
                    nbVegetaux++;
                }
            }
        } 
    }
    public void recolter(){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                if(!(plantation[i][j] instanceof Friche)){

                    if(plantation[i][j].getEtat()=="mûr"){
                        plantation[i][j]= new Friche();
                        nbVegetaux--;
                    }
                    else {
                        System.out.println("Vegetal pas encore mur");
                    }
                }
            
            }
        }
    }

    public void rafraichirSerre(){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                if(!(plantation[i][j] instanceof Friche)){

                    if(plantation[i][j].getEtat()=="perime"){
                        plantation[i][j]= new Friche();
                        nbVegetaux--;
                    }
                    else {
                        plantation[i][j].Pousser();
                    }
                }
            }
        }
    }
        
    public String toString(){
        String res="+";
        for(int i=0;i<taille;i++){
            res+="---";
        }
        res+="+\n";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v instanceof Friche) res+= " . ";
                else res+= " "+plantation[i][j].getNom().charAt(0)+" ";
            }
            res+="|\n";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="---";
        }
        res+="+\n";
        return res;
    }
 
}   


