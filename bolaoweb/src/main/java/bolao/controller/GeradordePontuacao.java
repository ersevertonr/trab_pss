/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolao.controller;

import bolaoweb.model.Palpite;
import bolaoweb.model.Partidas;
import bolaoweb.modelDAO.PalpiteDAO;
import bolaoweb.modelDAO.PartidasDAO;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GeradordePontuacao {
    private Partidas partida;
    private Palpite palpite;
    private List <Palpite> listaPalpite;
    private List <Partidas> listaPartida;
    private PalpiteBEAN palpiteBEAN;
    private PartidasBEAN partidaBEAN;
    private String filtro;
    private PartidasDAO partidasDAO;
    private PalpiteDAO palpiteDAO;
    
    public void gerarPontuacao() throws ParseException{
        partidasDAO.setFiltro(filtro);
        partidasDAO.setTipoFiltro("dataPartida");
        listaPartida = partidasDAO.getLista();
        palpiteDAO.setTipoFiltro("partida");
        palpiteDAO.setFiltro(filtro);
        listaPalpite = palpiteDAO.getList();
        
     
        
    }
    
}
