package com.example.patterns.data.main;


import com.example.patterns.data.main.animalsXML.Train;
import com.example.patterns.data.main.animalsXML.XMLReader;
import com.example.patterns.data.main.observer.XMLNodeObserver;
import com.example.patterns.data.main.observer.XMLNodeParserObserver;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class GetTrainsImpl implements GetTrains {
    private static GetTrainsImpl INSTANCE;
    XMLNodeObserver observer;
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
    private GetTrainsImpl(){
        observer = new XMLNodeParserObserver();
    }
    @Override
    public List<Train> getTrains() {
        XMLReader reader = XMLReader.getInstance();
        reader.addObserver(observer);
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