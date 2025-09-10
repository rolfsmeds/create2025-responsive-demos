package org.example.base.ui;

import org.example.base.ui.component.ViewToolbar;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.SvgIcon;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

/**
 * This view shows up when a user navigates to the root ('/') of the application.
 */
@Route
@Menu(order = -100, icon = "vaadin:home", title = "Welcome!")
public final class MainView extends Main {

    // TODO Replace with your own main view.

    MainView() {
        addClassNames(LumoUtility.Padding.MEDIUM, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
                LumoUtility.BoxSizing.BORDER);
        setSizeFull();

        var contentDiv = new Div();
        contentDiv.addClassNames(LumoUtility.Flex.GROW, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
                LumoUtility.AlignItems.CENTER, LumoUtility.JustifyContent.CENTER);

        var icon = new SvgIcon("icons/construction.svg");
        icon.addClassNames(LumoUtility.TextColor.SUCCESS);
        icon.getStyle().setWidth("200px");
        icon.getStyle().setHeight("200px");

        var centerDiv = new Div(icon, new Paragraph("Replace this view with your own main view!"));
        centerDiv.addClassNames(LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN,
                LumoUtility.AlignItems.CENTER);
        contentDiv.add(centerDiv);

        add(new ViewToolbar("Welcome to Vaadin!"));
        add(contentDiv);
    }
}
