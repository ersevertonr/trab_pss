
package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.Palpite;
import bolaoweb.model.Partidas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class PalpiteDAO {

  private Session session;
  private Transaction trans;
  private List<Palpite> listaPalpite;
  private String filtro = "";
  
  

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }
    
  public List<Palpite> getList(String filtro) {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(Palpite.class, "palpite");
        criteria.createAlias("palpite.Apostador", "apostador");
        criteria.add(Restrictions.like("apostador.nome", filtro+"%"));
        this.listaPalpite = criteria.list();
        
        session.close();
        return listaPalpite;
    }
  public List<Palpite> getListaPontuacao(int partida) {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();
      Criteria criteria = session.createCriteria(Palpite.class, "palpite");
      criteria.createAlias("palpite.partida", "partida");
      criteria.add(Restrictions.eq("partida.id", partida));
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
