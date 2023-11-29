package com.example.patterns.data.main.animalsXML.trainEntities;


import com.example.patterns.data.main.animalsXML.Train;
import com.example.patterns.data.main.animalsXML.trainEntities.Strategy.InterregionalTrainStrategy;

public class InterregionalTrain extends Train {
    public InterregionalTrain(String num) {
        super.setTrainNumber(num);
        this.setTrainTypeStrategy(new InterregionalTrainStrategy());
    }
}
