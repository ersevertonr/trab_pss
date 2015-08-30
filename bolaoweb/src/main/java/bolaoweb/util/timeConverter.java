package bolaoweb.util;

import bolaoweb.model.Times;
import bolaoweb.modelDAO.TimesDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("bolaoweb.util.timeConverter")
public class timeConverter implements Converter{
    
    private TimesDAO timesDAO = new TimesDAO();
    private List<Times> listaTimes = timesDAO.getList();
    private Times time = new Times();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String nome) {
        for (Times listaTime : listaTimes) {
            if (listaTime.getNome().equals(nome)) {
                return listaTime;
            }
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na conversão.", "Time inexistente na lista");
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        time = (Times) value;
        return time.getNome();
    }
    
}
