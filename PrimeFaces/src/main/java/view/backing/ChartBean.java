/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import static java.lang.Math.sin;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.charts.ChartData;

/**
 *
 * @author user
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean
{

    private LineChartModel model;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean()
    {
        model = new LineChartModel();
        LineChartSeries sinusValue = new LineChartSeries();
        LineChartSeries cosinusValue = new LineChartSeries();

        sinusValue.setLabel("sinus");
        cosinusValue.setLabel("cosinus");
        
        for (int i = 0; i < 360; i += 10)
        {
            sinusValue.set(i, Math.sin(Math.toRadians(i)));
            cosinusValue.set(i, Math.cos(Math.toRadians(i)));
        }

        model.addSeries(sinusValue);
        model.addSeries(cosinusValue);

        model.setLegendPosition("e");

        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(360);

        xAxis.setLabel("Degrees");

        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setMin(-1.5);
        yAxis.setMax(1.5);
        yAxis.setLabel("Sinus Value");

        model.setZoom(true);
    }

    public void resetZoom()
    {
        model.setZoom(false);
    }

    /**
     * @return the model
     */
    public LineChartModel getModel()
    {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(LineChartModel model)
    {
        this.model = model;
    }

}
