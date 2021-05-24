package oslomet.webprog;

public class Bil {
    String merke, type;
    int bil_id;

    public Bil(String merke, String type, int bil_id) {
        this.merke = merke;
        this.type = type;
        this.bil_id = bil_id;
    }

    public Bil(){}

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

    public int getBil_id() {
        return bil_id;
    }

    public void setBil_id(int bil_id) {
        this.bil_id = bil_id;
    }
}
