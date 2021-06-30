package org.test.views;

import com.vaadin.ui.Grid;
import org.test.entity.Client;
import org.test.service.ClientService;

public class ClientGrid {
    private final Grid<Client> grid = new Grid<>();
    private final ClientService service = ClientService.getInstance();
    public ClientGrid(){
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
    public void refresh(){
        grid.setItems(service.findAllClients());
    }

}
