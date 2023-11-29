package com.example.patterns.data.main.animalsXML.trainEntities.Strategy;



public class RegionalTrainStrategy implements TrainTypeStrategy {
    private final static String TRAIN_TYPE = "Поезд межрегиональных линий";
    @Override
    public String announcement() {
        System.out.println(TRAIN_TYPE);
        return TRAIN_TYPE;
    }
}
