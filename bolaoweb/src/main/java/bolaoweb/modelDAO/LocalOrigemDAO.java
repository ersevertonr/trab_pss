package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.LocalOrigem;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


public class LocalOrigemDAO {

  private Session session;
  private Transaction trans;
  private List<LocalOrigem> listaLocalOrigem;

  public List<LocalOrigem> getList() {
    session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(LocalOrigem.class);
    this.listaLocalOrigem = criteria.list();

    return this.listaLocalOrigem;
  }

  public List<LocalOrigem> getLista( String filtro ){
        session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(LocalOrigem.class);

        Criterion filtroNome = Restrictions.like("Id",filtro+"%");

        crit.add(filtroNome);

        this.listaLocalOrigem = crit.list();
        return listaLocalOrigem;
    }
  public void incluirLocalOrigem(LocalOrigem origem) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.save(origem);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }

  public void alterarLocalOrigem(LocalOrigem origem) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.merge(origem);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }

  public void excluirLocalOrigem(LocalOrigem origem) {
    try {
      session = HibernateUtil.getSessionFactory().openSession();
      trans = session.beginTransaction();

      session.delete(origem);
      trans.commit();
      session.close();

    } catch (HibernateException ex) {
      ex.printStackTrace();
    }
  }
  
}
