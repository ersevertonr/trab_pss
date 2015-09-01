package bolao.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import bolaoweb.model.Times;
import bolaoweb.modelDAO.TimesDAO;
import java.util.List;
import java.util.Objects;


@ManagedBean
@SessionScoped
public class ControllerTimes implements Serializable {

  private Times equipe = new Times();
  private TimesDAO equipeDAO = new TimesDAO();
  private List<Times> listaEquipe;
  public String filtro;

  public ControllerTimes() {
    setFiltro("");
  }
  
  public void setFiltro(String filtro){
    this.filtro = filtro;
  }
  
  public String getFiltro(){
    return filtro;
  }

  public Times getEquipe() {
    return equipe;
  }

  public void setEquipe(Times equipe) {
    this.equipe = equipe;
  }

  public List listarEquipes() {
    listaEquipe = equipeDAO.getList();
    return listaEquipe;
  }

  public String incluirTime() {
    equipeDAO.incluirTime(equipe);
    equipe.setIdLocalTime(null);
    equipe.setNome(null);
    equipe.setTipo(null);

    return "consulta_time";
  }

  public String alterarTime() {
    equipeDAO.alterarTime(equipe);
    return "consulta_time";
  }

  public String excluirTime(Times t) {
    equipeDAO.excluirTime(t);
    return "consulta_time";
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.equipe);
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
    final ControllerTimes other = (ControllerTimes) obj;
    if (!Objects.equals(this.equipe, other.equipe)) {
      return false;
    }
    return true;
  }

  public String carregaTime(Times t) {
    equipe = t;
    return "cadastro_times";
  }

  public String novoTime() {
    equipe.setId(null);
    equipe.setNome(null);
    equipe.setTipo(null);
    equipe.setIdLocalTime(null);
    return "cadastro_times";
  }

  public String confirmaTime() {
    if (listaEquipe.contains(equipe)) {
      return alterarTime();
    }
    return incluirTime();
  }

}
