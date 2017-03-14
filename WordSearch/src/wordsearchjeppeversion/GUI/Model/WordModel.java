/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchjeppeversion.GUI.Model;

import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jeppe
 */
public class WordModel {
    private final ObservableList<String> wordList;
    private final SimpleIntegerProperty count;

    public WordModel() {
        this.wordList = FXCollections.observableArrayList();
        count = new SimpleIntegerProperty(-1);
    }
    
    public WordModel(List<String> wordList) {
        this.wordList = FXCollections.observableArrayList(wordList);
        count = new SimpleIntegerProperty(wordList.size());
    }

    public ObservableList<String> getWordList() {
        return wordList;
    }

    public SimpleIntegerProperty getCount() {
        return count;
    }
    
    public void setWords(List<String> words)
    {
        wordList.clear();
        wordList.addAll(words);
        count.set(wordList.size());
    }
    
    
    
    
}
