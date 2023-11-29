package com.example.patterns1.data.main.animalsXML;
import com.example.patterns1.data.main.animalsXML.trainFactory.TrainFactory;
import lombok.Data;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class XMLReader {
    private static XMLReader INSTANCE;
    public static XMLReader getInstance() {
        if (INSTANCE == null) {
            synchronized (XMLReader.class) {
                if (INSTANCE == null) {
                    INSTANCE = new XMLReader();
                }
            }
        }
        return INSTANCE;
    }
    private XMLReader(){}
    public List<Train> readXML() {
        List<Train> trains = null;
        File file = new File("E:/ВДИШП/Паттерны/Trains.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            String rootNode = document.getDocumentElement().getNodeName();
            System.out.println("Root Element : " + rootNode);
            trains = getTrainData(document);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return trains;
    }

    private static List<Train> getTrainData(Document document) {

        NodeList list = document.getElementsByTagName("train");
        int length = list.getLength();
        List<Train> trains = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Train animal = getAnimal(element);
                trains.add(animal);
            }
        }

        return trains;
    }

    private static Train getAnimal(Element root) {

        Train train = TrainFactory.createTrain(Objects.requireNonNull(getTextContent(root, "train_number")));
        train.setTrainNumber(getTextContent(root, "train_number"));
        train.setDepartureDate(getTextContent(root, "departure_date"));
        train.setDepartureTime(getTextContent(root, "departure_time"));
        train.setDestination(getTextContent(root, "destination"));
        train.setDepartureStation(getTextContent(root, "departure_station"));
        train.setDeparturePlatform(getTextContent(root, "departure_platform"));
        train.setArrivalStation(getTextContent(root, "arrival_station"));
        train.setArrivalDate(getTextContent(root, "arrival_date"));
        train.setArrivalTime(getTextContent(root, "arrival_time"));

        List<Train.Ticket> tickets = new ArrayList<>();
        NodeList ticketNodes = root.getElementsByTagName("ticket");
        for (int i = 0; i < ticketNodes.getLength(); i++) {
            Element ticketElement = (Element) ticketNodes.item(i);
            Train.Ticket ticket = new Train.Ticket();
            ticket.setType(getTextContent(ticketElement, "type"));
            ticket.setPrice(getTextContent(ticketElement, "price"));
            tickets.add(ticket);
        }
        train.setTicketTypesAndPrices(tickets);

        return train;
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Element tagElement = (Element) nodeList.item(0);
            return tagElement.getTextContent();
        }
        return null;
    }
    /*@Override
    public String toString(){
        trains.forEach(animal->{animal.toString(); animal.announcement();});
        return null;
    }*/

}
