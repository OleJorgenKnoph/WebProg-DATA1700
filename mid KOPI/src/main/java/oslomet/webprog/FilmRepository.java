package oslomet.webprog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class FilmRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreKunde(FilmBillett kunde){
        String sql = "INSERT INTO Kunde(film, fornavn, etternavn, tlfnr, epost, antall) VALUES (?,?,?,?,?,?)";

        db.update(sql, kunde.getFilm(), kunde.getFornavn(), kunde.getEtternavn(), kunde.getTlfnr(), kunde.getEpost(), kunde.getAntall());
    }

    public List<FilmBillett> hentKunder (){
        String sql = "SELECT * FROM Kunde"; /*ORDER BY etternavn*/

        List<FilmBillett> alleKunder = db.query(sql, new BeanPropertyRowMapper(FilmBillett.class));

        Collections.sort(alleKunder, new FilmComparator());

        return alleKunder;
    }

    public void slettKunder(){
        String sql = "DELETE FROM Kunde";

        db.update(sql);
    }
}
