package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class KinoController {

    ArrayList<FilmBillett> alleBilletter = new ArrayList<>();

    @PostMapping("/lagreBillett")
        public ArrayList<FilmBillett> enBillett(FilmBillett innKunde){
            alleBilletter.add(innKunde);
                return alleBilletter;
    }

    @GetMapping("/slett")
        public void slettAlle(){
            alleBilletter.clear();
    }
}
