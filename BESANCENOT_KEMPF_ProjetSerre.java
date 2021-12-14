public class Serre{
    public final int taille;
    private Vegetaux[][] plantation;
    private static int nbVegetaux = 0;

    private String saison;
    private static int nbTours;

    static int singleton = 0;

    // Constructeur
    public Serre(int taille, String saison) {
            this.saison = saison;
            this.taille = taille;

            plantation = new Vegetaux[taille][taille];

            for(int i = 0; i<taille; i++) {
                    for(int j = 0; j<taille;j++) {
                            plantation[i][j] = null;
                    }
            }
    }

    public Serre(String saison) {
            this(3, saison);
    }

    public Serre(int taille) {
            this(taille, "Printemps");
    }

    public Serre(){
            this(3, "Printemps");
    }

    public static Serre creationSerre(int taille, String saison){
            if(singleton == 0){
                    singleton ++;
                    return new Serre(taille, saison);
            }

            return null;
    }

    public static Serre creationSerre(int taille){
            if(singleton == 0){
                    singleton ++;
                    return new Serre(taille);
            }

            return null;
    }

    public static Serre creationSerre(String saison){
            if(singleton == 0){
                    singleton ++;
                    return new Serre();
            }

            return null;
    }

    public static Serre creationSerre(){
            if(singleton == 0){
                    singleton ++;
                    return new Serre();
            }

            return null;
    }


    // Methodes gestion de la serre
    public void planter(Vegetaux v) {
            ///On vérifie qu'il n y a de la place sur la plantation
            if(nbVegetaux <= taille*taille) {

                    ///On parcourt le terrain et des qu'on trouve une place libre on plante
                    for(int i = 0; i<taille;i++) {
                            for(int j = 0; j<taille;j++) {
                                    if(plantation[i][j] == null) {
                                            plantation[i][j] = v;
                                            nbVegetaux++;
                                            return;
                                    }
                            }
                    }
            }
            else System.out.println("Il n'y a plus de place sur la plantation");
    }

    public void recolter(Object vegetaux, Stockage stock)  throws VegetauxException{
            ///On pourra mettre un catch ici
            if(!(vegetaux instanceof Vegetaux)) {
                    throw new VegetauxException("L'objet mis en paramétre n'est pas un végétal");

            }
            for(int i=0;i<taille;i++){
                    for(int j=0;j<taille;j++){
                            if((plantation[i][j] != null) && (plantation[i][j].getClass() == vegetaux.getClass())) {                                        
                                if(plantation[i][j].getEtat() == "mûr") {
                                    if(stock.stocker(plantation[i][j]));
                                    System.out.println(plantation[i][j].toString() + " a été récolté !" );
                                    System.out.println(plantation[i][j].toString() + " a été récolté !" );
                                    System.out.println(plantation[i][j].toString() + " a été récolté !" );
                                    plantation[i][j] = null;
                                    Serre.nbVegetaux--;
                                    Vegetaux.nbVegetaux--;
                                }
                                    //else System.out.println("Pas encore mûr");
                            }
                    }
            }
    }

    public void recolter(Stockage stock){
            for(int i=0;i<taille;i++){
                    for(int j=0;j<taille;j++){
                            if((plantation[i][j] != null) && (plantation[i][j].getEtat() == "mûr")) {
                                    if(stock.stocker(plantation[i][j])){
                                            System.out.println(plantation[i][j].toString() + " a été récolté ! \n" );
                                            plantation[i][j] = null;
                                            Serre.nbVegetaux--;
                                            Vegetaux.nbVegetaux--;

                                    }
                            //else if(plantation[i][j] instanceof Vegetaux){System.out.println("Pas encore mur");}
                            }
                    }
            }
    }

    public void rafraichirSerre(Serre s){
            for(int i=0;i<taille;i++){
                    for(int j=0;j<taille;j++){
                            if(plantation[i][j] != null){
                                    if(plantation[i][j].getEtat()=="Perime"){
                                            plantation[i][j] = null;
                                            Serre.nbVegetaux--;
                                            Vegetaux.nbVegetaux--;
                                    }
                                    else {
                                            plantation[i][j].pousse(plantation[i][j], this);
                                    }
                            }
                    }
            }
    }

    // Methodes gestion facteurs exterieurs
    public void setNextSaison(){
            if(saison == "Printemps"){ saison = "Ete"; return;}
            if(saison == "Ete") {saison = "Automne"; return;}
            if(saison == "Automne") {saison = "Hiver"; return;}
            if(saison == "Hiver") {saison = "Printemps"; return;}
    }

    public void updateSaison(){
            if(nbTours%3 == 0){
                    setNextSaison();
                    System.out.println("\nOn passe en " + this.getSaison() + "\n");
            }
    }

    public void nextTour(){
            nbTours++;
            updateSaison();
            rafraichirSerre(this);

    }


    // Methodes générique
    public String toString(){
        String res="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+\n";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v == null) res+= "    ";
                else res+= " "+plantation[i][j].getNom().charAt(0)+plantation[i][j].getEtat().charAt(0) + " ";
            }
            res+="|\n";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+\n";
        return res;
    }

    public String getSaison(){
            return this.saison;
    }

    public String toStringHTML(){
        String res="<html>+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+<br>";
        for(int i=0;i<taille;i++){
            res+="|";
            for(int j=0;j<taille;j++){
                Vegetaux v = plantation[i][j];
                if(v == null) res+= "....";
                else res+= "."+plantation[i][j].getNom().charAt(0)+plantation[i][j].getEtat().charAt(0) + ".";
            }
            res+="|<br>";
        }
        res+="+";
        for(int i=0;i<taille;i++){
            res+="----";
        }
        res+="+<br>";
        return res;
    }

    public int getNbVegetaux(){
            return nbVegetaux;
    }
}


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

public abstract class Vegetaux{
    private String nom;
    private double poidsg;
    private double prixkg;
    private String etat;
    public static int nbVegetaux;

    public Vegetaux(String nom,double poids,double prixPoids,String etat){
        this.nom=nom;
        this.poidsg=poids;
        this.prixkg=prixPoids;
        this.etat="graine";
        nbVegetaux++;
    }


    public void pousser(){
        if(this.etat=="mûr") this.etat="Perime";
        if(this.etat=="preLeg") this.etat="mûr";
        if(this.etat=="graine") this.etat="preLeg";

    }
    public String toString(){
        return nom+" : "  + poidsg + " g, " + prixkg + "€ : " + etat;
    }

    public abstract void pousse(Vegetaux v, Serre s);
    // Accesseurs

    public String getNom(){
        return nom;
    }
    public String getEtat(){
        return etat;
    }
    public double getPrix(){
        return this.prixkg*this.getPoids();
    }
    public double getPoids(){
        return this.poidsg/1000;

    }

}
public class VegetauxException extends Exception {
    public VegetauxException(String message){
        super("Erreur de Vegetaux : " + message);
    }
}
public interface Automne {
    public boolean isAutomne(Serre s);
    public void pousse(Vegetaux v, Serre s);
}

public interface Ete {
    public boolean isEte(Serre s);
    public void pousse(Vegetaux v, Serre s);
}

public interface Hiver {
    public boolean isHiver(Serre s);
    public void pousse(Vegetaux v, Serre s);
}

public interface Printemps {
    public boolean isPrintemps(Serre s);
    public void pousse(Vegetaux v, Serre s);
}


public abstract class Fruit extends Vegetaux{

    public Fruit(String nom,double poids,double prixPoids,String etat){
        super(nom,poids,prixPoids,etat);
    }

    public abstract void pousse(Vegetaux v, Serre s);
}

public abstract class Legume extends Vegetaux{

    public Legume(String nom,double poids,double prixPoids,String etat){
        super(nom,poids,prixPoids,etat);
    }

    public abstract void pousse(Vegetaux v, Serre s);
}


public class Kiwi extends Fruit implements Hiver {
    private final static double prixkg = 0.49 ;
    private static int cpt=1;

    public Kiwi(){
        super("Kiwi"+" n°"+cpt,(int)(Math.random()*11)+150,prixkg,"graine");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }


    @Override
    public boolean isHiver(Serre s) {
        return s.getSaison() == "Hiver";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isHiver(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }
}

public class Melon extends Fruit  implements Automne, Ete {
    private final static double prixkg = 2 ;
    private static int cpt=1;

    public Melon(){
        super("Melon"+" n°"+cpt,(int)(Math.random()*50)+750,prixkg,"graine");
        System.out.println("un plant de melon est planté");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }

    @Override
    public boolean isEte(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public boolean isAutomne(Serre s){
        return s.getSaison() == "Automne";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s) || isEte(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}

public class Navet extends Legume implements Printemps {
    private final static double prixkg = 1.38 ;
    private static int cpt=1;

    public Navet(){
        super("Navet"+" n°"+cpt,(int)(Math.random()*11)+300,prixkg,"graine");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }


    @Override
    public boolean isPrintemps(Serre s) {
        if(s.getSaison() == "Printemps"){
            return true;
        }
        return false;
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isPrintemps(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}



public class GrappeRaisin extends Fruit implements Automne{
    private final static double poidsg = (int)(Math.random()*10)+120;
    private final static double prixkg = 5 ;
    private static int cpt=1;

    public GrappeRaisin(){
        super("GrappeRaisin"+" n°"+cpt,poidsg,prixkg,"graine");
        System.out.println("une vigne est planté");
        cpt++;
    }
    public double getPrix(){
        return GrappeRaisin.prixkg*GrappeRaisin.poidsg/1000;
    }
    public int getCpt(){
        return cpt;
    }

    @Override
    public boolean isAutomne(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}

public class Asperge extends Legume implements Automne {
    private final static double prixkg = 0.90 ;
    private static int cpt=1;

    public Asperge(){
        super("Asperge"+" n°"+cpt,(int)(Math.random()*11)+150,prixkg,"graine");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }

    @Override
    public boolean isAutomne(Serre s) {
        return s.getSaison() == "Automne";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isAutomne(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}

public class Carotte extends Legume implements Hiver {
    private final static double prixkg = 0.65 ;
    private static int cpt=0;

    public Carotte(){
        super("Carotte"+" n°"+cpt,(int)(Math.random()*11)+100,prixkg,"graine");
        cpt++;
    }

    @Override
    public boolean isHiver(Serre s) {
        return s.getSaison() == "Hiver";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isHiver(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}



public class Fraise extends Fruit implements Printemps, Ete {
    private final static double prixkg = 7 ;
    private static int cpt=1;

    public Fraise(){
        super("Fraise"+" n°"+cpt,(int)(Math.random()*2)+10,prixkg,"graine");
        System.out.println("un fraisier est planté");
        cpt++;
    }

    public int getCpt(){
        return cpt;
    }


    @Override
    public boolean isPrintemps(Serre s) {
        return s.getSaison() == "Printemps";
    }

    public boolean isEte(Serre s) {
        return s.getSaison() == "Ete";
    }

    @Override
    public void pousse(Vegetaux v, Serre s) {
        if(isPrintemps(s) || isEte(s)){
            if(Math.random() < 0.8){
                v.pousser();
            }
        }
        else{
            if(Math.random() < 0.3){
                v.pousser();
            }
        }
    }

}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfacesGraphique {
    public static void main(String[] args){

        int taille = 10;

        // creation de la Serre
        Serre s = Serre.creationSerre(taille, "Hiver");
        // creation de l'organisation
        Organisation org = new Organisation(100);

        // Creation fenetre principal
        JFrame mainWindow = new JFrame("fenetre principale");
        mainWindow.setSize(1600,800);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font monospace30 = new Font("Courier", Font.BOLD,30);
        Font monospace15 = new Font("Courier", Font.BOLD,15);

        // Creation GridLayout
        GridLayout gridGlobal = new GridLayout(1,0);
        GridLayout gridInformation = new GridLayout(0,1);

        // Creation du label contenant la serre
        JLabel serreLabel = new JLabel(s.toStringHTML(), JLabel.CENTER);
        serreLabel.setFont(monospace30);

        // Creation label qui contient la saison
        JLabel saisonLabel = new JLabel("Saison : " + s.getSaison(), JLabel.CENTER);
        saisonLabel.setFont(monospace15);

        // Creation label qui contient les recettes
        JLabel recetteLabel = new JLabel("Recettes : " + (float)((int)(100*org.getRecettes()))/100, JLabel.CENTER);
        recetteLabel.setFont(monospace15);

        // Creation panel serre
        JPanel panelSerre = new JPanel();

        // Creation Panel information
        JPanel panelInformation = new JPanel();

        //Creation bouton NextTour
        JButton bNextTour = new JButton("Next Round");
        //bNextTour.setPreferredSize(new Dimension(30,15));
        bNextTour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                s.nextTour();
                serreLabel.setText(s.toStringHTML());
                saisonLabel.setText("Saison : " + s.getSaison());
                org.taxe(2);
                recetteLabel.setText("Recettes : " + (float)((int)(100*org.getRecettes()))/100);
            }
        });


        JButton bRecolte = new JButton("Recolter");
        bRecolte.setPreferredSize(new Dimension(30,15));
        bRecolte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                s.recolter(org.getStockage());
                serreLabel.setText(s.toStringHTML());
                System.out.println("Il y a "+s.getNbVegetaux()+" dans la serre, il reste "+(s.taille*s.taille - s.getNbVegetaux())+" places");
            }
        });

        JButton bPlanter = new JButton("Planter");
        bPlanter.setPreferredSize(new Dimension(30,15));

        bPlanter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame plante = new JFrame("Planter");
                plante.setSize(300,300);
                JLabel question = new JLabel("Que voulez vous plantez?", JLabel.CENTER);
                question.setVisible(true);

                JButton legume = new JButton("Legume");
                legume.setVisible(true);

                JButton fruit = new JButton("Fruit");
                fruit.setVisible(true);

                legume.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JFrame legumeF = new JFrame("Legume");
                        legumeF.setSize(1000,100);
                        String[] possLegs = {"Asperge", "Carotte", "Navet"};
                        JComboBox<Legume> legsJcomb = new JComboBox(possLegs);
                        legsJcomb.setVisible(true);

                        JTextField nbPlantation = new JTextField();
                        nbPlantation.setVisible(true);

                        JButton planter = new JButton("OK");
                        planter.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                if(nbPlantation.getText()!=""){
                                    int nb = Integer.valueOf(nbPlantation.getText());

                                    if(legsJcomb.getSelectedItem() == "Asperge"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Asperge());
                                        }
                                    }
                                    if(legsJcomb.getSelectedItem() == "Carotte"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Carotte());
                                        }
                                    }
                                    if(legsJcomb.getSelectedItem() == "Navet"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Navet());
                                        }
                                    }
                                }
                                serreLabel.setText(s.toStringHTML());
                                legumeF.dispose();
                                plante.dispose();
                            }
                        });
                        GridLayout legumeFGrid = new GridLayout(1,0);
                        legumeF.setLayout(legumeFGrid);

                        legumeF.add(nbPlantation);
                        legumeF.add(legsJcomb);
                        legumeF.add(planter);
                        legumeF.setVisible(true);
                    }
                });

                fruit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        JFrame fruitF = new JFrame("Fruit");
                        fruitF.setSize(1000,100);
                        String[] possFruit = {"Fraise", "Kiwi", "Melon", "Raisin"};
                        JComboBox<Legume> fruitJcomb = new JComboBox(possFruit);
                        fruitJcomb.setVisible(true);

                        JTextField nbPlantation = new JTextField();
                        nbPlantation.setVisible(true);

                        JButton planterOK = new JButton("OK");

                        planterOK.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                System.out.println(fruitJcomb.getSelectedItem());
                                if(nbPlantation.getText()!=""){
                                    int nb = Integer.valueOf(nbPlantation.getText());

                                    if(fruitJcomb.getSelectedItem() == "Fraise"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Fraise());
                                        }
                                    }
                                    if(fruitJcomb.getSelectedItem() == "Melon"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Melon());
                                        }
                                    }
                                    if(fruitJcomb.getSelectedItem() == "Raisin"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new GrappeRaisin());
                                        }
                                    }
                                    if(fruitJcomb.getSelectedItem() == "Kiwi"){
                                        for(int i = 0; i <nb; i++){
                                            s.planter(new Kiwi());
                                        }
                                    }
                                }
                                serreLabel.setText(s.toStringHTML());
                                fruitF.dispose();
                                plante.dispose();
                            }
                        });

                        GridLayout fruitFGrid = new GridLayout(1,0);
                        fruitF.setLayout(fruitFGrid);

                        fruitF.add(nbPlantation);
                        fruitF.add(fruitJcomb);
                        fruitF.add(planterOK);
                        fruitF.setVisible(true);
                    }
                });

                GridLayout planteGrid = new GridLayout(0,1);
                plante.setLayout(planteGrid);
                plante.add(question);
                plante.add(legume);
                plante.add(fruit);
                plante.setVisible(true);
            }
        });

        JButton accessStockage = new JButton("Stockage");
        accessStockage.setVisible(true);
        accessStockage.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame stockageF = new JFrame("Stockage");
                stockageF.setSize(800,500);

                JPanel stockageP = new JPanel();

                GridLayout gridStock = new GridLayout(0,1);
                stockageP.setLayout(gridStock);

                JScrollPane jsp = new JScrollPane(stockageP);


                JLabel labelName = new JLabel("Stockage : ",JLabel.CENTER);
                labelName.setVisible(true);

                stockageP.add(labelName);

                for(Vegetaux v: org.getStockage().getStockeur()){
                    JLabel vegL = new JLabel(v.toString(), JLabel.CENTER);
                    vegL.setVisible(true);

                    stockageP.add(vegL);
                }

                jsp.setViewportView( stockageP );
                jsp.setVisible(true);

                JButton bVendre = new JButton("Vendre");
                bVendre.setVisible(true);
                bVendre.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        double benefVente = 0.0;
                        while(org.getStockage().getStockeur().size() != 0 ){
                            try {
                                benefVente += org.vente();
                            } catch (VegetauxException e1) {
                                System.out.println("Erreur de vente : Probablement rupture de stock");
                            }
                        }
                        recetteLabel.setText("Recettes : " + (float)(Math.round(100*org.getRecettes()))/100);
                        stockageF.dispose();

                        JFrame recetteF = new JFrame("Bénéfice");
                        recetteF.setSize(300,100);
                        JLabel recette = new JLabel("Vous avez fais "+(((float)Math.round(100*benefVente)/100) + "€ de bénéfice."));
                        recette.setVisible(true);

                        recetteF.add(recette);
                        recetteF.setVisible(true);
                    }
                });

                GridLayout gridStockage = new GridLayout(1,0);
                stockageF.setLayout(gridStockage);
                stockageF.setVisible(true);

                stockageF.add(jsp);
                stockageF.add(bVendre);
            }
        });

        panelInformation.setLayout(gridInformation);
        panelInformation.add(saisonLabel);
        panelInformation.add(recetteLabel);
        panelInformation.add(bRecolte);
        panelInformation.add(bPlanter);
        panelInformation.add(accessStockage);
        panelInformation.setVisible(true);

        panelSerre.add(bNextTour);
        panelSerre.add(serreLabel);

        mainWindow.setLayout(gridGlobal);
        mainWindow.add(panelSerre);
        mainWindow.add(panelInformation);
        mainWindow.setVisible(true);
    }
}

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
