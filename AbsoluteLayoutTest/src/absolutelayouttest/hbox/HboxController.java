/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package absolutelayouttest.hbox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author jeppjleemoritzled
 */
public class HboxController implements Initializable
{

    @FXML
    private AnchorPane topPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        HBox hbox = new HBox(15); // 15 is spacing
        hbox.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
                    CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        hbox.alignmentProperty().set(Pos.TOP_RIGHT);
        hbox.setMinWidth(topPane.getWidth());
        Button[] btnArr = new Button[5];
        btnArr[0] = new Button(" << ");
        btnArr[1] = new Button(" <  ");
        btnArr[2] = new Button(" |> ");
        btnArr[3] = new Button(" >  ");
        btnArr[4] = new Button(" >> ");
        
        hbox.getChildren().addAll(btnArr);
        try
        {
            AnchorPane ap = FXMLLoader.load(getClass().getResource("/absolutelayouttest/flowpane/FlowPaneExample.fxml"));
            topPane.getChildren().add(ap);
        }
        catch (IOException ex)
        {
            Logger.getLogger(HboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
        topPane.getChildren().add(hbox);
        topPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
                    CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
    }    
    
}
