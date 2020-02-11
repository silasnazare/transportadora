package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Cliente;

import javax.persistence.*;
import java.util.List;

public class ClienteRepository {

    private final EntityManager manager;
    private DAO<Cliente> daoCliente;

    public ClienteRepository(EntityManager manager) {
        this.manager = manager;
        daoCliente = new DAO<Cliente>(manager);
    }

    public Cliente buscaPor(Integer id) {
        return daoCliente.buscaPorId(Cliente.class, id);
    }

    public List<Cliente> buscaPor(String nome) {
        return this.manager.createQuery("from Cliente " + "where upper(nome) like :nome", Cliente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Cliente salvaOuAtualiza(Cliente cliente) {
        return daoCliente.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        daoCliente.remove(cliente);
    }

}
