package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Endereco;

import javax.persistence.*;

public class EnderecoRepository {

    private final EntityManager manager;
    private DAO<Endereco> daoEndereco;

    public EnderecoRepository(EntityManager manager) {
        this.manager = manager;
        daoEndereco = new DAO<Endereco>(manager);
    }

    public Endereco buscaPor(Integer id) {
        return daoEndereco.buscaPorId(Endereco.class, id);
    }

    public Endereco salvaOuAtualiza(Endereco endereco) {
        return daoEndereco.salvaOuAtualiza(endereco);
    }

    public void remove(Endereco endereco) {
        daoEndereco.remove(endereco);
    }

}
