
package bolaoweb.util;

import bolaoweb.model.LocalOrigem;
import bolaoweb.modelDAO.LocalOrigemDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("bolaoweb.util.localOrigemConverter")
public class localOrigemConverter implements Converter{
    private LocalOrigem localorigem = new LocalOrigem();
    private LocalOrigemDAO localorigemDAO = new LocalOrigemDAO();
    private List<LocalOrigem> listalocal = localorigemDAO.getList();
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String nome) {
        for (LocalOrigem listaLocal : listalocal) {
            if (listaLocal.getCidade().equals(nome)) {
                return listaLocal;
            }
        }
       
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        localorigem = (LocalOrigem) value;
        return localorigem.getCidade();
    }
    
    
    
    
}
