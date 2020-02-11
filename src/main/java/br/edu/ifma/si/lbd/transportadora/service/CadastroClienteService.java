package br.edu.ifma.si.lbd.transportadora.service;

import br.edu.ifma.si.lbd.transportadora.connection.EMFactory;
import br.edu.ifma.si.lbd.transportadora.model.Cliente;
import br.edu.ifma.si.lbd.transportadora.repository.ClienteRepository;

import javax.persistence.*;
import java.util.Objects;

public class CadastroClienteService {

    private final ClienteRepository repository;
    private final EntityManager manager;

    public CadastroClienteService( ) {
        this.manager = new EMFactory().getEntityManager();
        this.repository = new ClienteRepository(manager);
    }

    public Cliente salva(Cliente cliente) throws ClienteException {
        try {
            manager.getTransaction().begin();

            Cliente clienteExistente = repository.buscaPor(cliente.getId());

            if (Objects.nonNull(clienteExistente) && !Objects.equals(cliente, clienteExistente)) {
                throw new ClienteException("Já existe um Cliente com o ID informado.");
            }
            Cliente clienteSalvo = repository.salvaOuAtualiza(cliente);

            manager.getTransaction().commit();
            return clienteSalvo;

        } catch	(Exception e) {
            throw new RuntimeException(e );
        }
    }

}
