package bolaoweb.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name="operador")
public class Operador extends Usuario{
    private static final long serialVersionUID = 1L;
    
    private Boolean boadmin;

    public Boolean isBoadmin() {
        return boadmin;
    }

    public void setBoadmin(Boolean boadmin) {
        this.boadmin = boadmin;
    }
}