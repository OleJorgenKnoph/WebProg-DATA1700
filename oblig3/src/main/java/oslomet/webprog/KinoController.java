package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KinoController {

    @Autowired
    FilmRepository rep;

    @PostMapping("/lagreBillett")
        public List<FilmBillett> lagreKunde(FilmBillett innKunde){
            rep.lagreKunde(innKunde);

            return rep.hentKunder();
    }

    @GetMapping("/slett")
        public void slettAlle(){
            rep.slettKunder();
    }
}
