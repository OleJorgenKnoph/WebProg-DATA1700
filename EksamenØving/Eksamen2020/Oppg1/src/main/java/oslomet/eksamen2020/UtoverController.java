package oslomet.eksamen2020;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UtoverController {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Utover.class);

    @PostMapping("/lagreUtover")
    public void lagreUtover (Utover utover, HttpServletResponse response) throws IOException {
        String hashetPassord = krypterPassord(utover.getPassord());

        String sql = "INSERT INTO Utover(fornavn,etternavn,klubb,epost,passord) VALUES (?,?,?,?,?)";

        try{
            db.update(sql, utover.getFornavn(), utover.getEtternavn(), utover.getKlubb(), utover.getEpost(), hashetPassord);
        } catch (Exception e){
            String errorMessage = "Feil i lagring av utøver: ";
            logger.error(errorMessage + e);
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
        }
    }

    public String krypterPassord(String passord){
        return BCrypt.hashpw(passord, BCrypt.gensalt(15));
    }
}
