public class VegetauxException extends Exception {
    public VegetauxException(String message){
        super("Erreur de Vegetaux : " + message);
    }
}
