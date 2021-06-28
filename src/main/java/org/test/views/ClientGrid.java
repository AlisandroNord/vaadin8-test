package org.test.views;

import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import org.test.entity.Client;
import org.test.service.ClientService;

import java.util.Set;

public class ClientGrid {
    private static ClientGrid instance;
    private final Grid<Client> grid = new Grid<>();
    private final ClientService service = ClientService.getInstance();
    private ClientGrid(){
        grid.addSelectionListener(event -> {
            Set<Client> selected = event.getAllSelectedItems();
            Notification.show(selected.size() + "items selected");
        });
        grid.setColumns();
        grid.addColumn(Client::getName).setCaption("Name");
        grid.addColumn(Client::getPhone).setCaption("Phone");
        grid.addColumn(Client::getEmail).setCaption("Email");
        grid.addColumn(Client::getAddress).setCaption("Address");
        grid.addColumn(Client::getDateOfBirth).setCaption("DateOfBirth");
        grid.setSizeFull();
        refresh();
    }
    public Grid<Client> getGrid(){
        return grid;
    }
    public void addClient(Client client){
        service.saveClient(client);
        grid.getDataProvider().refreshAll();
    }
    public static ClientGrid getInstance(){
        if(instance == null){
            instance = new ClientGrid();
        }
        return instance;
    }
    public void refresh(){
        grid.setItems(service.findAllClients());
    }

}
