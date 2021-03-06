package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MotorvognControlller {

        @GetMapping("/lastTypene")
            public ArrayList<BilType> lastInnType(){
                ArrayList<BilType> alleTyper = new ArrayList<>();
                    alleTyper.add(new BilType("Audi", "A4", "Q5", "RS6"));
                    alleTyper.add(new BilType("Volvo", "XC40 Recharge", "240", "XC70"));
                    alleTyper.add(new BilType("BMW", "i3", "X5", "iX"));
            return alleTyper;
        }

    ArrayList<BilRegister> alleBiler = new ArrayList<>();

    @PostMapping("/regBil")
            public ArrayList<BilRegister> regBilKunde(BilRegister innBil){
                    alleBiler.add(innBil);
                return alleBiler;
        }

    @GetMapping("/slett")
        public void slettArray(){
            alleBiler.clear();
    }
}
