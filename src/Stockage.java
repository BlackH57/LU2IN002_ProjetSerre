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
	
	public String toString() {
		String res = "Stockage : \n";
		for(Vegetaux v : stockeur) {
			res += v.toString()+'\n';
		}
	return res;
	}
}
