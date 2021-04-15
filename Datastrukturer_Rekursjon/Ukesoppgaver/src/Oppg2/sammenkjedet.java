package Oppg2;

public class sammenkjedet {

    public static void main(String[] args) {
        NodeKlasse sammenkjedetListe = new NodeKlasse();

            sammenkjedetListe.leggTilNode(1);
            sammenkjedetListe.leggTilNode(2);
            sammenkjedetListe.leggTilNode(3);
            sammenkjedetListe.leggTilNode(4);

            sammenkjedetListe.skrivUt();

            int sokeVerdi = 3;
            if (sammenkjedetListe.inneholderNode(sokeVerdi)){
                System.out.println("Lista inneholder " + sokeVerdi);
            }
            else System.out.println("Lista inneholder ikke " + sokeVerdi);
    }
}
