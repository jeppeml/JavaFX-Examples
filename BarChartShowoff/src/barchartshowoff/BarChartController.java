/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barchartshowoff;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author jeppjleemoritzled
 */
public class BarChartController implements Initializable
{
    @FXML
    private AnchorPane topPane;
    
    @FXML
    private Button button;
    
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    
    private StackedBarChart<String, Number> stackedChart =
                new StackedBarChart<>(xAxis,yAxis);
    
    private XYChart.Series<String, Number> series2015 =
                new XYChart.Series<>();
    
    private XYChart.Series<String, Number> series2016 =
                new XYChart.Series<>();
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        series2016.getData().clear();
        series2015.getData().clear();
        
        series2015.getData().add(new XYChart.Data("January", 250));
        series2015.getData().add(new XYChart.Data("February", 241));
        series2015.getData().add(new XYChart.Data("March", 175));

        
        series2016.getData().add(new XYChart.Data("January", 173));
        series2016.getData().add(new XYChart.Data("February", 140));
        series2016.getData().add(new XYChart.Data("March", 70));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        topPane.getChildren().add(stackedChart);
        series2016.setName("2016");
        stackedChart.getData().add(series2015);
        stackedChart.getData().add(series2016);
        xAxis.setLabel("Month");
        xAxis.setCategories(
                FXCollections.observableArrayList(
                        Arrays.asList(
                                "January",
                                "February",
                                "March"
                        )
                )
        );
        
        yAxis.setLabel("Power Usage KWh");
  
        stackedChart.setTitle("Household power usage");

        series2015.setName("2015");
    }    
    
}
