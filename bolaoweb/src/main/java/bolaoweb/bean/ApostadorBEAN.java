package bolaoweb.bean;

import bolaoweb.model.Apostador;
import bolaoweb.modelDAO.ApostadorDAO;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ApostadorBEAN {

    private Apostador apostador = new Apostador();
    private ApostadorDAO apostadorDAO = new ApostadorDAO();
    private List<Apostador> listaApostador;
    public String filtro;

    public ApostadorBEAN() {
        setFiltro("");
    }

    public Apostador getApostador() {
        return apostador;
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.apostador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApostadorBEAN other = (ApostadorBEAN) obj;
        if (!Objects.equals(this.apostador, other.apostador)) {
            return false;
        }
        return true;
    }

   

    public String inserirApostador(){
        apostadorDAO.inserirApostador(apostador);
        return "consulta_apostador";
    }
    
    public String editarApostador(){
        apostadorDAO.editarApostador(apostador);
        return "consulta_apostador";
    }
        
    public String excluirApostador(Apostador c){
        apostadorDAO.excluirApostador(c);
        return "consulta_apostador";
    }

    public List listarApostador(){
        listaApostador = apostadorDAO.getLista(filtro);
        return this.listaApostador;
    }

    public String carregaApostador(Apostador c){
        apostador = c;
        return "cadastro_apostador";
    }
    
    public String novoApostador(){
        apostador.setId(null);
        apostador.setNome(null);
        apostador.setSobrenome(null);        
        apostador.setEmail(null);
        apostador.setSenha(null);
        apostador.setApelido(null);
        apostador.setDatanascimento(null);
        return "cadastro_apostador";
    }

    public String confirmarApostador(){
        if (listaApostador.contains(apostador)) {
            return editarApostador();
        }
        return inserirApostador();
    }
}
