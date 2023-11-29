<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.patterns1.data.main.animalsXML.Train" %>
<%@ page import="com.example.patterns1.data.main.GetTrainsImpl" %>
<%! private List<Train> trains = GetTrainsImpl.getInstance().getTrains();%>
<%! private ArrayList<Double> prices = new ArrayList<>();%>
<%! private String mas = "['Билет', 'Цена'],"; %>
<%--<%
    Double sum = animals.stream().mapToDouble(Entity::getPrice).sum();
    Double unoPercent = sum/100;
    animals.forEach(animal -> prices.add(animal.getPrice()/unoPercent));
%>--%>
<!DOCTYPE html>
<html>
<head>
    <title>Trains schedule</title>
    <script src="https://www.google.com/jsapi"></script>
    <link rel="stylesheet" type="text/css" href="css/Table.css">
    <%--<script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Газ', 'Объём'],
                ['<%=animals.get(0).getKind()%>', <%= animals.get(0).getPrice()%>],
                ['<%=animals.get(1).getKind()%>', <%= animals.get(1).getPrice()%>],
                ['<%=animals.get(2).getKind()%>', <%= animals.get(2).getPrice()%>],
                ['<%=animals.get(3).getKind()%>', <%= animals.get(3).getPrice()%>],
                ['<%=animals.get(4).getKind()%>', <%= animals.get(4).getPrice()%>],
                ['<%=animals.get(5).getKind()%>', <%= animals.get(5).getPrice()%>],
                ['<%=animals.get(6).getKind()%>', <%= animals.get(6).getPrice()%>],
                ['<%=animals.get(7).getKind()%>', <%= animals.get(7).getPrice()%>]
            ]);
            var options = {
                title: 'Цены животных',
                is3D: true,
                pieResidueSliceLabel: 'Остальное'
            };
            var chart = new google.visualization.PieChart(document.getElementById('air'));
            chart.draw(data, options);
        }
    </script>--%>
</head>
<body>

<table border="4" cellspacing="2">
    <thead>
    <tr>
        <th>Train Number</th>
        <th>Departure Date</th>
        <th>Departure Time</th>
        <th>Destination</th>
        <th>Departure Station</th>
        <th>Departure Platform</th>
        <th>Arrival Station</th>
        <th>Ticket Types and Prices</th>
        <th>Arrival Date</th>
        <th>Arrival Time</th>
    </tr>
    </thead>
    <%
        for (Train train : trains) {
            out.println("<tr onclick=\"window.location.href='trains?id=" + train.getTrainNumber() + "'\">");
            out.println("<td>" + train.getTrainNumber() + "</td>");
            out.println("<td>" + train.getDepartureDate() + "</td>");
            out.println("<td>" + train.getDepartureTime() + "</td>");
            out.println("<td>" + train.getDestination() + "</td>");
            out.println("<td>" + train.getDepartureStation() + "</td>");
            out.println("<td>" + train.getDeparturePlatform() + "</td>");
            out.println("<td>" + train.getArrivalStation() + "</td>");

            // Выводим информацию о типах билетов и их ценах
            out.println("<td>");
            for (Train.Ticket ticket : train.getTicketTypesAndPrices()) {
                out.println(ticket.getType() + ": " + ticket.getPrice() + "<br>");
            }
            out.println("</td>");

            out.println("<td>" + train.getArrivalDate() + "</td>");
            out.println("<td>" + train.getArrivalTime() + "</td>");
            out.println("</tr>");
        }
    %>
</table>
<br/>
<p>${message}</p>
<button class="my-button" onclick="document.location.href='/planes'">Самолеты</button>
<dialog id="type">
    <div class="dialog-title">Тип поезда</div>
    <div class="dialog-content">
        <p>Это описание типа поезда.</p>
        <p>Дополнительная информация о типе поезда.</p>
        <p id="move">${moveType}</p>
    </div>
    <div class="dialog-close">
        <button onclick="dialog.close()">Закрыть</button>
    </div>
</dialog>

<script src="https://www.google.com/jsapi"></script>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
