package domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="quarto")
public class Quarto {

    @Id

    private Integer id;

    @NotNull
    @NotEmpty
    @Size(max = 4, message = "numero não pode ter mais de 4 caracteres")
    private String numero;
    private float valor;
    private String tipo;
    private boolean reservado;
    private  boolean limpo;

    public Quarto(Integer id, String numero, float valor, String tipo, boolean reservado, boolean limpo){
        this.id = id;
        this.limpo = limpo;
        this.numero = numero;
        this.valor = valor;
        this.tipo = tipo;
        this.reservado = reservado;
        this.limpo  = limpo;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }
}
