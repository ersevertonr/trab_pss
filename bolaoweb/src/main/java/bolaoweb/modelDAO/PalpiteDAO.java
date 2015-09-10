
package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.Palpite;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class PalpiteDAO {

  private Session session;
  private Transaction trans;
  private List<Palpite> listaPalpite;
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
    
  public List<Palpite> getList() throws ParseException {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Palpite.class, "palpite");
        
        if (tipoFiltro.equalsIgnoreCase("") || filtro.equalsIgnoreCase("")){
            criteria = session.createCriteria(Palpite.class, "palpite");
        } else if (tipoFiltro.equalsIgnoreCase("dataCadastro")){
            SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
            Date dataAux = (Date) formater.parse(filtro);
            criteria.add(Restrictions.eq("dataCadastro", dataAux));
        } else if (tipoFiltro.equalsIgnoreCase("apostador")){
            criteria.createAlias("palpite.Apostador", "apostador");
            criteria.add(Restrictions.like("palpite.Apostador.nome", filtro+"%"));
        } 
        criteria.addOrder(Order.asc("dataPartida"));
        this.listaPalpite = criteria.list();
        
        session.close();
        return listaPalpite;
    }
  public List<Palpite> getLista() {
    session = HibernateUtil.getSessionFactory().openSession();

    Criteria criteria = session.createCriteria(Palpite.class);
    this.listaPalpite = criteria.list();

    return this.listaPalpite;
  }

  public void incluirPalpite(Palpite equipe) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.save(equipe);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }

  public void alterarPalpite(Palpite equipe) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.merge(equipe);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }

  public void excluirPalpite(Palpite equipe) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.delete(equipe);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }

}
