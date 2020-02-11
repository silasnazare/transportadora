package br.edu.ifma.si.lbd.transportadora.repository;

import br.edu.ifma.si.lbd.transportadora.model.Cidade;
import br.edu.ifma.si.lbd.transportadora.model.Cliente;
import br.edu.ifma.si.lbd.transportadora.model.Frete;
import br.edu.ifma.si.lbd.transportadora.service.FreteFiltro;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public List<Frete> filtrar(FreteFiltro filtro) {

        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Frete> cq = cb.createQuery(Frete.class);

        Root<Frete> frete = cq.from(Frete.class);

        Predicate[] restricoes = this.criaRestricoes(filtro, cb, frete);

        cq.select(frete).where(restricoes).orderBy(cb.asc(frete.<Integer>get("id")));

        return manager.createQuery(cq).getResultList();
    }

    private Predicate[] criaRestricoes(FreteFiltro filtro, CriteriaBuilder cb, Root<Frete> frete) {

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getMaiorValor() != null) {
            predicates.add(cb.ge(frete.<BigDecimal>get("valor"), filtro.getMaiorValor()));
        }
        if (filtro.getMenorValor() != null) {
            predicates.add(cb.le(frete.<BigDecimal>get("valor"), filtro.getMenorValor()));
        }
        if (filtro.getCidadeOrigem() != null) {
            Join<Frete, Cidade> cidadeOrigem = frete.join("cidadeOrigem");
            predicates.add(cb.equal(cidadeOrigem.<String>get("nome"), filtro.getCidadeOrigem()));
        }
        if (filtro.getCidadeDestino() != null) {
            Join<Frete,Cidade> cidadeDestino = frete.join("cidadeDestino");
            predicates.add(cb.equal(cidadeDestino.<String>get("nome"), filtro.getCidadeDestino()));
        }
        if (filtro.getNomeCliente() != null && filtro.getNomeCliente().trim() != "") {
            Join<Frete, Cliente> cliente = frete.join("cliente");
            predicates.add(cb.like(cliente.<String>get("nome"), "%" + filtro.getNomeCliente() + "%"));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

}
