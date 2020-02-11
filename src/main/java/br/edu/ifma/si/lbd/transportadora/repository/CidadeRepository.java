package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Cidade;

import javax.persistence.*;
import java.util.List;

public class CidadeRepository {

    private final EntityManager manager;
    private DAO<Cidade> daoCidade;

    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
        daoCidade = new DAO<Cidade>(manager);
    }

    public Cidade buscaPor(Integer id) {
        return daoCidade.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> buscaPor(String nome) {
        return this.manager.createQuery("from Cidade " + "where upper(nome) like :nome", Cidade.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Cidade salvaOuAtualiza(Cidade cidade) {
        return daoCidade.salvaOuAtualiza(cidade);
    }

    public void remove(Cidade cidade) {
        daoCidade.remove(cidade);
    }

}
