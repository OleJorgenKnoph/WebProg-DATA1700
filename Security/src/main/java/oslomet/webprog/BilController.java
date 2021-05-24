package oslomet.webprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
public class BilController {

    @Autowired
    BilRepository rep;

    private Logger logger = LoggerFactory.getLogger(BilController.class);

    private boolean validerKunde(Kunde kunde){
        String regExPersNr = "[0-9]{11}";
        String regExNavn = "[a-zA-ZæøåÆØÅ. \\-]{2,25}";
        String regExAdr = "[a-zA-ZæøåÆØÅ.0-9 \\-]{5,70}";
        String regExRegNr = "[A-Za-z\\-]{2}[0-9\\-]{5}";
        String regExPassord = "[A-Za-zæøå0-9\\-]{4,}";


        boolean persNrOK = kunde.getPersNr().matches(regExPersNr);
        boolean navnOK = kunde.getNavn().matches(regExNavn);
        boolean adrOK = kunde.getAdr().matches(regExAdr);
        boolean regnrOK = kunde.getRegNr().matches(regExRegNr);
        boolean passordOK = kunde.getPassord().matches(regExPassord);

        if (persNrOK && navnOK && adrOK && regnrOK && passordOK){
            return true;
        }
        System.out.println(persNrOK);
        System.out.println(navnOK);
        System.out.println(adrOK);
        System.out.println(regnrOK);
        System.out.println(passordOK);

        logger.error("Valideringsfeil");
        return false;
    }

    @GetMapping("/hentAlleBiler")
    public List<Bil> hentAlleBiler(HttpServletResponse response) throws IOException {

        List<Bil> alleBiler = rep.hentAlleBiler();

        if (alleBiler == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
        }

        return alleBiler;
    }

    @PostMapping("/lagreKunde")
    public void lagreKunde(Kunde kunde, HttpServletResponse response) throws IOException{
        if (!validerKunde(kunde)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i validering - prøv igjen senere");
        }
        else {
            if (!rep.lagreKunde(kunde)) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
            }
        }
    }

    @GetMapping("/hentKunder")
    public List<Kunde> hentKunder(HttpServletResponse response) throws IOException{
        List<Kunde> alleKunder;

    if (session.getAttribute("Innlogget") != null) {
        alleKunder = rep.hentAlleKunder();
        if (alleKunder == null) {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
        }
        return alleKunder;
    }
    response.sendError(HttpStatus.NOT_FOUND.value(), "Logg inn for å se kunderegisteret");
    return null;
    }

    @GetMapping("/hentEnKunde")
    public Kunde hentEnKunde(int id, HttpServletResponse response) throws IOException{
        Kunde kunde = rep.hentEnKunde(id);

        if (kunde == null){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
        }
        return kunde;
    }

    @GetMapping("/slettEnKunde")
    public void slettEnKunde(int id, HttpServletResponse response) throws IOException{

        if(!rep.slettEnKunde(id)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
        }
    }

    @GetMapping("/slettAlle")
    public void slettAlle(HttpServletResponse response) throws IOException{
        if (session.getAttribute("Innlogget")!= null) {

            if (!rep.slettAlle()) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
            }
        }
    }

    @PostMapping("/oppdaterKunde")
    public void oppdaterKunde(Kunde kunde, HttpServletResponse response) throws IOException{
        if(!rep.oppdaterKunde(kunde)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i DB - prøv igjen senere");
        }
    }


    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    public boolean login(Kunde kunde){
        if (rep.sjekkNavnOgPassord(kunde)){
            session.setAttribute("Innlogget", kunde);
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public void logout(){
        session.removeAttribute("Innlogget");
    }

    @GetMapping("/sjekkInnlogget")
    public boolean sjekkInnlogget(){
        if (session.getAttribute("Innlogget")!=null){
            return true;
        }
        return false;
    }
}
