package oslomet.webprog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class MotorvognController {

    ArrayList<Motorvogn> biler = new ArrayList<>();

    @PostMapping("/regBil")
        public ArrayList<Motorvogn> enBil(Motorvogn enBil){
            biler.add(enBil);
                return biler;
    }

    @GetMapping("/slett")
        public void slettArray(){
        biler.clear();
    }
}
