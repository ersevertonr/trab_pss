package bolaoweb.modelDAO;

import bolaoweb.hibernate.HibernateUtil;
import bolaoweb.model.Campeonato;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class CampeonatoDAO {

    private Session session;
    private Transaction trans;
    private List<Campeonato> listaCampeonato;
    
    public List<Campeonato> getList() {
    session = HibernateUtil.getSessionFactory().openSession();
    Criteria criteria = session.createCriteria(Campeonato.class);
    this.listaCampeonato = criteria.list();

    return this.listaCampeonato;
  }
    
    public List<Campeonato> getLista( String filtro ){
        session = HibernateUtil.getSessionFactory().openSession();

        Criteria crit = session.createCriteria(Campeonato.class);

        Criterion filtroNome = Restrictions.like("nome",filtro+"%");

        crit.add(filtroNome);

        this.listaCampeonato = crit.list();
        return listaCampeonato;
    }
    
    public void inserirCampeonato( Campeonato campeonato ){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            session.save(campeonato);
            trans.commit();
        } catch ( Exception e ){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void editarCampeonato( Campeonato campeonato ){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            session.update(campeonato);
            trans.commit();
        } catch( Exception e ){
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    public void excluirCampeonato( Campeonato campeonato ){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();

            session.delete(campeonato);
            trans.commit();
        } catch( Exception e ){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
