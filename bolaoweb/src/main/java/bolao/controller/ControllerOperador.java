package bolao.controller;

import bolaoweb.model.Operador;
import bolaoweb.modelDAO.OperadorDAO;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ControllerOperador {

    private Operador operador = new Operador();
    private OperadorDAO operadorDAO = new OperadorDAO();
    private List<Operador> listaOperador;
    public String filtro;

    public ControllerOperador() {
        setFiltro("");
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
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
        hash = 97 * hash + Objects.hashCode(this.operador);
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
        final ControllerOperador other = (ControllerOperador) obj;
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        return true;
    }

    public String inserirOperador(){
        operador.setBoadmin(true);
        operadorDAO.inserirOperador(operador);
        return "consulta_operador";
    }
    
    public String editarOperador(){
        operadorDAO.editarOperador(operador);
        return "consulta_operador";
    }
        
    public String excluirOperador(Operador c){
        operadorDAO.excluirOperador(c);
        return "consulta_operador";
    }

    public List listarOperador(){
        listaOperador = operadorDAO.getLista(filtro);
        return this.listaOperador;
    }

    public String carregaOperador(Operador c){
        operador = c;
        return "cadastro_operador";
    }
    
    public String novoOperador(){
        operador.setId(null);
        operador.setNome(null);
        operador.setSobrenome(null);
        operador.setEmail(null);
        operador.setSenha(null);
        operador.setBoadmin(null);
        return "cadastro_operador";
    }

    public String confirmarOperador(){
        if (listaOperador.contains(operador)) {
            return editarOperador();
        }
        return inserirOperador();
    }
}
