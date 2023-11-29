package com.example.patterns.data.main.animalsXML.trainEntities;

import com.example.patterns.data.main.animalsXML.Train;
import com.example.patterns.data.main.animalsXML.trainEntities.Strategy.RegionalTrainStrategy;

public class RegionalTrain extends Train {
    public RegionalTrain(String num){
        super.setTrainNumber(num);
        this.setTrainTypeStrategy(new RegionalTrainStrategy());
    }
}
