package org.example.base.ui;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.avatar.AvatarVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.example.domain.Person;
import org.example.domain.PersonRepository;

import java.util.List;



@Route(value="mdl", layout=MainLayout.class)
@PageTitle("Master Detail View")
@Menu(order = 1, icon = "vaadin:clipboard-check", title = "Master Detail View")
@ParentLayout(MainLayout.class)
public class MasterDetailView extends MasterDetailLayout {

    private Registration listener;

    Grid<Person> grid;
    Grid.Column<Person> smallScreenColumn;
    List<Person> persons = PersonRepository.getPersons();

    public MasterDetailView() {
        setSizeFull();

        grid = new Grid<>(Person.class, false);
        grid.addComponentColumn(this::createAvatar).setFlexGrow(0).setHeader("Avatar");
        grid.addColumn(Person::getFirstName).setHeader("First Name");
        grid.addColumn(Person::getLastName).setHeader("Last Name");
        grid.addColumn(Person::getEmail).setHeader("Email").setFlexGrow(3);
        grid.setItems(persons);
        grid.setSizeFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        this.setMaster(grid);
        this.setMasterMinSize("400px");
        this.setDetailSize("400px");
        this.setContainment(Containment.VIEWPORT);

        grid.addSelectionListener(e -> {
            Person selectedPerson = e.getFirstSelectedItem().orElse(null);
            if (selectedPerson != null) {
                getUI().ifPresent(ui -> ui.navigate(PersonDetailView.class, selectedPerson.getId()));
            } else {
                getUI().ifPresent(ui -> ui.navigate(MasterDetailView.class));
            }
        });

/*
        smallScreenColumn = grid.addComponentColumn(person -> {
           Avatar avatar = createAvatar(person);
           avatar.addThemeVariants(AvatarVariant.LUMO_XLARGE);
           Span name = new Span(getFullName(person));
           name.addClassName("name");
           Span email = new Span(person.getEmail());
           email.addClassName("email");
           Div layout = new Div(avatar, name, email);
           layout.addClassName("user-details");
           return layout;
        });
*/

    }

    private Avatar createAvatar(Person person) {
        return new Avatar(person.getFirstName()+" "+getFullName(person));
    }

    private String getFullName(Person person) {
        return person.getFirstName()+" "+person.getLastName();
    }

/*
    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        // Add browser window listener to observe width change
        Page page = attachEvent.getUI().getPage();
        listener = page.addBrowserWindowResizeListener(event -> {
            adjustGridColumns(event.getWidth());
        });
        // Adjust Grid according to initial width of the screen
        page.retrieveExtendedClientDetails(receiver -> {
            int browserWidth = receiver.getBodyClientWidth();
            adjustGridColumns(browserWidth);
        });
    }
*/

    private void adjustGridColumns(int width) {
        boolean isSmallScreen = width < 800;

        grid.getColumns().forEach(column -> {
            if (column.equals(smallScreenColumn)) {
                column.setVisible(isSmallScreen);
            } else {
                column.setVisible(!isSmallScreen);
            }
        });
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        // Listener needs to be eventually removed in order to avoid resource leak
        if (listener != null) listener.remove();
        super.onDetach(detachEvent);
    }
}
