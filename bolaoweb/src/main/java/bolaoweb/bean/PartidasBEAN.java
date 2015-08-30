package bolaoweb.bean;

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
        
        //validações
        /*if(partidas.getData()==null){
            return "Data inválida";
        } else if (partidas.getData().compareTo(new Date(System.currentTimeMillis()))>0){// se for maior que zero é no futuro, portanto, não pode ter placar
            if(partidas.getGolsTimeCasa()>0 || partidas.getGolsTimeVisitante()>0){
                return "Partida ainda não realizada não pode possuir placar atribuído.";
            } 
        } else if (partidas.getData().compareTo(new Date(System.currentTimeMillis()))<0){ // se for menor que zero é no passado, portanto, placar é obrigatorio
            if(partidas.getGolsTimeCasa()==0 && partidas.getGolsTimeVisitante()==0){
                return "Placar é obrigatório para partidas já realizadas";
            }
        }
        if(partidas.getTimeCasa().getId()==null){
            return "Time da casa informado não existe";
        }
        if(partidas.getTimeVisitante().getId()==null){
            return "Time visitante informado não existe";
        }
        if(partidas.getGolsTimeCasa()<0 || partidas.getGolsTimeVisitante()<0){
            return "Placar não pode conter valores negativos";
        }*/
        
        
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
        /*this.partidas.setData(null);
        this.partidas.setGolsTimeCasa(0);
        this.partidas.setGolsTimeVisitante(0);
        this.partidas.setTimeCasa(null);
        this.partidas.setTimeVisitante(null);*/
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
