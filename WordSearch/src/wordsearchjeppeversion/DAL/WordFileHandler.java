/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchjeppeversion.DAL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jeppe
 */
public class WordFileHandler {
    
    private static WordFileHandler instance;
    
    public static WordFileHandler getInstance()
    {
        if(instance==null)
            instance = new WordFileHandler();
        return instance;
    }
    
    private WordFileHandler() {
    }
    public List<String> getAllWords(String fileName) throws IOException
    {
        List<String> allWords = new ArrayList();
        File wordFile = new File(fileName);        
        try(BufferedReader br = new BufferedReader(new FileReader(wordFile)))
        {
            Scanner scan = new Scanner(br);
            while(scan.hasNextLine())
            {
                String word = scan.nextLine();
                allWords.add(word);
            }
        } 
        return allWords;
    }
    
}
