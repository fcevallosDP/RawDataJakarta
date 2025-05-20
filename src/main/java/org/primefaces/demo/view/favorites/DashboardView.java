/*
 *  Copyright 2009-2022 PrimeTek.
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.primefaces.demo.view.favorites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.elements.Elements;
import org.primefaces.model.charts.optionconfig.elements.ElementsPoint;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.tooltip.Tooltip;
import org.primefaces.demo.domain.Product;
import org.primefaces.demo.service.ProductService;

@Named
@ViewScoped
public class DashboardView implements Serializable {

    private List<Product> products;
    private List<Message> chatMessages;
    private String[] chatEmojis;
    private List<Event> chronolineEvents;

    private LineChartModel ordersChartModel;
    private LineChartModel overviewChartModel1;
    private LineChartModel overviewChartModel2;
    private LineChartModel overviewChartModel3;
    private LineChartModel overviewChartModel4;

    private String chatMessage = "";

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        products = this.service.getProducts();

        chatMessages = new ArrayList<>();
        chatMessages.add(new Message("Ioni Bowcher", "images/avatar/ionibowcher.png", new ArrayList<String>(Arrays.asList("Hey M. hope you are well.", "Our idea is accepted by the board. Now it's time to execute it"))));
        chatMessages.add(new Message(new ArrayList<String>(Arrays.asList("We did it! 🤠"))));
        chatMessages.add(new Message("Ioni Bowcher", "images/avatar/ionibowcher.png", new ArrayList<String>(Arrays.asList("That's really good!"))));
        chatMessages.add(new Message(Arrays.asList("But it's important to ship MVP ASAP")));
        chatMessages.add(new Message("Ioni Bowcher", "images/avatar/ionibowcher.png",new ArrayList<String>(Arrays.asList("I'll be looking at the process then, just to be sure 🤓"))));
        chatMessages.add(new Message(new ArrayList<String>(Arrays.asList("That's awesome. Thanks!"))));

        chatEmojis = new String[]{
            "😀", "😃", "😄", "😁", "😆", "😅", "😂", "🤣", "😇", "😉", "😊", "🙂", "🙃", "😋", "😌", "😍", "🥰", "😘", "😗", "😙", "😚", "🤪", "😜", "😝", "😛",
            "🤑", "😎", "🤓", "🧐", "🤠", "🥳", "🤗", "🤡", "😏", "😶", "😐", "😑", "😒", "🙄", "🤨", "🤔", "🤫", "🤭", "🤥", "😳", "😞", "😟", "😠", "😡", "🤬", "😔",
            "😟", "😠", "😡", "🤬", "😔", "😕", "🙁", "😬", "🥺", "😣", "😖", "😫", "😩", "🥱", "😤", "😮", "😱", "😨", "😰", "😯", "😦", "😧", "😢", "😥", "😪", "🤤"
        };

        chronolineEvents = new ArrayList<>();
        chronolineEvents.add(new Event("Ordered", "15/10/2020 10:30", "pi pi-shopping-cart", "#E91E63", "Richard Jones (C8012) has ordered a blue t-shirt for $79."));
        chronolineEvents.add(new Event("Processing", "15/10/2020 14:00", "pi pi-cog", "#FB8C00", "Order #99207 has processed succesfully."));
        chronolineEvents.add(new Event("Shipped", "15/10/2020 16:15", "pi pi-compass", "#673AB7", "Order #99207 has shipped with shipping code 2222302090."));
        chronolineEvents.add(new Event("Delivered", "16/10/2020 10:00", "pi pi-check-square", "#0097A7", "Richard Jones (C8012) has recieved his blue t-shirt."));

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");

        createOrdersChart(labels);
        createOverviewChart1(labels);
        createOverviewChart2(labels);
        createOverviewChart3(labels);
        createOverviewChart4(labels);
    }

    public void createOrdersChart(List<String> labels) {
        ordersChartModel = new LineChartModel();
        ChartData data = new ChartData();

        data.setLabels(labels);

        LineChartDataSet dataSet1 = new LineChartDataSet();
        List<Object> values1 = new ArrayList<>();
        values1.add(31);
        values1.add(83);
        values1.add(69);
        values1.add(29);
        values1.add(62);
        values1.add(25);
        values1.add(59);
        values1.add(26);
        values1.add(46);
        dataSet1.setData(values1);
        dataSet1.setLabel("New Orders");
        dataSet1.setFill(true);
        dataSet1.setBackgroundColor("rgba(77, 208, 225, 0.8)");
        dataSet1.setBorderWidth(2);
        dataSet1.setBorderColor("#4DD0E1");
        dataSet1.setTension(0.4);
        data.addChartDataSet(dataSet1);

        LineChartDataSet dataSet2 = new LineChartDataSet();
        List<Object> values2 = new ArrayList<>();
        values2.add(67);
        values2.add(98);
        values2.add(27);
        values2.add(88);
        values2.add(38);
        values2.add(3);
        values2.add(22);
        values2.add(60);
        values2.add(56);
        dataSet2.setData(values2);
        dataSet2.setLabel("Completed Orders");
        dataSet2.setFill(true);
        dataSet2.setBackgroundColor("rgba(63, 81, 181, 0.8)");
        dataSet2.setBorderWidth(2);
        dataSet2.setBorderColor("#3F51B5");
        dataSet2.setTension(0.4);
        data.addChartDataSet(dataSet2);

        ordersChartModel.setData(data);
        ordersChartModel.setExtender("ordersChartExtender");
    }

    public LineChartModel createOverviewChart(List<String> labels, List<Object> values) {
        LineChartModel overviewChartModel = new LineChartModel();
        ChartData data = new ChartData();

        data.setLabels(labels);

        LineChartDataSet dataSet = new LineChartDataSet();
        dataSet.setData(values);
        dataSet.setFill(true);
        dataSet.setBackgroundColor("rgba(77, 208, 225, 0.8)");
        dataSet.setBorderWidth(2);
        dataSet.setBorderColor("#4DD0E1");
        dataSet.setTension(0.4);
        data.addChartDataSet(dataSet);

        LineChartOptions options = new LineChartOptions();

        Legend legend = new Legend();
        legend.setDisplay(false);
        options.setLegend(legend);

        Tooltip tooltip = new Tooltip();
        tooltip.setEnabled(false);
        options.setTooltip(tooltip);

        Elements elements = new Elements();
        ElementsPoint point = new ElementsPoint();
        point.setRadius(0);
        elements.setPoint(point);
        options.setElements(elements);

        overviewChartModel.setOptions(options);
        overviewChartModel.setData(data);

        return overviewChartModel;
    }

    public void createOverviewChart1(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(50);
        values.add(64);
        values.add(32);
        values.add(24);
        values.add(18);
        values.add(27);
        values.add(20);
        values.add(36);
        values.add(30);

        overviewChartModel1 = createOverviewChart(labels, values);
        overviewChartModel1.setExtender("overviewChartExtender1");
    }

    public void createOverviewChart2(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(11);
        values.add(30);
        values.add(52);
        values.add(35);
        values.add(39);
        values.add(20);
        values.add(14);
        values.add(18);
        values.add(29);

        overviewChartModel2 = createOverviewChart(labels, values);
        overviewChartModel2.setExtender("overviewChartExtender2");
    }

    public void createOverviewChart3(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(20);
        values.add(29);
        values.add(39);
        values.add(36);
        values.add(45);
        values.add(24);
        values.add(28);
        values.add(20);
        values.add(15);

        overviewChartModel3 = createOverviewChart(labels, values);
        overviewChartModel3.setExtender("overviewChartExtender3");
    }

    public void createOverviewChart4(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(30);
        values.add(39);
        values.add(50);
        values.add(21);
        values.add(33);
        values.add(18);
        values.add(10);
        values.add(24);
        values.add(20);

        overviewChartModel4 = createOverviewChart(labels, values);
        overviewChartModel4.setExtender("overviewChartExtender4");
    }

    public void addEmoji(String emoji) {
        chatMessage += emoji;
    }

    public void addMessage() {
        Message lastMessage = chatMessages.get(chatMessages.size() - 1);

        if (lastMessage.from != null) {
            chatMessages.add(new Message(new ArrayList<String>(Arrays.asList(chatMessage))));
        }
        else {
            lastMessage.messages.add(chatMessage);
        }

        Pattern pattern = Pattern.compile("primeng|primereact|primefaces|primevue", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(chatMessage);
        if (matcher.find()) {
            chatMessages.add(new Message("Ioni Bowcher", "images/avatar/ionibowcher.png", new ArrayList<String>(Arrays.asList("Always bet on Prime!"))));
        }

        chatMessage = "";
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Message> getChatMessages() {
        return chatMessages;
    }

    public String[] getChatEmojis() {
        return chatEmojis;
    }

    public List<Event> getChronolineEvents() {
        return chronolineEvents;
    }

    public LineChartModel getOrdersChartModel() {
        return ordersChartModel;
    }

    public LineChartModel getOverviewChartModel1() {
        return overviewChartModel1;
    }

    public LineChartModel getOverviewChartModel2() {
        return overviewChartModel2;
    }

    public LineChartModel getOverviewChartModel3() {
        return overviewChartModel3;
    }

    public LineChartModel getOverviewChartModel4() {
        return overviewChartModel4;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public static class Event {

        private String status;
        private String date;
        private String icon;
        private String color;
        private String description;

        public Event() {
        }

        public Event(String status, String date, String icon, String color, String description) {
            this.status = status;
            this.date = date;
            this.icon = icon;
            this.color = color;
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Message {

        private String from;
        private String url;
        private List<String> messages;

        public Message() {
        }

        public Message(List<String> messages) {
            this.messages = messages;
        }

        public Message(String from, String url, List<String> messages) {
            this(messages);
            this.from = from;
            this.url = url;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMessages() {
            return messages;
        }

        public void setMessages(List<String> messages) {
            this.messages = messages;
        }
    }
}
