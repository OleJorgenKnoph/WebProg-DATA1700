package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class BilRepository {

    @Autowired
    public JdbcTemplate db;

    public List<Bil> hentAlleBiler(){
        String sql = "SELECT * FROM bil";
            List<Bil> alleBiler = db.query(sql, new BeanPropertyRowMapper(Bil.class));
        return alleBiler;
    }

    public void lagreKunde (Motorvogn Motorvogn){
        String sql = "INSERT INTO Kunde (personnr, navn, adresse, kjennetegn, merke, type) VALUES (?,?,?,?,?,?)";
            db.update(sql, Motorvogn.getPersonnr(), Motorvogn.getNavn(),Motorvogn.getAdresse(), Motorvogn.getKjennetegn(), Motorvogn.getMerke(), Motorvogn.getType());
    }

    public List<Motorvogn> hentAlleKunder(){
        String sql = "SELECT * FROM kunde";
            List<Motorvogn> alleKunder = db.query(sql, new BeanPropertyRowMapper(Motorvogn.class));
                    return alleKunder;
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
