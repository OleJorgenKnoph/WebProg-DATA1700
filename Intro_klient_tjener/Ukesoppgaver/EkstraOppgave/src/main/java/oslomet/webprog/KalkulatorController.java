package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KalkulatorController {

    @GetMapping("/")
    public Double beregn(Regneart regneart) {

        double tall1 = 0;
        double tall2 = 0;
        String regning = regneart.getRegneart();

        Double sum;

        try {
            tall1 = regneart.getTall1();
        } catch (Exception e) {
            System.err.println("Error");
        }
        try {
            tall2 = regneart.getTall2();
        } catch (Exception e) {
            System.err.println("Error");
        }

        switch (regning) {
            case "pluss" : sum = pluss(tall1,tall2);
                break;
            case "minus" : sum = minus(tall1,tall2);
                break;
            case "gange" : sum = gange(tall1,tall2);
                break;
            case "dele" : sum = dele(tall1,tall2);
                break;

            default: sum = null;
        }
        return sum;

    }

    public double pluss(double t1, double t2){
        return t1 + t2;
    }
        public double minus(double t1, double t2){
            return t1 - t2;
        }
            public double gange(double t1, double t2){
                return t1 * t2;
        }
                public Double dele(double t1, double t2){
                if (t2 == 0){
                    System.err.println("Umulig å dele på 0");
                        return null;
                }
                else {
                    return t1 / t2;
                }
    }
}
