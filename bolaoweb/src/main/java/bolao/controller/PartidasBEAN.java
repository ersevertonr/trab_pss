package bolao.controller;

import bolaoweb.model.Partidas;
import bolaoweb.modelDAO.PartidasDAO;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class PartidasBEAN {
    
    private Partidas partidas = new Partidas();
    private PartidasDAO partidasDAO = new PartidasDAO();
    private List<Partidas> listaPartidas;
    private boolean flagEditar = false;
    private String filtro, tipoFiltro;

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public PartidasBEAN() {
    }
    public List <Partidas> consultaPartidasPontuacao() throws ParseException{
    listaPartidas = partidasDAO.getList();
        return this.listaPartidas;
    
    }
    public List<Partidas> consultarPartidas() throws ParseException{
        listaPartidas = partidasDAO.getLista();
        return this.listaPartidas;
    }
    
    public String filtrarPartidas() throws ParseException{
        partidasDAO.setFiltro(filtro);
        partidasDAO.setTipoFiltro(tipoFiltro);
        listaPartidas = partidasDAO.getLista();
        return "consulta_partida";
    }
    
    public String salvarPartida(){
        if(flagEditar){
            partidasDAO.updatePartida(partidas);
            flagEditar = false;
        } else {
            partidasDAO.insertPartida(partidas);
        }
        novaPartida();
        return "consulta_partida";
    }
    
    public String deletePartida(Partidas partida){
        this.partidas = partida;
        partidasDAO.deletePartida(partidas);
        novaPartida();
        return "consulta_partida";
    }
    
    public String carregarPartida(Partidas partida){
        this.partidas = partida;
        flagEditar = true;
        return "cadastro_partida";
    }
        
    public String novaPartida(){
        this.partidas = new Partidas();
        return "cadastro_partida";
    }

    public Partidas getPartidas() {
        return partidas;
    }

    public void setPartidas(Partidas partidas) {
        this.partidas = partidas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.partidas);
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
        final PartidasBEAN other = (PartidasBEAN) obj;
        if (!Objects.equals(this.partidas, other.partidas)) {
            return false;
        }
        return true;
    }
    
    
}
