
package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.Palpite;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PalpiteDAO {

  private Session session;
  private Transaction trans;
  private List<Palpite> listaPalpite;

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
