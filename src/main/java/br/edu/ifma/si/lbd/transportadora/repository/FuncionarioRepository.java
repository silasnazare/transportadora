package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Funcionario;

import javax.persistence.*;
import java.util.List;

public class FuncionarioRepository {

    private final EntityManager manager;
    private DAO<Funcionario> daoFuncionario;

    public FuncionarioRepository(EntityManager manager) {
        this.manager = manager;
        daoFuncionario = new DAO<Funcionario>(manager);
    }

    public Funcionario buscaPor(Integer id) {
        return daoFuncionario.buscaPorId(Funcionario.class, id);
    }

    public List<Funcionario> buscaPor(String nome) {
        return this.manager.createQuery("from Funcionário " + "where upper(nome) like :nome", Funcionario.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Funcionario salvaOuAtualiza(Funcionario funcionario) {
        return daoFuncionario.salvaOuAtualiza(funcionario);
    }

    public void remove(Funcionario funcionario) {
        daoFuncionario.remove(funcionario);
    }

}
