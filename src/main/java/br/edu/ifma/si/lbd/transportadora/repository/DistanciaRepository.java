package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Distancia;

import javax.persistence.*;

public class DistanciaRepository {

    private final EntityManager manager;
    private DAO<Distancia> daoDistancia;

    public DistanciaRepository(EntityManager manager) {
        this.manager = manager;
        daoDistancia = new DAO<Distancia>(manager);
    }

    public Distancia buscaPor(Integer id) {
        return daoDistancia.buscaPorId(Distancia.class, id);
    }

    public Distancia salvaOuAtualiza(Distancia distancia) {
        return daoDistancia.salvaOuAtualiza(distancia);
    }

    public void remove(Distancia distancia) {
        daoDistancia.remove(distancia);
    }

}
