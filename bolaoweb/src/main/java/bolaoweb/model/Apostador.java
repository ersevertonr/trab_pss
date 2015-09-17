package bolaoweb.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name="apostador")
public class Apostador extends Usuario{
    private static final long serialVersionUID = 1L;
    
    private String apelido;
    @Temporal(TemporalType.DATE)
    private Date datanascimento;
    @Column
    private int Pontuacao;
    @Column
    private int Posicao;
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getPontuacao() {
        return Pontuacao;
    }

    public void setPontuacao(int Pontuacao) {
        this.Pontuacao = Pontuacao;
    }

    public int getPosicao() {
        return Posicao;
    }

    public void setPosicao(int Posicao) {
        this.Posicao = Posicao;
    }

    
    
}