package bolaoweb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class LocalOrigem implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @Column
  private String Cidade;

  @Column
  private String Estado;

  @Column
  private String Pais;

  //@Column
  //private String Tipo;
  public Long getId() {
    return Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public String getCidade() {
    return Cidade;
  }

  public void setCidade(String Cidade) {
    this.Cidade = Cidade;
  }

  public String getEstado() {
    return Estado;
  }

  public void setEstado(String Estado) {
    this.Estado = Estado;
  }

  public String getPais() {
    return Pais;
  }

  public void setPais(String Pais) {
    this.Pais = Pais;
  }

    //public String getTipo() {
  //    return Tipo;
  //}
  //public void setTipo(String Tipo) {
  //    this.Tipo = Tipo;
  //}
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + Objects.hashCode(this.Id);
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
    final LocalOrigem other = (LocalOrigem) obj;
    if (!Objects.equals(this.Id, other.Id)) {
      return false;
    }
    return true;
  }

}
