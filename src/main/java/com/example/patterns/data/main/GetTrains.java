package com.example.patterns.data.main;


import com.example.patterns.data.main.animalsXML.Train;

import java.util.List;

public interface GetTrains {
    public List<Train> getTrains();
    public Train getTrain(String id);
}
