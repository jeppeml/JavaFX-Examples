/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absolutelayouttest.flowpane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class FlowPaneExampleController implements Initializable
{

    @FXML
    private AnchorPane topPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        FlowPane myFlow = new FlowPane();
        myFlow.setPadding(new Insets(100));
        myFlow.setHgap(50);
        myFlow.setPrefSize(800, 600);
        
        for (int i = 0; i < 200; i++)
        {
            myFlow.getChildren().add(new Label("myLabel: " + i));
            
        }
        topPane.getChildren().add(myFlow);
    }    
    
}
