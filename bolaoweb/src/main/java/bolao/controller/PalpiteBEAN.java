package bolao.controller;

import bolaoweb.model.Palpite;
import bolaoweb.modelDAO.PalpiteDAO;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class PalpiteBEAN {

  private Palpite palpite = new Palpite();
  private PalpiteDAO palpiteDAO = new PalpiteDAO();
  private List<Palpite> listaPalpite;
  public String filtro;

  public PalpiteBEAN() {
  }
  
  public void setFiltro(String filtro){
    this.filtro = filtro;
  }
  
  public String getFiltro(){
    return filtro;
  }

  public Palpite getPalpite() {
    return palpite;
  }

  public void setPalpite(Palpite palpite) {
    this.palpite = palpite;
  }

  public List listaPalpite() {
    listaPalpite = palpiteDAO.getLista();
    return listaPalpite;
  }

  public String incluirPalpite() {
    palpiteDAO.incluirPalpite(palpite);
    palpite.setDataCadastro(Calendar.getInstance().getTime());
    palpite.setGolsCasa(null);
    palpite.setGolsVisitante(null);
    palpite.setIdApostador(null);
    palpite.setPartida(null);
    return "consulta_palpite";
  }

  public String alterarPalpite() {
    palpiteDAO.alterarPalpite(palpite);
    return "consulta_palpite";
  }

  public String excluirPalpite(Palpite p) {
    palpiteDAO.excluirPalpite(p);
    return "consulta_palpite";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.palpite);
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
    final PalpiteBEAN other = (PalpiteBEAN) obj;
    if (!Objects.equals(this.palpite, other.palpite)) {
      return false;
    }
    return true;
  }

  public String carregaPalpite(Palpite p) {
    palpite = p;
    return "cadastro_palpite";
  }

  public String novoPalpite() {
    palpite.setId(null);
    palpite.setIdApostador(null);
    palpite.setPartida(null);
    palpite.setGolsCasa(null);
    palpite.setGolsVisitante(null);
    palpite.setDataCadastro(Calendar.getInstance().getTime());
    return "cadastro_palpite";
  }

  public String confirmaPalpite() {
    if (listaPalpite.contains(palpite)) {
      return alterarPalpite();
    }
    return incluirPalpite();
  }

}
