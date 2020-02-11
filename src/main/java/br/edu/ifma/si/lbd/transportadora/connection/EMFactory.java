package br.edu.ifma.si.lbd.transportadora.connection;

import javax.persistence.*;

public class EMFactory {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("transportadora");


    public EntityManager getEntityManager() {
        return factory.createEntityManager();

    }

    public void close() {
        factory.close();
    }

}
