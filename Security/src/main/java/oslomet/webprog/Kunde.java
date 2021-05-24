package oslomet.webprog;

public class Kunde {
    String id, persNr, navn, adr, regNr, merke, type, passord;

    public Kunde(String id, String persNr, String navn, String adr, String regNr, String merke, String type, String passord) {
        this.id = id;
        this.persNr = persNr;
        this.navn = navn;
        this.adr = adr;
        this.regNr = regNr;
        this.merke = merke;
        this.type = type;
        this.passord = passord;
    }

    public Kunde(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersNr() {
        return persNr;
    }

    public void setPersNr(String persNr) {
        this.persNr = persNr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }
}
