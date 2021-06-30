package org.test;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import org.test.entity.Client;
import org.test.views.ClientForm;
import org.test.views.ClientGrid;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    private final ClientGrid grid = new ClientGrid();
    private final ClientForm clientForm = new ClientForm(this);
    private final HorizontalLayout layout = new HorizontalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        layout.setWidthUndefined();
        layout.setSizeFull();
        layout.addComponents(grid.getGrid(), clientForm.getClientForm());
        grid.getGrid().asSingleSelect().addValueChangeListener(e ->{
            if(e.getValue() == null){
                clientForm.setClient(new Client());
            } else {
                clientForm.setClient(e.getValue());
            }
        });
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    public void refresh(){
        grid.refresh();
        clientForm.setClient(null);
    }
}