package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public void lagreKunde(Motorvogn bil, HttpServletResponse response) throws IOException {
        if (!rep.lagreKunde(bil)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil på server - Prøv igjen senere");
        }
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

