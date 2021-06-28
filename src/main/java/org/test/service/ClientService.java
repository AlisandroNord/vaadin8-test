package org.test.service;

import org.test.dao.ClientDao;
import org.test.dao.Dao;
import org.test.entity.Client;

import java.util.List;

public class ClientService {
    private Dao<Client, Integer> dao;
    private static ClientService instance;

    public static ClientService getInstance(){
        if (instance == null){
            instance = new ClientService(new ClientDao());
        }
        return instance;
    }
    private ClientService(Dao<Client, Integer> dao){
        this.dao = dao;
    }
    public Client findClient(int id) {
        return dao.findById(id);
    }

    public void saveClient(Client client) {
        dao.save(client);
    }

    public void deleteClient(Client client) {
        dao.delete(client);
    }

    public void updateClient(Client client) {
        dao.update(client);
    }

    public List<Client> findAllClients() {
        return dao.findAll();
    }
}
