package oslomet.oppg2eksamens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrukerController {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(BrukerController.class);

    @GetMapping("/sjekkBruker")
    public boolean sjekkBruker(Bruker innBruker){
        String sql = "SELECT Brukernavn, Passord FROM Bruker WHERE Brukernavn = ? AND Passord = ?";

        try {
            Object[] param = new Object[2];
            param[0] = innBruker.getBrukernavn();
            param[1] = innBruker.getPassord();

            db.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Bruker.class));
            return true;
        }
        catch (Exception e){
            logger.error("Feil i sjekking " + e);
            return false;
        }
    }
}
