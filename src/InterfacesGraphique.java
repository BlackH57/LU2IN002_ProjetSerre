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
                        JLabel recette = new JLabel("Vous avez fais "+(((float)Math.round(100*benefVente)/100) + "e de bénéfice."));
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