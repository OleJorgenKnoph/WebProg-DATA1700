package oslomet.oppg2eksamens;

public class Bruker {

    private String Brukernavn, Passord;

    public Bruker(String brukernavn, String passord) {
        Brukernavn = brukernavn;
        Passord = passord;
    }

    public Bruker(){}

    public String getBrukernavn() {
        return Brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        Brukernavn = brukernavn;
    }

    public String getPassord() {
        return Passord;
    }

    public void setPassord(String passord) {
        Passord = passord;
    }
}
