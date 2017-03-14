/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menutest;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainViewController implements Initializable
{
    @FXML
    private AnchorPane topPane;
    @FXML
    private Label secretLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem superSecretItem = new MenuItem("You found the secret, Woooo");
        contextMenu.getItems().add(superSecretItem);
        secretLabel.setContextMenu(contextMenu);
        EventHandler gotoTrumpDonaldEvent = new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                Alert alert = new Alert(
                        Alert.AlertType.WARNING, "TrumpDonald.org", ButtonType.OK);
                alert.show();
            }

        };
        superSecretItem.setOnAction(gotoTrumpDonaldEvent);
        
        MenuBar bar = new MenuBar();
        topPane.getChildren().add(bar);
        
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setOnAction((ActionEvent daniel) ->
        {
            System.out.println("You clicked new!" + daniel.getSource());
        });
        
        fileMenu.getItems().add(newItem);
        MenuItem openItem = new MenuItem("Open");
        
        openItem.setOnAction((ActionEvent event) ->
        {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            File f = 
                fileChooser.showOpenDialog(topPane.getScene().getWindow());
            if(f!=null)
                System.out.println("Your clicked file: " + f.getAbsolutePath());
        });
        fileMenu.getItems().add(openItem);
        
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(gotoTrumpDonaldEvent);
        fileMenu.getItems().add(saveItem);
        fileMenu.getItems().add(new MenuItem("Save as"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction((ActionEvent event) ->
        {
            System.exit(0);
        });
        
        fileMenu.getItems().add(exitItem);
        bar.getMenus().add(fileMenu);
        
        bar.prefWidthProperty().bind(topPane.widthProperty());
        
        
    }    
    
}
