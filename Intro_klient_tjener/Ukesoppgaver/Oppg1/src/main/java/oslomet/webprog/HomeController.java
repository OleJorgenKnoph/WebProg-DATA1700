package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final Integer[] tempArray = new Integer[]{-3, -2, 2, 7, 12, 16, 18, 17, 12, 7, 3, -2};

    @GetMapping("/snittTemp")
    public int snittTemp(String maaned) {

        int temp = 0;

        switch (maaned) {
            case "JANUAR":
                temp = tempArray[0];
                break;
            case "FEBRUAR":
                temp = tempArray[1];
                break;
            case "MARS":
                temp = tempArray[2];
                break;
            case "APRIL":
                temp = tempArray[3];
                break;
            case "MAI":
                temp = tempArray[4];
                break;
            case "JUNI":
                temp = tempArray[5];
                break;
            case "JULI":
                temp = tempArray[6];
                break;
            case "AUGUST":
                temp = tempArray[7];
                break;
            case "SEPTEMBER":
                temp = tempArray[8];
                break;
            case "OKTOBER":
                temp = tempArray[9];
                break;
            case "NOVEMBER":
                temp = tempArray[10];
                break;
            case "DESEMBER":
                temp = tempArray[11];
                break;
        }
        return temp;
    }
}
