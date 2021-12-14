import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class InterfaceGraphique{
    public static void main(String[] args){

    // Frame 1 
    JFrame frame = new JFrame();
    
    
    JLabel label = new JLabel("Que voulez vous planter ?", JLabel.CENTER);
    frame.add(label);

    // Fruit ou Legume

    JPanel panel = new JPanel();
    // DÃ©finir les boutons
    JButton btn1 = new JButton("Fruit");
    JButton btn2 = new JButton("Legume");      
    // Ajouter les boutons au frame
    panel.add(btn1); 
    panel.add(btn2);
     
    // Ajouter label et panel au frame
    frame.setLayout(new GridLayout(2, 1));
    frame.add(label);
    frame.add(panel);

    btn1.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){
            JFrame frame4 = new JFrame();
            JLabel label2 = new JLabel("Choisir le fruit", JLabel.CENTER);
            frame4.add(label2);
            JPanel panel2 = new JPanel();
            JButton btn11 = new JButton("Fraise");
            JButton btn21 = new JButton("GrappeRaisin");  
            JButton btn31 = new JButton("Melon");
            JButton btn41 = new JButton("Kiwi");  
            panel2.add(btn11);
            panel2.add(btn21);
            panel2.add(btn31);
            panel2.add(btn41);

            frame4.setLayout(new GridLayout(2, 1));
            frame4.add(label2);
            frame4.add(panel2);

            frame4.pack();
            frame4.setSize(250, 250);
            frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame4.setVisible(true);

            btn11.addActionListener(new ActionListener(){ 
                public void actionPerformed(ActionEvent e){
                    JLabel label3 = new JLabel("Choisir le nombre de fruit", JLabel.CENTER);
                    JPanel panel3 = new JPanel();
                    JFrame frame5 = new JFrame();
                    frame5.add(label3);
                    JSlider slider = new JSlider();
                    slider.setMajorTickSpacing(20);
                    slider.setMinorTickSpacing(5);
                    slider.setPaintTicks(true);
                    slider.setPaintLabels(true);

                    frame5.setLayout(new GridLayout(2, 1));
                    frame5.add(slider);
                    frame5.add(label3);
                    frame5.add(panel3);
                    frame5.pack();
                    frame5.setSize(400, 200);

                    frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame5.setVisible(true);

                }
             });

    

        }
    });
}
}