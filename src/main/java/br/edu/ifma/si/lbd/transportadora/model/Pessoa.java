package br.edu.ifma.si.lbd.transportadora.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable, Entidade {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new LinkedHashSet<>();

    @ElementCollection
    @Column(name = "telefone", nullable = false)
    @CollectionTable(name = "telefones", joinColumns = @JoinColumn(name = "cliente_id", nullable = false))
    private Set<String> telefones = new LinkedHashSet<>();

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco endereco) {
        enderecos.add(endereco);
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(String telefone) {
        telefones.add(telefone);
    }

}
