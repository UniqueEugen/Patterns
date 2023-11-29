package com.example.patterns1.data.main;


import com.example.patterns1.data.main.animalsXML.Train;

import java.util.List;

public interface GetTrains {
    public List<Train> getTrains();
    public Train getTrain(String id);
}
