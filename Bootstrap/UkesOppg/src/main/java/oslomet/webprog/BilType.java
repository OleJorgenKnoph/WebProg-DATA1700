package oslomet.webprog;

public class BilType {
    String merke, type1, type2, type3;

    public BilType(String merke, String type1, String type2, String type3) {
        this.merke = merke;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
    }

    public BilType(){}

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
}
