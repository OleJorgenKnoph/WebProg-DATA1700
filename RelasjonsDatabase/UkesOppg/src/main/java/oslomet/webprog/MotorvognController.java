package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotorvognController {

    @Autowired
    private BilRepository rep;

    @GetMapping("/hentBiler")
    public List<Bil> hentBiler() {
        return rep.hentAlleBiler();
    }

    @PostMapping("/lagre")
    public void lagreKunde(Motorvogn bil){
        rep.lagreKunde(bil);
    }

    @GetMapping("/hentAlle")
    public List<Motorvogn> hentAlle(){
        return rep.hentAlleKunder();
    }

    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlleKunder();
    }

    @GetMapping("/slettEn")
    public void slettEn(int id){
        rep.slettEnKunde(id);
    }
}

