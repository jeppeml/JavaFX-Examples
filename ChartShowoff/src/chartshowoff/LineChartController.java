/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartshowoff;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author jeppjleemoritzled
 */
public class LineChartController implements Initializable
{

    @FXML
    private Button button;
    @FXML
    private AnchorPane topPane;

    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<Number, Number> lineChart
            = new LineChart<>(xAxis, yAxis);
    private int year = 2016;

    @FXML
    private void handleButtonAction(ActionEvent event)
    {

        xAxis.setLabel("Month number");

        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(1);
        xAxis.setUpperBound(12);
        xAxis.setTickUnit(1);

        lineChart.setTitle("Rainfall per month");

        Random r = new Random();

        for (int z = 0; z < 10; z++)
        {
            XYChart.Series<Number, Number> series
                    = new XYChart.Series<>();
            series.setName("" + year--);
            for (int i = 1; i <= 12; i++)
            {

                series.getData().add(new XYChart.Data<>(i, r.nextInt(80)));
            }
            lineChart.getData().add(series);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        topPane.getChildren().add(lineChart);
    }

}
