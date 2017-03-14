/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchjeppeversion.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import wordsearchjeppeversion.BLL.strategies.BeginsWith;
import wordsearchjeppeversion.BLL.strategies.CompareStrategy;
import wordsearchjeppeversion.BLL.strategies.Contains;
import wordsearchjeppeversion.BLL.strategies.EndsWith;
import wordsearchjeppeversion.BLL.WordManager;
import wordsearchjeppeversion.BLL.strategies.Exact;
import wordsearchjeppeversion.GUI.Model.WordModel;

/**
 *
 * @author Jeppe
 */
public class MainViewController implements Initializable {
    @FXML
    private ListView<String> listWords;
    @FXML
    private Label lblCount;
    @FXML
    private TextField textQuery;
    @FXML
    private RadioButton rbBegins;
    @FXML
    private RadioButton rbContains;
    @FXML
    private RadioButton rbEnds;
    @FXML
    private RadioButton rbExact;
    @FXML
    private CheckBox chkCase;
    @FXML
    private ComboBox<String> comboLimit;
   
    final ToggleGroup toggleStrategy = new ToggleGroup();
    
    private WordModel model;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadModelAndBind();
        initRadioButtonGroup();
        fillComboBox();
        
        // Cannot be done from scene builder. This handles changes to the text in the text field: textQuery
        // This is called an anonymous inner class, we have not looked into this yet, so do not worry. 
        textQuery.textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                try {
                    clickSearch(null);
                } catch (IOException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }    
    
    private void loadModelAndBind()
    {
        try {
            model = new WordModel(WordManager.getInstance().getAllWords());
        } catch (IOException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblCount.textProperty().bind(model.getCount().asString()); // Binding property to label
        listWords.setItems(model.getWordList()); // Now the ListView will update when the wordlist changes in the model
    }
    
    private void fillComboBox()
    {
        comboLimit.setItems(FXCollections.observableArrayList("No limit", "10", "20", "50"));
        comboLimit.getSelectionModel().selectFirst();
    }
    
    private void initRadioButtonGroup()
    {
        rbBegins.setToggleGroup(toggleStrategy);
        rbBegins.setSelected(true);
        rbContains.setToggleGroup(toggleStrategy);
        rbEnds.setToggleGroup(toggleStrategy);
        rbExact.setToggleGroup(toggleStrategy);
        
    }
    
    @FXML
    private void clickClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void clickSearch(ActionEvent event) throws IOException{
        
        CompareStrategy strategy = getSelectedStrategy();
        List<String> filtered = WordManager.getInstance().filterWords(strategy);
      
        try
        {
            int numberlimit=Integer.parseInt(comboLimit.getSelectionModel().getSelectedItem());
            filtered = filtered.subList(0, numberlimit);
        }
        catch(NumberFormatException nfe)
        {
            // keep list, and do nothing
        }
        model.setWords(filtered);
    }
    
    private CompareStrategy getSelectedStrategy()
    {
        boolean isCaseSensitive = chkCase.isSelected();
        String query = textQuery.getText();
        
        if      (toggleStrategy.getSelectedToggle() == rbBegins)
            return new BeginsWith(query,isCaseSensitive);
        
        else if (toggleStrategy.getSelectedToggle() == rbContains)
            return new Contains(query, isCaseSensitive);
        
        else if (toggleStrategy.getSelectedToggle() == rbEnds)
            return new EndsWith(query, isCaseSensitive);
        
        else if (toggleStrategy.getSelectedToggle() == rbExact)
            return new Exact(query, isCaseSensitive);
        else return null;
        
    }

    @FXML
    private void clickClear(ActionEvent event) throws IOException {
        textQuery.clear();
        model.setWords(WordManager.getInstance().getAllWords());
    }


    
}
