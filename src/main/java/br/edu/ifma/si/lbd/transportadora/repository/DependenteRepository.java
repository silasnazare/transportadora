package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Dependente;

import javax.persistence.*;
import java.util.List;

public class DependenteRepository {

    private final EntityManager manager;
    private DAO<Dependente> daoDependente;

    public DependenteRepository(EntityManager manager) {
        this.manager = manager;
        daoDependente = new DAO<Dependente>(manager);
    }

    public Dependente buscaPor(Integer id) {
        return daoDependente.buscaPorId(Dependente.class, id);
    }

    public List<Dependente> buscaPor(String nome) {
        return this.manager.createQuery("from Dependente " + "where upper(nome) like :nome", Dependente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Dependente salvaOuAtualiza(Dependente dependente) {
        return daoDependente.salvaOuAtualiza(dependente);
    }

    public void remove(Dependente dependente) {
        daoDependente.remove(dependente);
    }

}
