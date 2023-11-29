package com.example.patterns1.data.main.animalsXML.trainEntities.Strategy;


public class InterregionalTrainStrategy implements TrainTypeStrategy {
    private final static String TRAIN_TYPE = "Поезд региональных линий";
    @Override
    public String announcement() {
        System.out.println(TRAIN_TYPE);
        return TRAIN_TYPE;
    }
}
