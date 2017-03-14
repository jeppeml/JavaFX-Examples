/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absolutelayouttest.absoluteexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jeppjleemoritzled
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    private Button jeppesButton ;
    
    @FXML
    private AnchorPane topPane;
    
    private int jeppeX = 0;
    private int jeppeY = 0;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        //button.layoutXProperty().set(0);
        button.textProperty().set("WEEE!");
        
        for (int i = 0; i < 1; i++)
        {
            Rectangle rect = new Rectangle(25,25,50,50);
            rect.setFill(Color.BLANCHEDALMOND);
            Line line = new Line(90,40,230,40);
            line.setStroke(Color.BLACK);
            topPane.getChildren().add(rect);
            topPane.getChildren().add(line);
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
        // TODO
    }    
    
}
