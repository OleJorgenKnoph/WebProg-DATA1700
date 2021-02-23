package oslomet.webprog;

public class Regneart {
    private double tall1;
    private double tall2;
    private String regneart;

    public Regneart(double tall1, double tall2, String regneart) {
        this.tall1 = tall1;
        this.tall2 = tall2;
        this.regneart = regneart;
    }

    public Regneart(){}

    public double getTall1() {
        return tall1;
    }

    public void setTall1(double tall1) {
        this.tall1 = tall1;
    }

    public double getTall2() {
        return tall2;
    }

    public void setTall2(double tall2) {
        this.tall2 = tall2;
    }

    public String getRegneart() {
        return regneart;
    }

    public void setRegneart(String regneart) {
        this.regneart = regneart;
    }
}
