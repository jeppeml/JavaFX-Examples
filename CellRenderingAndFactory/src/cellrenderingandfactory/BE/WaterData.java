/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellrenderingandfactory.BE;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jeppjleemoritzled
 */
public class WaterData
{
    public enum DataType
    {
        conductivity(30f, Float.MAX_VALUE),
        pH(7f, 8.5f),
        calcium(0f, 200f),
        potassium(0f, 10f);
        // Conductivity >30, 7<pH<8.5, Calcium <200 ,pot. <10      // http://www.tjekvand.dk/kvalitetskrav-til-drikkevand.html

        private final Float minValue;
        private final Float maxValue;
        
        // Max and min bounds for values
        private DataType(Float minValue, Float maxValue)
        {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public String getCSSClass(Float value)
        {
            String cssClass = "noWarning";
            if (value <= minValue || value >= maxValue)
            {
                cssClass = "midWarning";
                if (value / minValue < 0.75 || value / maxValue > 1.25)
                {
                    cssClass = "highWarning";
                }
            }
            return cssClass;
        }
    };

    private final StringProperty name = new SimpleStringProperty();
    private final FloatProperty conductivity = new SimpleFloatProperty();
    private final FloatProperty pH = new SimpleFloatProperty();
    private final FloatProperty calcium = new SimpleFloatProperty();
    private final FloatProperty potassium = new SimpleFloatProperty();

    public WaterData(String name, float conductivity, float pH, float calcium, float potassium)
    {
        this.name.set(name);
        this.conductivity.set(conductivity);
        this.pH.set(pH);
        this.calcium.set(calcium);
        this.potassium.set(potassium);
    }

    public WaterData()
    {
    }

    public float getPotassium()
    {
        return potassium.get();
    }

    public void setPotassium(float value)
    {
        potassium.set(value);
    }

    public FloatProperty potassiumProperty()
    {
        return potassium;
    }

    public float getCalcium()
    {
        return calcium.get();
    }

    public void setCalcium(float value)
    {
        calcium.set(value);
    }

    public FloatProperty calciumProperty()
    {
        return calcium;
    }

    public float getpH()
    {
        return pH.get();
    }

    public void setpH(float value)
    {
        pH.set(value);
    }

    public FloatProperty pHProperty()
    {
        return pH;
    }

    public float getConductivity()
    {
        return conductivity.get();
    }

    public void setConductivity(float value)
    {
        conductivity.set(value);
    }

    public FloatProperty conductivityProperty()
    {
        return conductivity;
    }

    public String getName()
    {
        return name.get();
    }

    public void setName(String value)
    {
        name.set(value);
    }

    public StringProperty nameProperty()
    {
        return name;
    }

}
