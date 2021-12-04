public class TestSerre {
    public static void main(String[] args){

        Serre s = new Serre();
    
        Legume c1 = new Carotte();
        Legume p1 = new Poireau();
        Legume n1 = new Navet();

        Legume c2 = new Carotte();
        Legume p2 = new Poireau();
        Legume n2 = new Navet();

        c1.Pousser();
        c1.Pousser();
        n1.Pousser();
        p1.Pousser();

        System.out.println(c1.toString());
        System.out.println(p1.toString());
        System.out.println(n1.toString());

        System.out.println(c2.toString());
        System.out.println(p2.toString());
        System.out.println(n2.toString());

        for(int i=0;i<=Math.pow(s.taille,2);i++){
            s.planter(new Carotte());
            s.planter(new Poireau());
            s.planter(new Navet());
        }
        s.recolter();

        System.out.println(s.toString());
    }
    
}
