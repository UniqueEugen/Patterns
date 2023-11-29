package com.example.patterns1.data.main.animalsXML.trainFactory;


import com.example.patterns1.data.main.animalsXML.Train;
import com.example.patterns1.data.main.animalsXML.trainEntities.InternationalTrain;
import com.example.patterns1.data.main.animalsXML.trainEntities.InterregionalTrain;
import com.example.patterns1.data.main.animalsXML.trainEntities.RegionalTrain;

public class TrainFactory {
    public static Train createTrain (String FullNum) {
        Train train = null;
        var num = String.valueOf(FullNum.charAt(FullNum.length()-1));
        switch (num) {
            case "B":
                train = new RegionalTrain(FullNum);
                break;
            case "A":
                train = new InterregionalTrain(FullNum);
                break;
            case "C":
                train = new InternationalTrain(FullNum);
                break;
        }

        return train;
    }
}
