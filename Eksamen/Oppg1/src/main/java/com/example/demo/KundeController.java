package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class KundeController {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Kunde.class);


    private boolean validerKunde(Kunde kunde){
        String regExNavn = "[a-zA-ZæøåÆØÅ. \\-]{2,75}";
        String regExAdresse = "[a-zA-ZæøåÆØÅ.0-9 \\-]{5,70}";
        String regExPostnr = "[0-9]{4}";
        String regExTlf = "[0-9]{8}"; //Antar kun norskt tlf-nr
        String regExEpost = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
        String regExTall = "[0-9]{1,11}(?:\\.[0-9]{1,3})?"; //3 desimaler tillatt som det står på ER

        boolean fornavnOK = kunde.getFornavn().matches(regExNavn);
        boolean etternavnOK = kunde.getEtternavn().matches(regExNavn);
        boolean adrOK = kunde.getAdresse().matches(regExAdresse);
        boolean postNrOK = kunde.getPostnr().matches(regExPostnr);
        boolean tlfOK = kunde.getTelefonnr().matches(regExTlf);
        boolean epostOK = kunde.getEpost().matches(regExEpost);
        boolean volumOK = kunde.getVolum().matches(regExTall);
        boolean vektOK = kunde.getVekt().matches(regExTall);

        if (fornavnOK && etternavnOK && adrOK && postNrOK && tlfOK && epostOK && volumOK && vektOK){
            return true;
        }
        logger.error("Feil i validering");
        return false;
    }


    @PostMapping("/lagreKunde")
    public void lagreKunde (Kunde kunde, HttpServletResponse response) throws IOException {

        //Sjekker at kunde er validert først
        if (!validerKunde(kunde)){
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Feil i validering");
        }
        else {

            String sql = "INSERT INTO Kunde(Fornavn, Etternavn, Adresse, Postnr, Telefonnr, Epost) VALUES (?,?,?,?,?,?);" +
                    "INSERT INTO Pakke(Volum, Vekt) VALUES(?,?); " +
                    "COMMIT;"; //Hvis begge spørringene går så committes begge, hvis ikke, ingen.


            try {
                //Oppdaterer kundeTabellen
                db.update(sql, kunde.getFornavn(), kunde.getEtternavn(), kunde.getAdresse(), kunde.getPostnr(), kunde.getTelefonnr(), kunde.getEpost(), kunde.getVolum(), kunde.getVekt());
            } catch (Exception e) {
                String errorMessage = "Feil i lagring av kunde: ";
                logger.error(errorMessage + e);
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
            }
        }
    }

  /*  @GetMapping("/sjekkPostNr")
    public boolean sjekkPostnr(String postnr){
        String sql  = "SELECT COUNT(*) FROM Poststed WHERE Postnr=?";

            int etPostnr = db.queryForObject(sql, Integer.class, postnr);

            if (etPostnr > 0){
                return true;
            }
        return false;

    }*/

}
