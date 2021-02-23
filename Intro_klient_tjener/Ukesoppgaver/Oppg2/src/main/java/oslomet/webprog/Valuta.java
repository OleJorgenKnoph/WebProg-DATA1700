package oslomet.webprog;

public class Valuta {
    private String name;
    private Double value;

    public Valuta(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Valuta(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
