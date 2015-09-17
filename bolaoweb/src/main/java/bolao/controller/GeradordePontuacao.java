
package bolao.controller;

import bolaoweb.model.Apostador;
import bolaoweb.model.Palpite;
import bolaoweb.model.Partidas;
import bolaoweb.modelDAO.ApostadorDAO;
import bolaoweb.modelDAO.PalpiteDAO;
import bolaoweb.modelDAO.PartidasDAO;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class GeradordePontuacao {
  private Apostador apostador = new Apostador();
  private ApostadorDAO apostadorDAO = new ApostadorDAO();
  private Partidas partida = new Partidas();
  private Palpite palpite = new Palpite();
  private List <Palpite> listaPalpite;
  private List <Partidas> listaPartida;
  private PalpiteBEAN palpiteBEAN = new PalpiteBEAN();
  private PartidasBEAN partidaBEAN = new PartidasBEAN();
  private PalpiteDAO palpiteDAO = new PalpiteDAO();
  private PartidasDAO partidaDAO = new PartidasDAO();
  private int aux;
    
    public String gerarPontuacao(Partidas filtro) {
    int auxiliar = filtro.getId();
    listaPalpite = palpiteDAO.getListaPontuacao(auxiliar);
    while( aux < listaPalpite.size()){
    palpite = listaPalpite.get(aux);
        if((palpite.getGolsCasa() == filtro.getGolsTimeCasa()) && (palpite.getGolsVisitante() == filtro.getGolsTimeVisitante())){
            apostador = palpite.getApostador();
            apostador.pontua();
            apostadorDAO.editarApostador(apostador);
        }    
    aux++;
    filtro.setFlag(true);
    partidaDAO.updatePartida(filtro);
        
    }  
     GeradorRanking rank = new GeradorRanking();
     rank.gerarRanking();
     return  "consulta_pontuacao";  
    }
   
}
