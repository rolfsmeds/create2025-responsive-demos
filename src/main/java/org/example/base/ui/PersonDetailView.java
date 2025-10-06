package org.example.base.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.example.domain.Person;
import org.example.domain.PersonRepository;

@Route(value = "mdl/person", layout = MasterDetailView.class)
@ParentLayout(MasterDetailView.class)
public class PersonDetailView extends Section implements RouterLayout, HasUrlParameter<Integer> {

    Person person = null;

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email address");
    private Image profileImage = new Image();
    private Binder<Person> binder = new Binder<>(Person.class);

    public PersonDetailView() {

        this.addClassNames(LumoUtility.Padding.MEDIUM);

        var btnClose = new Button(VaadinIcon.CLOSE.create(), e->close());
        var title = new com.vaadin.flow.component.html.H3("Edit Person");
        var detailHeader = new HorizontalLayout(title, btnClose);
        detailHeader.setFlexGrow(1, title);
        detailHeader.setAlignItems(FlexComponent.Alignment.CENTER);
        add(detailHeader);

        FormLayout form = new FormLayout();
        form.setAutoResponsive(true);
        form.setSizeFull();
        form.setExpandFields(true);
        form.setExpandColumns(true);

        form.add(firstName, lastName, email);

        this.add(form);

        var btnSave = new Button("Save", e->close());
        btnSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnSave.addClassName(LumoUtility.Margin.Top.LARGE);
        this.add(btnSave);

        binder.bindInstanceFields(this);

    }

    private void close() {
        getUI().ifPresent(ui -> ui.navigate(MasterDetailView.class));
    }

    public void setPerson(Person person) {
        binder.setBean(person);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer id) {
        binder.setBean(PersonRepository.getPerson(id));
    }
}
