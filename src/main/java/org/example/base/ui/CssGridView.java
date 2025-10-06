package org.example.base.ui;

import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;


@Route("cssgrid")
@PageTitle("CSS Grid Layout")
@Menu(order = 2, icon = "vaadin:clipboard-check", title = "CSS Grid")
public class CssGridView extends Main {

    public CssGridView() {
        setSizeFull();
        addClassNames(LumoUtility.Padding.MEDIUM);

        var layout = new Div();
        layout.addClassNames(
                LumoUtility.Display.GRID,
                LumoUtility.Gap.MEDIUM,
                LumoUtility.Grid.Column.COLUMNS_2,
                LumoUtility.Grid.Breakpoint.Medium.COLUMNS_4
        );
        this.add(layout);

        for (int i=0; i<10; i++) {
            var card = new Card();
            card.setTitle("Card " + i);
            card.add(new Span("Lorem ipsum dolor sit amet"));
            layout.add(card);
        }
    }
}
