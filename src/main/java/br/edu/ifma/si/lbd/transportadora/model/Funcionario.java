package br.edu.ifma.si.lbd.transportadora.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "matricula", nullable = false, unique = true)
    private Integer matricula;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifma.si.lbd.transportadora.model.Funcionario[ id=" + id + " ]";
    }

}
