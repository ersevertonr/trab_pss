package bolao.controller;

import bolaoweb.model.Campeonato;
import bolaoweb.modelDAO.CampeonatoDAO;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CampeonatoBEAN {

    private Campeonato campeonato = new Campeonato();
    private CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
    private List<Campeonato> listaCampeonato;
    public String filtro;

    public CampeonatoBEAN() {
        setFiltro("");
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.campeonato);
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
        final CampeonatoBEAN other = (CampeonatoBEAN) obj;
        if (!Objects.equals(this.campeonato, other.campeonato)) {
            return false;
        }
        return true;
    }

    public String inserirCampeonato(){
        campeonatoDAO.inserirCampeonato(campeonato);
        return "consulta_campeonato";
    }
    
    public String editarCampeonato(){
        campeonatoDAO.editarCampeonato(campeonato);
        return "consulta_campeonato";
    }
        
    public String excluirCampeonato(Campeonato c){
        campeonatoDAO.excluirCampeonato(c);
        return "consulta_campeonato";
    }

    public List listarCampeonato(){
        listaCampeonato = campeonatoDAO.getLista(filtro);
        return this.listaCampeonato;
    }

    public String carregaCampeonato(Campeonato c){
        campeonato = c;
        return "cadastro_campeonato";
    }
    
    public String novoCampeonato(){
        campeonato.setId(null);
        campeonato.setNome(null);
        campeonato.setEscopo(null);
        campeonato.setDatainicio(null);
        campeonato.setDatafim(null);
        campeonato.setTipoPontos(null);
        campeonato.setTipoMataMata(null);
        campeonato.setObservacao(null);
        return "cadastro_campeonato";
    }

    public String confirmarCampeonato(){
        if (listaCampeonato.contains(campeonato)) {
            return editarCampeonato();
        }
        return inserirCampeonato();
    }
}
