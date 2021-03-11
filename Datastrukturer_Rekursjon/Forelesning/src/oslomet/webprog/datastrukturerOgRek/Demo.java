package oslomet.webprog.datastrukturerOgRek;

import java.util.*;

public class Demo {
//REKURSJON
    public static void skrivHei(int antall){
        if (antall > 0){
            System.out.println("Hei!");
                skrivHei(antall-1);
        }
        System.out.println("annet");
    }
    public static void main(String[] args) {
        skrivHei(5);


        /*    int[] array = {1, 3, 23, 43, 77};

        List<Integer> enkelListe = new ArrayList<>();
        List<Integer> sammekjedetListe = new LinkedList<>();
        List<Integer> stakk = new Stack<>();

            enkelListe.add(1);
            sammekjedetListe.add(2);
                /*stakk.add(2);
                stakk.add(3);
                stakk.add(8);
                stakk.add(1);
                stakk.add(13);
            stakk.addAll(Arrays.asList(3,3,3,3,3));



        System.out.println(enkelListe);
        System.out.println(sammekjedetListe);
        System.out.println(stakk);


        enkelListe.remove(0);
        sammekjedetListe.remove(0);
        stakk.remove(0);

        System.out.println(enkelListe);
        System.out.println(sammekjedetListe);

        System.out.println(enkelListe.size());
        System.out.println(sammekjedetListe.size());
        System.out.println(stakk.size());

        //CAST
            Stack<Integer> stakk2 */

    }
}
