package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.Partidas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class PartidasDAO {
    private Session sessao;
    private Transaction transacao;
    private List<Partidas> lista;
    private Query query;
    private String tipoFiltro = "", filtro = "";

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
    
    /*public List<Partidas> getLista() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
            
        Criteria criteria = sessao.createCriteria(Partidas.class);
        this.lista = criteria.list();
        sessao.close();
        
        return lista;
    }*/
    
    public List<Partidas> getLista() throws ParseException {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        Criteria criteria = sessao.createCriteria(Partidas.class, "partida");
        
        if (tipoFiltro.equalsIgnoreCase("") || filtro.equalsIgnoreCase("")){
            criteria = sessao.createCriteria(Partidas.class, "partida");
        } else if (tipoFiltro.equalsIgnoreCase("dataPartida")){
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAux = (Date) formater.parse(filtro);
            criteria.add(Restrictions.eq("dataPartida", dataAux));
        } else if (tipoFiltro.equalsIgnoreCase("nomeTimeCasa")){
            criteria.createAlias("partida.timeCasa", "timeCasa");
            criteria.add(Restrictions.like("timeCasa.Nome", filtro+"%"));
        } else if (tipoFiltro.equalsIgnoreCase("nomeTimeVisitante")){
            criteria.createAlias("partida.timeVisitante", "timeVisitante");
            criteria.add(Restrictions.like("timeVisitante.Nome", filtro+"%"));
        }
        criteria.addOrder(Order.asc("dataPartida"));
        this.lista = criteria.list();
        
        sessao.close();
        return lista;
    }
    
    public List<Partidas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();        
        Criteria criteria = sessao.createCriteria(Partidas.class,"partida");
        criteria.add(Restrictions.eqOrIsNull("partida.flag",false));
        this.lista = criteria.list();
        sessao.close();
        return lista;
    }
    
    public void insertPartida(Partidas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();

            Partidas partida = new Partidas();
            partida.setTimeCasa(p.getTimeCasa());
            partida.setTimeVisitante(p.getTimeVisitante());
            partida.setData(p.getData());
            partida.setGolsTimeCasa(p.getGolsTimeCasa());
            partida.setGolsTimeVisitante(p.getGolsTimeVisitante());
            partida.setCampeonato(p.getCampeonato());
            partida.setConfronto();
            sessao.save(partida);
            transacao.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally {
            sessao.close();
        }
    }
    
    public void deletePartida(Partidas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(p);
            transacao.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally {
            sessao.close();
        }
    }
    
    public void updatePartida(Partidas p){
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(p);
            transacao.commit();
        
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally {
            sessao.close();
        }
    }
}
