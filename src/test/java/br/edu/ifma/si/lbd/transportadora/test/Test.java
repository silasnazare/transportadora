package br.edu.ifma.si.lbd.transportadora.test;

import br.edu.ifma.si.lbd.transportadora.model.*;
import br.edu.ifma.si.lbd.transportadora.model.enums.CategoriaFrete;
import br.edu.ifma.si.lbd.transportadora.model.enums.TipoVeiculo;
import br.edu.ifma.si.lbd.transportadora.service.FreteFiltro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("br.edu.ifma.si.lbd_lab04_jpa_transportadora_jar_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();
        Dependente dependente = new Dependente();
        Cidade cidade1 = new Cidade();
        Cidade cidade2 = new Cidade();
        Endereco endereco = new Endereco();
        Filial filial = new Filial();
        Veiculo veiculo = new Veiculo();
        Distancia distancia = new Distancia();
        Frete frete = new Frete();
        FreteFiltro filtro = new FreteFiltro();
        filtro.setNomeCliente("Silas Nazare Chagas");

        cliente.setNome("Silas Nazare Chagas");

        funcionario.setNome("Silas Nazare Chagas");
        funcionario.setMatricula(1234);

        dependente.setNome("Rita de Cássia");
        dependente.setNascimento(LocalDate.of(1995, 05, 03));
        dependente.setFuncionario(funcionario);

        filial.setNome("São Luís");
        filial.setLogradouro("Av. dos Africanos");
        filial.setNumero(100);
        filial.setBairro("Areinha");
        filial.setCep("65000-000");
        filial.setCidade(cidade1);

        veiculo.setTipo(TipoVeiculo.CAMINHAO);
        veiculo.setPesoMax(BigDecimal.valueOf(10000));
        veiculo.setFilial(filial);

        frete.setValor(BigDecimal.valueOf(1020.35));
        frete.setNotaFiscal(1234);
        frete.setCliente(cliente);
        frete.setVeiculo(veiculo);
        frete.setDistancia(distancia);
        frete.setCategoria(CategoriaFrete.NORMAL);

        cidade1.setNome("São Luís");
        cidade1.setUf("MA");
        cidade2.setNome("Luís Domingues");
        cidade2.setUf("MA");

        endereco.setLogradouro("Av. dos Holandeses");
        endereco.setNumero(13);
        endereco.setBairro("Calhau");
        endereco.setCep("65071-385");
        endereco.setCidade(cidade1);
        endereco.setCliente(cliente);

        distancia.setOrigem(cidade1);
        distancia.setDestino(cidade2);
        distancia.setQuilometro(350);

        manager.persist(cliente);
        manager.persist(funcionario);
        manager.persist(cidade1);
        manager.persist(cidade2);
        manager.persist(endereco);
        manager.persist(dependente);
        manager.persist(distancia);
        manager.persist(filial);
        manager.persist(veiculo);
        manager.persist(frete);

        transaction.commit();

        manager.close();
        factory.close();
    }

}
