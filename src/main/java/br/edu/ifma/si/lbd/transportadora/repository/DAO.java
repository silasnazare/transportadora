package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Entidade;

import javax.persistence.*;
import java.util.Objects;

public class DAO<T extends Entidade> {

    private final EntityManager manager;

    DAO(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> cClass, Integer id) {
        return manager.find(cClass, id);
    }

    T salvaOuAtualiza(T t) {
        if(Objects.isNull(t.getId()) )
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }

}
