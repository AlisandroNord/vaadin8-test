package org.test.views;

import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
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
        service.deleteClient(client);
        myUI.refresh();
    }
    private void save(){
        service.updateClient(client);
        myUI.refresh();
    }

    private void add() {
        setClient(new Client());
        service.saveClient(client);
        myUI.refresh();
    }
    private void getClientFromForm(){
        client = new Client(
                name.getValue(),
                phone.getValue(),
                email.getValue(),
                address.getValue(),
                dateOfBirth.getValue());
    }
    public void setClient(Client client){
        this.client = client;
        binder.setBean(client);
    }
}
