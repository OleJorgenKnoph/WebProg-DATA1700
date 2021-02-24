package oslomet.webprog;

public class Motorvogn {
    String persNr, navn, adresse, kjennetegn, bilmerke, type;

    public Motorvogn(String persNr, String navn, String adresse, String kjennetegn, String bilmerke, String type) {
        this.persNr = persNr;
        this.navn = navn;
        this.adresse = adresse;
        this.kjennetegn = kjennetegn;
        this.bilmerke = bilmerke;
        this.type = type;
    }

    public Motorvogn() { }

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

    public String getAdresse() {
        return adresse;
    }
        public void setAdresse(String adresse) {
            this.adresse = adresse;
        }

    public String getKjennetegn() {
        return kjennetegn;
    }
        public void setKjennetegn(String kjennetegn) {
            this.kjennetegn = kjennetegn;
        }

    public String getBilmerke() {
        return bilmerke;
    }
        public void setBilmerke(String bilmerke) {
            this.bilmerke = bilmerke;
        }

    public String getType() {
        return type;
    }
        public void setType(String type) {
            this.type = type;
        }
}
