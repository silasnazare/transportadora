package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Filial;

import javax.persistence.*;
import java.util.List;

public class FilialRepository {

    private final EntityManager manager;
    private DAO<Filial> daoFilial;

    public FilialRepository(EntityManager manager) {
        this.manager = manager;
        daoFilial = new DAO<Filial>(manager);
    }

    public Filial buscaPor(Integer id) {
        return daoFilial.buscaPorId(Filial.class, id);
    }

    public List<Filial> buscaPor(String nome) {
        return this.manager.createQuery("from Filial " + "where upper(nome) like :nome", Filial.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Filial salvaOuAtualiza(Filial filial) {
        return daoFilial.salvaOuAtualiza(filial);
    }

    public void remove(Filial filial) {
        daoFilial.remove(filial);
    }

}
