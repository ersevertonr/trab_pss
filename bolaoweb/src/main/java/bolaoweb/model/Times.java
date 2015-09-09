package bolaoweb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Times implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @OneToOne
  private LocalOrigem IdLocalTime;

  @Column
  private String Tipo;

  @Column
  private String Nome;

  public Long getId() {
    return Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public LocalOrigem getIdLocalTime() {
    return IdLocalTime;
  }

  public void setIdLocalTime(LocalOrigem IdLocalTime) {
    this.IdLocalTime = IdLocalTime;
  }

  public String getTipo() {
    return Tipo;
  }

  public void setTipo(String Tipo) {
    this.Tipo = Tipo;
  }

  public String getNome() {
    return Nome;
  }

  public void setNome(String Nome) {
    this.Nome = Nome;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 17 * hash + Objects.hashCode(this.Id);
    hash = 17 * hash + Objects.hashCode(this.IdLocalTime);
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
    final Times other = (Times) obj;
    if (!Objects.equals(this.Id, other.Id)) {
      return false;
    }
    if (!Objects.equals(this.IdLocalTime, other.IdLocalTime)) {
      return false;
    }
    return true;
  }

}
