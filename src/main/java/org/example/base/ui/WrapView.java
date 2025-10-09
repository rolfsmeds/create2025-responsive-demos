package org.example.base.ui;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;


@Route("wrap")
@PageTitle("Wrap")
@Menu(order = 4, icon = "vaadin:enter-arrow", title = "Wrap")
public class WrapView extends Main {

    public WrapView() {
        setSizeFull();
        addClassName(LumoUtility.Padding.MEDIUM);

        var layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setWidthFull();
        layout.setWrap(true);      // <---
        this.add(layout);

        for (int i=0; i<6; i++) {
            var card = new Card();
            card.setTitle("Card " + i);
            card.add(new Span("Lorem ipsum dolor sit amet"));
            layout.add(card);
        }
    }
}
