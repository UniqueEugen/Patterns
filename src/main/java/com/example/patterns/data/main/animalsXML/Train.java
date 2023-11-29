package com.example.patterns.data.main.animalsXML;
import com.example.patterns.data.main.animalsXML.trainEntities.Strategy.TrainTypeStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
public class Train {
    private String trainNumber;
    private String departureDate;
    private String departureTime;
    private String destination;
    private String departureStation;
    private String departurePlatform;
    private String arrivalStation;
    private List<Ticket> ticketTypesAndPrices;
    private String arrivalDate;
    private String arrivalTime;
    private TrainTypeStrategy trainTypeStrategy;
    public String announcement() {
        return trainTypeStrategy.announcement();
    }

    @Data
    public static class Ticket {
        private String type;
        private String price;
    }
}
