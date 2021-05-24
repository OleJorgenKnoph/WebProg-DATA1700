package oslomet.webprog;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BilRepository {


    @Autowired
    public JdbcTemplate db;
    private final Logger logger = LoggerFactory.getLogger(BilRepository.class);

    private String krypterPassord(String passord){
        return BCrypt.hashpw(passord, BCrypt.gensalt());
    }

    private boolean sjekkPassord(String passord, String hashPassord){
        return BCrypt.checkpw(passord, hashPassord);
    }

    public List<Bil> hentAlleBiler(){
        String sql = "SELECT * FROM AlleBiler";

        try {
             List<Bil> alleBiler = db.query(sql, new BeanPropertyRowMapper(Bil.class));
                return alleBiler;
        } catch (Exception e){
            logger.error("Feil i hentAlleBiler: " + e);
            return null;
        }
    }

    public boolean lagreKunde(Kunde kunde){
        String sql = "INSERT INTO AlleKunder(persNr, navn, adr, regNr, merke, type, passord) VALUES (?,?,?,?,?,?,?)";
        String hash = krypterPassord(kunde.getPassord());

        try {
            db.update(sql, kunde.getPersNr(), kunde.getNavn(), kunde.getAdr(), kunde.getRegNr(), kunde.getMerke(), kunde.getType(), hash);
                return true;
        } catch (Exception e){
                logger.error("Feil i lagring av kunde: " + e);
                return false;
            }
        }

    public List<Kunde> hentAlleKunder(){
        String sql = "SELECT * FROM AlleKunder";

        try {

            List<Kunde> alleKunder = db.query(sql, new BeanPropertyRowMapper(Kunde.class));
            return alleKunder;
        } catch (Exception e){
            logger.error("Feil i hentAlleKunder: " + e);
            return null;
        }

    }

    public Kunde hentEnKunde(int id) {
        Object[] param = new Object[1];
        param[0] = id;
        String sql = "SELECT * FROM AlleKunder WHERE id=?";

        try {

            Kunde enKunde = db.queryForObject(sql, param, BeanPropertyRowMapper.newInstance(Kunde.class));
            return enKunde;
        }
        catch (Exception e){
            logger.error("Feil i hentEnKunde: " + e);
            return null;
        }
        }

    public boolean slettEnKunde(int id) {
        String sql = "DELETE FROM AlleKunder WHERE id=?";

        try {

            db.update(sql, id);
            return true;
        } catch (Exception e){
            logger.error("Feil i sletting av en kunde");
            return false;
        }
        }

    public boolean slettAlle(){
        String sql = "DELETE FROM AlleKunder";

        try {
            db.update(sql);
            return true;
        } catch (Exception e){
            logger.error("Feil i slettAlle:" + e);
            return false;
            }
        }

    public boolean oppdaterKunde(Kunde kunde){
        String sql = "UPDATE AlleKunder SET persNr=?, navn=?, adr=?, regNr=?, merke=?, type=? WHERE persNr=?";

        try {

            db.update(sql, kunde.getPersNr(), kunde.getNavn(), kunde.getAdr(), kunde.getRegNr(), kunde.getMerke(), kunde.getType(), kunde.getPersNr());
        return true;
        } catch (Exception e){
            logger.error("Feil i oppdaterKunde: " + e);
            return false;
        }

        }

        public boolean sjekkNavnOgPassord(Kunde kunde) {
            String sql = "SELECT * FROM AlleKunder WHERE navn = ?";

            try {
                Kunde dbKunde = db.queryForObject(sql, BeanPropertyRowMapper.newInstance(Kunde.class), kunde.getNavn());
                assert dbKunde != null; //Throws exception if dbKunde is null

                return sjekkPassord(kunde.getPassord(), dbKunde.getPassord());
            } catch (Exception e){
                logger.error("Feil i sjekkNavnOgPassord: " + e);
                return false;
            }
        }

}
