package com.example.patterns1.data.main;


import com.example.patterns1.data.main.animalsXML.Train;
import com.example.patterns1.data.main.animalsXML.XMLReader;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GetTrainsImpl implements GetTrains {
    private static GetTrainsImpl INSTANCE;
    public static GetTrainsImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (GetTrainsImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GetTrainsImpl();
                }
            }
        }
        return INSTANCE;
    }
    private GetTrainsImpl(){}
    @Override
    public List<Train> getTrains() {
        XMLReader reader = XMLReader.getInstance();
        return reader.readXML();
    }

    @Override
    public Train getTrain(String id) {
        AtomicReference<Train> currentAnimal = new AtomicReference<>();
        getTrains().forEach(animal->{
            if(animal.getTrainNumber().equals(id)) currentAnimal.set(animal);
        });
        return currentAnimal.get();
    }
}