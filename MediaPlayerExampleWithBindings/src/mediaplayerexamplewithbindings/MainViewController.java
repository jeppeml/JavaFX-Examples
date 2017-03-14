/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayerexamplewithbindings;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.StringBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainViewController implements Initializable
{

    MediaPlayer mp = null;
    String songURIPath = "http://www.freexmasmp3.com/files/12-days-funk.mp3";

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField txtURI;

    @FXML
    private void handleButtonAction(ActionEvent event) throws URISyntaxException
    {
        URI songURI = new URI(txtURI.getText());
        playSong(songURI);
    }
    
    private void playSong(URI songURI)
    {
        if (mp != null && mp.getStatus() == MediaPlayer.Status.PLAYING)
        {
            mp.stop();
        }
        try
        {
            mp = new MediaPlayer(new Media(songURI.toString()));
            bindPlayerToGUI();
            mp.play();
        }
        catch (UnsupportedOperationException ex)
        {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            
            Alert alert = 
                new Alert(Alert.AlertType.ERROR, 
                            songURIPath + String.format("%n") + ex.getMessage()){};
            alert.show();
        }
    }
    
    private void bindPlayerToGUI()
    {
        // Binds the currentTimeProperty to a StringProperty on the label
        // The computeValue() calculates minutes and seconds from the
        // CurrentTimeProperty, which is a javafx Duration type.
        label.textProperty().bind(
            new StringBinding()
            {
                // Initialization block 
                // Somewhat like a constructor without arguments
                { 
                    // Makes the StringBinding listen for changes to 
                    // the currentTimeProperty
                    super.bind(mp.currentTimeProperty());
                }

                @Override
                protected String computeValue()
                {
                    
                    String form = String.format("%d min, %d sec", 
                        TimeUnit.MILLISECONDS.toMinutes((long)mp.getCurrentTime().toMillis()),
                        TimeUnit.MILLISECONDS.toSeconds((long)mp.getCurrentTime().toMillis()) - 
                        TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                (long)mp.getCurrentTime().toMillis()
                            )
                        )
                    );
                    
                    return form;
                }
            });
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        txtURI.setText(songURIPath);
        try
        {
            URI songURI = new URI(songURIPath);
            mp = new MediaPlayer(new Media(songURI.toString()));
            bindPlayerToGUI();
        }
        catch (URISyntaxException|UnsupportedOperationException ex)
        {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            
            Alert alert = 
                new Alert(Alert.AlertType.ERROR, 
                            songURIPath + " not a usable URI" + ex.getMessage()){};
            alert.show();
        }
        
    }

}
