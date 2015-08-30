package bolaoweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="partidas")
public class Partidas implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Times timeCasa;
    @OneToOne
    private Times timeVisitante;
    @Temporal(TemporalType.DATE)
    private Date dataPartida;
    private int golsTimeCasa;
    private int golsTimeVisitante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Times getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(Times timeCasa) {
        this.timeCasa = timeCasa;
    }

    public Times getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Times timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public Date getData() {
        return dataPartida;
    }

    public void setData(Date data) {
        this.dataPartida = data;
    }

    public int getGolsTimeCasa() {
        return golsTimeCasa;
    }

    public void setGolsTimeCasa(int golsTimeCasa) {
        this.golsTimeCasa = golsTimeCasa;
    }

    public int getGolsTimeVisitante() {
        return golsTimeVisitante;
    }

    public void setGolsTimeVisitante(int golsTimeVisitante) {
        this.golsTimeVisitante = golsTimeVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partidas other = (Partidas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
