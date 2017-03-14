/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsearchjeppeversion.BLL.strategies;

import java.util.List;

/**
 *
 * @author Jeppe
 */
public class Contains extends AbstractCompareStrategy{

    public Contains(String query, boolean isCaseSensitive) {
        super(query, isCaseSensitive);
    }
  
    @Override
    public boolean compare(String word) {
        if(isCaseSensitive) 
            return word.contains(query);
        else
            return word.toLowerCase().contains(query.toLowerCase());
    }
}
