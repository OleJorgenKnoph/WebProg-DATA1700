package oslomet.webprog.datastrukturerOgRek;

public class RekDemo {

    public static void main(String[] args) {
        System.out.println("Live-koding - rekursjon");

        skrivHei(5);

        String testStreng = "bElle";
        if(!palindrom(testStreng.toUpperCase()))
            System.out.println(testStreng + " er IKKE et palindrom!");
        else
            System.out.println(testStreng + " er et palindrom!");
    }

    public static void skrivHei(int antallSomMangler)
    {
        if (antallSomMangler > 0)
        {
            System.out.println("Hei!");
            skrivHei( antallSomMangler - 1 );
        }
        System.out.println("Hoi!");
    }

    public static boolean palindrom(String str)
    {
        if (str.length() < 2)
            return true;
        else if (str.charAt( 0 ) == str.charAt(str.length() - 1))
            return palindrom(str.substring(1, str.length() - 1));
        else
            return false;
    }
}
