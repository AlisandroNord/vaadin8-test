package org.test.views;

import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import org.test.dao.ClientDao;
import org.test.entity.Client;
import org.test.service.ClientService;

import java.util.Set;

public class ClientGrid {
    private final Grid<Client> grid = new Grid<>();
    private final ClientService service = new ClientService(new ClientDao());
    public ClientGrid(){
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addSelectionListener(event -> {
            Set<Client> selected = event.getAllSelectedItems();
            Notification.show(selected.size() + "items selected");
        });
        grid.setItems(service.findAllClients());
        grid.addColumn(Client::getName).setCaption("Name");
        grid.addColumn(Client::getPhone).setCaption("Phone");
        grid.addColumn(Client::getEmail).setCaption("Email");
        grid.addColumn(Client::getAddress).setCaption("Address");
        grid.addColumn(Client::getDateOfBirth).setCaption("DateOfBirth");
        grid.setSizeFull();
    }
    public Grid<Client> getGrid(){
        return grid;
    }

}
