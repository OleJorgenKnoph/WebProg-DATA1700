package oslomet.webprog;

public class BilRegister {
    String persNr, navn, adr, kjennetegn, merke, type;

    public BilRegister(String persNr, String navn, String adr, String kjennetegn, String merke, String type) {
        this.persNr = persNr;
        this.navn = navn;
        this.adr = adr;
        this.kjennetegn = kjennetegn;
        this.merke = merke;
        this.type = type;
    }

    public BilRegister(){}

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

    public String getKjennetegn() {
        return kjennetegn;
    }

    public void setKjennetegn(String kjennetegn) {
        this.kjennetegn = kjennetegn;
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
}
