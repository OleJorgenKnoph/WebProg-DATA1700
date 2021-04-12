package oslomet.webprog;

public class FilmBillett {
    String film, fornavn, etternavn, tlfnr, epost;
    int antall;

    public FilmBillett(String film, String fornavn, String etternavn, String epost, int antall) {
        this.film = film;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
        this.antall = antall;
    }

    public FilmBillett(){ }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTlfnr() {
        return tlfnr;
    }

    public void setTlfnr(String tlfnr) {
        this.tlfnr = tlfnr;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }
}
