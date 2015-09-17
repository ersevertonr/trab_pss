package bolao.controller;


import bolaoweb.model.Apostador;
import bolaoweb.modelDAO.ApostadorDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcelo
 */
@ManagedBean
@SessionScoped
public class GeradorRanking {
    private Apostador apostador = new Apostador();
    private ApostadorDAO apostadorDAO = new ApostadorDAO();
    private List<Apostador> listaApostador;
    public String filtro;
    
    
    
    
}
