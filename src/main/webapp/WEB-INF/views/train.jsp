<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.patterns.data.main.animalsXML.Train" %>
<%@ page import="com.example.patterns.data.main.GetTrainsImpl" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.Set" %>
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
    <link rel="stylesheet" type="text/css" href="css/Header.css">
    <link rel="stylesheet" type="text/css" href="css/Dialog.css">
    <link rel="stylesheet" type="text/css" href="css/Form.css">
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
<header class="header">
    <h1 class="header-title">Trains Schedule</h1>
    <nav class="header-nav">
        <ul class="header-nav-list">
            <li class="header-nav-item"><a href="home" class="header-nav-link">Домой</a></li>
            <li class="header-nav-item"><a href="planes" class="header-nav-link">Самолеты</a></li>
            <li class="header-nav-item"><a href="trains" class="header-nav-link">Поезда</a></li>
            <li class="header-nav-item"><a href="buses" class="header-nav-link">Автобусы</a></li>
        </ul>
    </nav>
</header>
<form id="filter-form" method="GET" action="trains">
    <div class="form-group">
        <label for="departure">Пункт отправления:</label>
        <select name="departure" id="departure">
            <%-- Создаем уникальный список пунктов отправления --%>
            <% Set<String> departureSet = new HashSet<>(); %>
            <% for (Train train : trains) {
                departureSet.add(train.getDepartureStation());
            } %>
            <%-- Добавляем варианты пунктов отправления в элемент <select> --%>
            <% for (String departure : departureSet) { %>
            <option value="<%= departure %>"><%= departure %></option>
            <% } %>
        </select>
    </div>

    <div class="form-group">
        <label for="destination">Пункт прибытия:</label>
        <select name="destination" id="destination">
            <%-- Создаем уникальный список пунктов прибытия --%>
            <% Set<String> destinationSet = new HashSet<>(); %>
            <% for (Train train : trains) {
                destinationSet.add(train.getArrivalStation());
            } %>
            <%-- Добавляем варианты пунктов прибытия в элемент <select> --%>
            <% for (String destination : destinationSet) { %>
            <option value="<%= destination %>"><%= destination %></option>
            <% } %>
        </select>
    </div>

    <div class="form-group">
        <label for="start_date">Дата отправления:</label>
        <input type="date" name="start_date" id="start_date">
    </div>

    <button type="submit">Применить фильтры</button>
    <a href="trains" class="cancel-link">Отменить фильтры</a>
</form>
<table border="4" cellspacing="2">
    <thead>
    <tr>
        <th>Номер поезда</th>
        <th>Дата отправления</th>
        <th>Время отправления</th>
        <th>Пункт назначения</th>
        <th>Станция отправления</th>
        <th>Платформа отправления</th>
        <th>Станция прибытия</th>
        <th>Типы билетов и цены</th>
        <th>Дата прибытия</th>
        <th>Время прибытия</th>
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
<dialog id="type">
    <div class="dialog-title">Тип поезда</div>
    <div class="dialog-content">
        <p id="move">${moveType}</p>
    </div>
    <div class="dialog-close">
        <button onclick="dialog.close()">Закрыть</button>
    </div>
</dialog>

<script>
    // Функция для обработки события отправки формы
    function handleFormSubmit(event) {
        event.preventDefault(); // Предотвращаем отправку формы

        // Получаем значения полей формы
        var departure = document.getElementById('departure').value;
        var destination = document.getElementById('destination').value;
        var startDate = document.getElementById('start_date').value;

        // Фильтруем таблицу по значениям полей формы
        filterTable(departure, destination, startDate);
    }

    // Функция для фильтрации таблицы
    function filterTable(departure, destination, startDate) {
        console.log(departure + " " + destination + " " + startDate);
        // Получаем все строки таблицы
        var rows = document.getElementsByTagName('tr');

        // Проходимся по каждой строке и скрываем те, которые не удовлетворяют условиям фильтра
        for (var i = 1; i < rows.length; i++) { // Начинаем с 1, чтобы пропустить заголовок таблицы
            var row = rows[i];
            var departureCell = row.cells[4].textContent; // Станция отправления
            var destinationCell = row.cells[6].textContent; // Станция прибытия
            var startDateCell = row.cells[1].textContent; // Дата отправления

            // Проверяем условия фильтрации
            var shouldShowRow =
                (departure === '' || departureCell === departure) &&
                (destination === '' || destinationCell === destination) &&
                (startDate === '' || startDateCell === startDate);

            // Показываем или скрываем строку в зависимости от результата фильтрации
            row.style.display = shouldShowRow ? '' : 'none';
        }
    }

    // Назначаем обработчик события отправки формы
    var form = document.getElementById('filter-form');
    form.addEventListener('submit', handleFormSubmit);
</script>

<script src="https://www.google.com/jsapi"></script>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
<p>${message}</p>
</body>
</html>
