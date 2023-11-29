package com.example.patterns1.data.main.animalsXML.trainEntities;


import com.example.patterns1.data.main.animalsXML.Train;
import com.example.patterns1.data.main.animalsXML.trainEntities.Strategy.InternationalTrainLinesStrategy;

public class InternationalTrain extends Train {
    public InternationalTrain(String num) {
        super.setTrainNumber(num);
        this.setTrainTypeStrategy(new InternationalTrainLinesStrategy());
    }
}
