package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Frete;

import javax.persistence.*;

public class FreteRepository {

    private final EntityManager manager;
    private DAO<Frete> daoFrete;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        daoFrete = new DAO<Frete>(manager);
    }

    public Frete buscaPor(Integer id) {
        return daoFrete.buscaPorId(Frete.class, id);
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoFrete.salvaOuAtualiza(frete);
    }

    public void remove(Frete frete) {
        daoFrete.remove(frete);
    }

}
