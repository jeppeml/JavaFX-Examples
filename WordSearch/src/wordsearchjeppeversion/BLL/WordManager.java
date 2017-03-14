/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchjeppeversion.BLL;

import wordsearchjeppeversion.BLL.strategies.CompareStrategy;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import wordsearchjeppeversion.DAL.WordFileHandler;

/**
 *
 * @author Jeppe
 */
public class WordManager {
    private List<String> wordList = new ArrayList<>();
    private String filepath = "brit-a-z.txt";
    
    private static WordManager instance;
    public static WordManager getInstance()
    {
        if(instance==null)
            instance = new WordManager();
        return instance;
    }

    private WordManager() {
    }

    public String getFilepath() {
        return filepath;
    }

    public void loadNewFile(String filepath) {
        this.filepath = filepath;
    }
        
    public List<String> filterWords(CompareStrategy comparer) throws IOException
    {
        List<String> filteredWords = new ArrayList();
        
        List<String> allWords = getAllWords();
        for (String word : allWords) 
            if(comparer.compare(word))
                filteredWords.add(word);
        
        return filteredWords;
        
    }
    
    public List<String> getAllWords() throws IOException
    {
        return WordFileHandler.getInstance().getAllWords(filepath);
    }
    
    
    
    
}
