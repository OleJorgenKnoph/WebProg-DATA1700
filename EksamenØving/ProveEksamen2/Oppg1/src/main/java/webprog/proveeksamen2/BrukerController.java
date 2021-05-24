package webprog.proveeksamen2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BrukerController {

    @Autowired
    private JdbcTemplate db;

    private final Logger logger = LoggerFactory.getLogger(BrukerController.class);

    @PostMapping("/regBruker")
    public void lagreBruker(Bruker bruker) {
        String regex1 = "[a-zøåA-ZÆØÅ0-9 .\\-]{2,30}";
        String regex2 = "[a-zæøåA-ZÆØÅ0-9]{6,25}";

        boolean OK1 = bruker.getBrukernavn().matches(regex1);
        boolean OK2 = bruker.getPassord().matches(regex2);

        if (OK1 && OK2){
            String sql = "INSERT INTO Bruker (brukernavn, passord) VALUES (?,?)";

            try {
                db.update(sql, bruker.getBrukernavn(), bruker.getPassord());
            }
            catch (Exception e){
                logger.error("Feil på server ved lagring " + e);
            }
        }
    }

    @GetMapping("/hentAlle")
    public List<Bruker> hentAlle()  {
        String sql = "SELECT * FROM Bruker";

        try {
            return db.query(sql, new BeanPropertyRowMapper(Bruker.class));
        }
        catch (Exception e){
            logger.error("Feil ved henting av brukere " + e);
            return null;
        }
    }

}
