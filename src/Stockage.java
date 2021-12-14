import java.util.ArrayList;

public class Stockage {
	private int taille;
	private ArrayList<Vegetaux> stockeur;
	
	public Stockage(int taille) {
		this.taille = taille;
		stockeur = new ArrayList<Vegetaux>();
	}
	public Stockage() {
		this(100);
	}
	
	public boolean stocker(Vegetaux v) {
		if(stockeur.size()<taille) {
			stockeur.add(v);
			return true;
		}
		
		return false;
	}
	
	// Accesseurs

	public String toString() {
		String res = "Stockage : \n";
		for(Vegetaux v : stockeur) {
			res += "\t" + v.toString()+'\n';
		}
	return res;
	}

	public int getTaille(){
		return taille;
	}
	
	public int getStockeurSize(){
		return stockeur.size();
	}
	
	public Vegetaux getStockAtIndice(int index)  throws VegetauxException{
		if(index>= this.getStockeurSize()){
			throw new VegetauxException("Problème d'indice");
		}
		return this.stockeur.get(index);

	}
	public Vegetaux remove(int index){
		Vegetaux vtmp= this.stockeur.get(index);
		this.stockeur.remove(index);
		return vtmp;
	}

	public ArrayList<Vegetaux> getStockeur(){
		return stockeur;
	}
}
