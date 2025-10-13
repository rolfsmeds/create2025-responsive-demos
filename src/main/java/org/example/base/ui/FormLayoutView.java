package org.example.base.ui;

import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.example.domain.Person;
import org.example.domain.PersonRepository;

import java.util.List;


@Route(value="formlayout")
@PageTitle("Form Layout")
@Menu(order = 2, icon = "vaadin:form", title = "Form Layout")
public class FormLayoutView extends VerticalLayout {

    public FormLayoutView() {
        setSizeFull();

        TextField firstName = new TextField("First name");
        TextField middleName = new TextField("Middle name");
        TextField lastName = new TextField("Last name");
        EmailField email = new EmailField("Email address");
        PasswordField password = new PasswordField("Password");
        PasswordField confirmPassword = new PasswordField("Confirm password");

        FormLayout formLayout = new FormLayout();
        formLayout.setAutoResponsive(true);     // <--
        formLayout.setExpandFields(true);       // <--
        formLayout.setColumnWidth("200px");     // <--
        formLayout.setExpandColumns(true);      // <--

        formLayout.addFormRow(firstName, middleName, lastName); // <--
        formLayout.add(email, 2);
        formLayout.addFormRow(password, confirmPassword);

        add(formLayout);

    }

}