package oslomet.webprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    public JdbcTemplate db;


    private Logger logger = LoggerFactory.getLogger(BilRepository.class);

    public List<Bil> hentAlleBiler(){
        String sql = "SELECT * FROM bil";
        return db.query(sql, new BeanPropertyRowMapper(Bil.class));
    }

    public boolean lagreKunde (Motorvogn Motorvogn){
        String sql = "INSERT INTO kundeÆÆÆ (personnr, navn, adresse, kjennetegn, merke, type) VALUES (?,?,?,?,?,?)";
                    //LAGT INN DENNE^ FEILEN


        //Feilhåndtering
        try {
                 db.update(sql, Motorvogn.getPersonnr(), Motorvogn.getNavn(), Motorvogn.getAdresse(), Motorvogn.getKjennetegn(), Motorvogn.getMerke(), Motorvogn.getType());
                    return true;
        }
                catch (Exception e){
            //Dette kjøres om db.update feiler
                    logger.error("Feil i lagring av kunde: " + e);
                        return false;
                }
            }

    public List<Motorvogn> hentAlleKunder(){
        String sql = "SELECT * FROM kunde";
        return db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
    }

    public void slettAlleKunder(){
        String sql = "DELETE FROM kunde";
            db.update(sql);
    }

    public void slettEnKunde(int id){
        String sql = "DELETE FROM kunde WHERE id=?";
            db.update(sql, id);
    }
}
