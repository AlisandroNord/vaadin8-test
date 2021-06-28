package org.test.views;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import org.test.MyUI;
import org.test.entity.Client;
import org.test.service.ClientService;

public class ClientForm {
    private ClientService service = ClientService.getInstance();
    private MyUI myUI;
    private Client client;

    private FormLayout formLayout = new FormLayout();
    private TextField name = new TextField("Name");
    private TextField phone = new TextField("Phone");
    private TextField email = new TextField("Email");
    private TextField address = new TextField("Address");
    private DateField dateOfBirth = new DateField("Date of Birth");

    private Button addButton = new Button("Add");
    private Button savButton = new Button("Save");
    private Button delButton = new Button("Delete");

    private Binder<Client> binder = new Binder<>(Client.class);

    public ClientForm(MyUI myUI){

        this.myUI = myUI;
        formLayout.addComponents(name, phone, email, address, dateOfBirth, addButton, savButton, delButton);
        formLayout.setWidthUndefined();
        binder.bindInstanceFields(this);
        addButton.addClickListener(e -> {
            add();
                });
        savButton.addClickListener(e ->{
           save();
        });
        delButton.addClickListener(e ->{
            delete();
        });
    }
    public FormLayout getClientForm(){
        return this.formLayout;
    }
    private void delete() {
        if(client != null) {
            service.deleteClient(client);
            myUI.refresh();
            Notification.show("Client deleted");
        } else {
            Notification.show("Client is null");
        }
    }
    private void save(){
        if(client != null) {
            service.updateClient(client);
            myUI.refresh();
        } else {
            Notification.show("Client is null");
        }
    }

    private void add() {
        service.saveClient(client);
        myUI.refresh();
    }

    public void setClient(Client client){
        this.client = client;
        binder.setBean(client);
    }
}
