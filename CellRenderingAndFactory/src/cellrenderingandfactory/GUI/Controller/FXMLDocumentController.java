/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellrenderingandfactory.GUI.Controller;

import cellrenderingandfactory.BE.WaterData;
import cellrenderingandfactory.BE.WaterData.DataType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author jeppjleemoritzled
 */
public class FXMLDocumentController implements Initializable
{
    @FXML
    private TableView<WaterData> tblWater;
    @FXML
    private TableColumn<WaterData, String> colName;
    @FXML
    private TableColumn<WaterData, Float> colConduct;
    @FXML
    private TableColumn<WaterData, Float> colPH;
    @FXML
    private TableColumn<WaterData, Float> colCalcium;
    @FXML
    private TableColumn<WaterData, Float> colPot;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        colName.setCellValueFactory(cellData->cellData.getValue().nameProperty());
        colPH.setCellValueFactory(val -> val.getValue().pHProperty().asObject());
        colPH.setCellFactory(getCustomCellFactory(DataType.pH));
        
        colConduct.setCellValueFactory(val->val.getValue().conductivityProperty().asObject());
        colConduct.setCellFactory(getCustomCellFactory(DataType.conductivity));
        
        colCalcium.setCellValueFactory(val->val.getValue().calciumProperty().asObject());
        colCalcium.setCellFactory(getCustomCellFactory(DataType.calcium));
        
        colPot.setCellValueFactory(val->val.getValue().potassiumProperty().asObject());
        colPot.setCellFactory(getCustomCellFactory(DataType.potassium));
        
        tblWater.setItems(createMockData());
    }    
    
    private Callback<TableColumn<WaterData, Float>, TableCell<WaterData, Float>> getCustomCellFactory(DataType dataType) {
        return (TableColumn<WaterData, Float> param) ->
        {
            return new TableCell<WaterData, Float>() {
                @Override
                public void updateItem(final Float item, boolean empty) {
                    if (item != null) {
                        setText(item+"");
                        String warningClass = dataType.getCSSClass(item);
                        getStyleClass().add(warningClass);
                    }
                }
            };
        };
    }
   
    private ObservableList<WaterData> createMockData()
    {
        ObservableList<WaterData> ret = FXCollections.observableArrayList();
        // Conductivity >30, 7<pH<8.5, Calcium <200 ,pot. <10      // http://www.tjekvand.dk/kvalitetskrav-til-drikkevand.html
        ret.add(new WaterData("Kjersing", 260, 8.4f, 110, 9.3f)); // from http://data.geus.dk/JupiterWWW/waterlist.jsp?virksomhedstype=VV&navn=&vandvaerksid=0&adresse=&maengdemin=0&maengdemax=2147483647&kommune2007vandindvind=561&submit=Vis+liste+med+vandforsyningsanl%E6g
        ret.add(new WaterData("Hjerting", 43, 7.6f, 49, 2.2f));
        ret.add(new WaterData("Gørding", 54, 7.5f, 65, 4.9f));
        ret.add(new WaterData("Skodding", 30, 4, 250, 9)); // made up :)
        return ret;
    }
    
}
