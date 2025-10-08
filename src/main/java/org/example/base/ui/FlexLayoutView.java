package org.example.base.ui;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.card.Card;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.theme.lumo.LumoUtility;


@Route("flexlayout")
@PageTitle("FlexLayout")
@Menu(order = 8, icon = "vaadin:clipboard-check", title = "FlexLayout")
public class FlexLayoutView extends Main {

    private Registration listener;

    FlexLayout layout = new FlexLayout();

    public FlexLayoutView() {
        setSizeFull();

        layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        layout.addClassNames(
                LumoUtility.Gap.MEDIUM
        );
        this.add(layout);

        for (int i=0; i<3; i++) {
            var card = new Card();
            card.setTitle("Card " + i);
            card.add(new Span("Lorem ipsum dolor sit amet"));
            layout.add(card);
        }
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        // Add browser window listener to observe width change
        Page page = attachEvent.getUI().getPage();
        listener = page.addBrowserWindowResizeListener(event -> {
            adjustLayoutDirection(event.getWidth());
        });
        // Adjust Grid according to initial width of the screen
        page.retrieveExtendedClientDetails(receiver -> {
            int browserWidth = receiver.getBodyClientWidth();
            adjustLayoutDirection(browserWidth);
        });
    }

    private void adjustLayoutDirection(int width) {
        if (width > 800) {
            layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        } else {
            layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        }
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        // Listener needs to be eventually removed in order to avoid resource leak
        listener.remove();
        super.onDetach(detachEvent);
    }
}
