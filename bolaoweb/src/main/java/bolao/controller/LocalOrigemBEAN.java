package bolao.controller;

import bolaoweb.model.LocalOrigem;
import bolaoweb.modelDAO.LocalOrigemDAO;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class LocalOrigemBEAN {

  private LocalOrigem origem = new LocalOrigem();
  private LocalOrigemDAO origemDAO = new LocalOrigemDAO();
  private List<LocalOrigem> listaOrigem;
  public String filtro;  

  public LocalOrigemBEAN() {
    setFiltro("");
  }
  
  public String getFiltro(){
    return filtro;
  }
  
  public void setFiltro(String filtro){
    this.filtro = filtro;
  }

  public LocalOrigem getOrigem() {
    return origem;
  }

  public void setOrigem(LocalOrigem origem) {
    this.origem = origem;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.origem);
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
    final LocalOrigemBEAN other = (LocalOrigemBEAN) obj;
    if (!Objects.equals(this.origem, other.origem)) {
      return false;
    }
    return true;
  }

  public String incluirLocalOrigem() {
    origemDAO.incluirLocalOrigem(origem);
    return "consulta_localOrigem";
  }

  public String alterarLocalOrigem() {
    origemDAO.alterarLocalOrigem(origem);
    return "consulta_localOrigem";
  }

  public String excluirLocalOrigem(LocalOrigem l) {
    origemDAO.excluirLocalOrigem(l);
    return "consulta_localOrigem";
  }

  public List listarLocalOrigem() {
    listaOrigem = origemDAO.getList();
    return this.listaOrigem;
  }

  public List buscaLocalOrigem(String filtro) {
    listaOrigem = origemDAO.getLista(filtro);
    return this.listaOrigem;
  }
  public String carregaLocalOrigem(LocalOrigem o) {
    origem = o;
    return "cadastro_localOrigem";
  }

  public String novoLocalOrigem() {
    origem.setId(null);
    origem.setCidade(null);
    origem.setEstado(null);
    origem.setPais(null);
    //origem.setTipo(null);
    return "cadastro_localOrigem";
  }

  public String confirmarLocalOrigem() {
    if (listaOrigem.contains(origem)) {
      return alterarLocalOrigem();
    }
    return incluirLocalOrigem();
  }

}
