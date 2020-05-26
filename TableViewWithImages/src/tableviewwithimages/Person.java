/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableviewwithimages;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Jeppe
 */
public class Person {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty atWork = new SimpleIntegerProperty();
    
    public Person(int id, int atWork){
        this.id.set(id);
        this.atWork.set(atWork);
    }
    
    public int getAtWork() {
        return atWork.get();
    }

    public void setAtWork(int value) {
        atWork.set(value);
    }

    public IntegerProperty atWorkProperty() {
        return atWork;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }
    
}
