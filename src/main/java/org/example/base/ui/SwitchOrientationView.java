package org.example.base.ui;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;


@Route("orientation")
@PageTitle("Orientation Switch")
@Menu(order = 1, icon = "vaadin:clipboard-check", title = "Orientation")
public class SwitchOrientationView extends Main {

    public SwitchOrientationView() {
        setSizeFull();

        var layout = new Div();
        layout.addClassNames(
                LumoUtility.Display.FLEX,
                LumoUtility.Gap.MEDIUM,
                LumoUtility.FlexDirection.COLUMN,
                LumoUtility.FlexDirection.Breakpoint.Medium.ROW
        );
        this.add(layout);

        for (int i=0; i<3; i++) {
            var card = new Card();
            card.setTitle("Card " + i);
            card.add(new Span("Lorem ipsum dolor sit amet"));
            layout.add(card);
        }
    }
}
