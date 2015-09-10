
package bolaoweb.util;

import bolaoweb.model.Campeonato;
import bolaoweb.modelDAO.CampeonatoDAO;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("bolaoweb.util.campeonatoConverter")
public class campeonatoConverter implements Converter{
    
    private CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
    private List<Campeonato> listaCampeonato = campeonatoDAO.getList();
    private Campeonato campeonato = new Campeonato();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String nome) {
        for (Iterator<Campeonato> it = listaCampeonato.iterator(); it.hasNext();) {
            Campeonato listaCampeonato = it.next();
            if (listaCampeonato.getNome().equals(nome)) {
                return listaCampeonato;
            }
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na conversão.", "Campeonato inexistente na lista");
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        campeonato = (Campeonato) value;
        return campeonato.getNome();
    }
    
}
