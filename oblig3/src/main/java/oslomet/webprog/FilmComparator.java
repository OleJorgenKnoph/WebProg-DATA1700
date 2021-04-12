package oslomet.webprog;

import java.util.Comparator;

public class FilmComparator implements Comparator {

    public int compare(Object k1, Object k2){
        FilmBillett o1 = (FilmBillett) k1;
        FilmBillett o2 = (FilmBillett) k2;

        return o1.getEtternavn().compareTo(o2.getEtternavn());
    }
}
