package bolaoweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table
public class Palpite implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long Id;

  @Column
  @OneToOne
  private Apostador Apostador;

  @OneToOne
  private Long idPartida;

  @Column
  @Temporal(value = TemporalType.DATE)
  private Date DataCadastro;

  @Column
  private Integer GolsCasa;

  @Column
  private Integer GolsVisitante;
  
  @Column
  private Integer pontuacao;

  public Long getId() {
    return Id;
  }

  public void setId(Long Id) {
    this.Id = Id;
  }

  public Apostador getIdApostador() {
    return Apostador;
  }

  public void setIdApostador(Apostador IdApostador) {
    this.Apostador = IdApostador;
  }

  public Long getPartida() {
    return idPartida;
  }

  public void setPartida(Long IdPartida) {
    this.idPartida = IdPartida;
  }

  public Date getDataCadastro() {
    return DataCadastro;
  }

  public void setDataCadastro(Date DataCadastro) {
    this.DataCadastro = DataCadastro;
  }

  public Integer getGolsCasa() {
    return GolsCasa;
  }

  public void setGolsCasa(Integer GolsCasa) {
    this.GolsCasa = GolsCasa;
  }

  public Integer getGolsVisitante() {
    return GolsVisitante;
  }

  public void setGolsVisitante(Integer GolsVisitante) {
    this.GolsVisitante = GolsVisitante;
  }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 19 * hash + Objects.hashCode(this.Id);
    hash = 19 * hash + Objects.hashCode(this.Apostador);
    hash = 19 * hash + Objects.hashCode(this.idPartida);
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
    final Palpite other = (Palpite) obj;
    if (!Objects.equals(this.Id, other.Id)) {
      return false;
    }
    if (!Objects.equals(this.Apostador, other.Apostador)) {
      return false;
    }
    if (!Objects.equals(this.idPartida, other.idPartida)) {
      return false;
    }
    return true;
  }

}
