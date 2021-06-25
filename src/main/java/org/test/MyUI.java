package org.test;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.test.dao.ClientDao;
import org.test.entity.Client;
import org.test.service.ClientService;
import org.test.views.ClientGrid;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final HorizontalLayout layout = new HorizontalLayout();
        final Panel panel = new Panel("Add Panel");
        final FormLayout formLayout = new FormLayout();
        final ClientGrid grid = new ClientGrid();

        formLayout.addComponent(new TextField("Name"));
        formLayout.addComponent(new TextField("Phone"));
        formLayout.addComponent(new TextField("Email"));
        formLayout.addComponent(new TextField("Address"));
        formLayout.addComponent(new DateField("Date of Birth"));

        panel.setContent(formLayout);
        panel.setWidthUndefined();

        layout.setWidthUndefined();
        layout.setSizeFull();
        layout.addComponents(grid.getGrid(), panel);
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}