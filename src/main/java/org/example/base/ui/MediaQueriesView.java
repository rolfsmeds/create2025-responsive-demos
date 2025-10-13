package org.example.base.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("media-queries")
@PageTitle("Media Queries")
@Menu(order = 7, icon = "vaadin:css", title = "Media Queries")
public class MediaQueriesView extends Main {

    public MediaQueriesView() {

        /* See buttons-media-query.css and buttons-container-query.css */
        this.addClassNames("media-queries-view");   // <--

        setSizeFull();

        Div layout = new Div();
        /* See layout-media-query.css and layout-container-query.css */
        layout.addClassNames("switching-layout");   // <--
        this.add(layout);

        for (int i=0; i<3; i++) {
            var card = new Card();
            card.setTitle("Card " + i);
            card.add(new Span("Lorem ipsum dolor sit amet"));
            layout.add(card);
        }

        // add(createToolbar());

    }

    private Component createToolbar() {
        var toolbar = new HorizontalLayout();
        toolbar.setPadding(true);
        toolbar.setSpacing(true);
        toolbar.addClassNames("toolbar");
        toolbar.add(
                new Button("Cubes", VaadinIcon.CUBES.create()),
                new Button("Clipboard", VaadinIcon.CLIPBOARD_TEXT.create()),
                new Button("File", VaadinIcon.FILE.create()),
                new Button("Abacus", VaadinIcon.ABACUS.create()),
                new Button("Piggy Bank", VaadinIcon.PIGGY_BANK_COIN.create()),
                new Button("Airplane", VaadinIcon.AIRPLANE.create())
        );
        return toolbar;
    }

}
