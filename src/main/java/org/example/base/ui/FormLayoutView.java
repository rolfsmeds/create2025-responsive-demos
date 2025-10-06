package org.example.base.ui;

import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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
@Menu(order = 1, icon = "vaadin:clipboard-check", title = "Form Layout")
public class FormLayoutView extends VerticalLayout {

    public FormLayoutView() {
        setSizeFull();

    }

}