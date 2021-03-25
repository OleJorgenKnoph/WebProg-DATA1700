package oslomet.webprog;

public class EnkelListeDemo {

    public static void main(String[] args) {

        System.out.println("Enkel enveis sammenkjedet liste:");

            MinListe minListe = new MinListe();

                minListe.leggTil(1);
                minListe.leggTil(2);
                minListe.leggTil(3);
                minListe.leggTil(4);
                minListe.leggTil(5);

        minListe.skrivUt();
System.out.println();
          /* int sokeVerdi = 5;
                if (minListe.inneholderNode(sokeVerdi)){
                    System.out.println("Listen innholder verdien " + sokeVerdi);
                }
                else {
                    System.out.println("Listen innholder ikke verdien " + sokeVerdi);
                }

            int slettNode = 2;
                minListe.slettVerdi(slettNode);

                minListe.skrivUt();*/

        System.out.println("----------------------------");

        Stakk stakk = new Stakk();

            stakk.push(8);
            stakk.push(23);
            stakk.push(3);
            stakk.push(9);

                stakk.printOut();

                System.out.println();
                System.out.println(stakk.peek());

                stakk.pop();
                stakk.printOut();

    }
}
