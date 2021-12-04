public class Serre{
    public final int taille = 10;
    private Vegetaux[][] plantation = new Vegetaux[taille][taille];
    private static int nbVegetaux=0;
    private static int x=0,y=0;

    public Serre(){
        for(int i=0;i<taille;i++){
            for(int j=0;j<taille;j++){
                plantation[i][j]=new Friche("friche",0,0,"Vide");
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
                if(plantation[i][j].getEtat()=="mur"){
                    plantation[i][j]= new Friche("vide",0,0,"Vide");
                    nbVegetaux--;
                }
                else {
                    System.out.println("Vegetal pas encore mur");
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


