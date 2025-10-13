package org.example.base.ui;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.dashboard.Dashboard;
import com.vaadin.flow.component.dashboard.DashboardWidget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.parameters.P;


@Route(value="dashboard")
@PageTitle("Dashboard")
@Menu(order = 2, icon = "vaadin:dashboard", title = "Dashboard")
public class DashboardView extends VerticalLayout {

    public DashboardView() {
        setSizeFull();

        Dashboard dashboard = new Dashboard();
        dashboard.setSizeFull();
        dashboard.setMinimumColumnWidth("225px");
        //dashboard.setDenseLayout(true);
        add(dashboard);

        dashboard.add(createKpiWidget("Downloads per day", "273"));
        dashboard.add(createColumnChartWidget("Downloads", ChartType.COLUMN));
        dashboard.add(createPieChartWidget("Downloads vs Uploads", 4900, 11200));
        dashboard.add(createColumnChartWidget("Uploads", ChartType.AREA));
        dashboard.add(createPieChartWidget("Uploads vs Downloads", 11200, 4900));
        dashboard.add(createKpiWidget("Uploads per day", "102"));


    }

    public static DashboardWidget createKpiWidget(String title, String value) {
        DashboardWidget widget = new DashboardWidget();
        widget.setTitle(title);
        Span kpiValue= new Span(value);
        Span kpiExplainer = new Span("Last 30 days average");
        Div kpiLayout = new Div(kpiValue, kpiExplainer);
        kpiLayout.addClassName("kpi");
        widget.setContent(kpiLayout);
        return widget;
    }

    public static DashboardWidget createColumnChartWidget(String title, ChartType type) {
        DashboardWidget widget = new DashboardWidget();
        widget.setTitle(title);
        Chart chart = new Chart(type);
        widget.setContent(chart);
        chart.setWidth("100%");
        chart.setHeight("100%");
        chart.setMaxHeight("200px");
        Configuration config = chart.getConfiguration();
        ListSeries series = new ListSeries("Downloads");
        series.setData( 152,452,958,134,452,90,756,342,124,453,
                        720,342,98,400,210,102,143,403,610,512,
                        589,538,62,328,251,826,124,431,342,93);
        config.addSeries(series);
        config.getLegend().setEnabled(false);
        config.getyAxis().setTitle("");
        config.getyAxis().setMax(1000);
        widget.setColspan(2);
        return widget;
    }

    public static DashboardWidget createPieChartWidget(String title, int slice1, int slice2) {
        DashboardWidget widget = new DashboardWidget();
        widget.setTitle(title);
        Chart chart = new Chart(ChartType.PIE);
        widget.setContent(chart);
        chart.setWidth("100%");
        chart.setHeight("100%");
        chart.setMaxHeight("200px");
        Configuration config = chart.getConfiguration();
        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Downloads", slice1));
        series.add(new DataSeriesItem("Uploads", slice2));
        config.addSeries(series);
        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.getDataLabels().setEnabled(false);
        config.setPlotOptions(plotOptions);
        return widget;
    }

}