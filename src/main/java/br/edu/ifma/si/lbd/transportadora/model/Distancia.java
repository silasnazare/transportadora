package br.edu.ifma.si.lbd.transportadora.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "distancia")
public class Distancia implements Serializable, Entidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "origem", nullable = false)
    private Cidade origem;

    @ManyToOne
    @JoinColumn(name = "destino", nullable = false)
    private Cidade destino;

    @Column(name = "quilometro", nullable = false)
    private Integer quilometro;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public Integer getQuilometro() {
        return quilometro;
    }

    public void setQuilometro(Integer quilometro) {
        this.quilometro = quilometro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distancia)) {
            return false;
        }
        Distancia other = (Distancia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifma.si.lbd.transportadora.model.Distancia[ id=" + id + " ]";
    }

}
