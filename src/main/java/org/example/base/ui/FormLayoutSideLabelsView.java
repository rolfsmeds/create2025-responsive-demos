package org.example.base.ui;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="formlayout-sidelabels")
@PageTitle("Form w/ Side Labels")
@Menu(order = 3, icon = "vaadin:clipboard-check", title = "Form w/ Side Labels")
public class FormLayoutSideLabelsView extends VerticalLayout {

    public FormLayoutSideLabelsView() {
        setSizeFull();

        TextField firstName = new TextField();
        TextField middleName = new TextField();
        TextField lastName = new TextField();
        EmailField email = new EmailField();
        PasswordField password = new PasswordField();
        PasswordField confirmPassword = new PasswordField();

        FormLayout formLayout = new FormLayout();
        formLayout.setAutoResponsive(true);
        formLayout.setExpandFields(true);
        formLayout.setLabelsAside(true);

        formLayout.addFormItem(firstName, "First name");
        formLayout.addFormItem(middleName, "Middle name");
        formLayout.addFormItem(lastName, "Last name");

        formLayout.addFormItem(email, "Email address");

        formLayout.addFormItem(password, "Password");
        formLayout.addFormItem(confirmPassword, "Confirm password");

        add(formLayout);

    }

}