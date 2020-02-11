package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Veiculo;

import javax.persistence.*;

public class VeiculoRepository {

    private final EntityManager manager;
    private DAO<Veiculo> daoVeiculo;

    public VeiculoRepository(EntityManager manager) {
        this.manager = manager;
        daoVeiculo = new DAO<Veiculo>(manager);
    }

    public Veiculo buscaPor(Integer id) {
        return daoVeiculo.buscaPorId(Veiculo.class, id);
    }

    public Veiculo salvaOuAtualiza(Veiculo veiculo) {
        return daoVeiculo.salvaOuAtualiza(veiculo);
    }

    public void remove(Veiculo veiculo) {
        daoVeiculo.remove(veiculo);
    }

}
