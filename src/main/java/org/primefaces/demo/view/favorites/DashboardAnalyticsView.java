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
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.donut.DonutChartDataSet;
import org.primefaces.model.charts.donut.DonutChartModel;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.demo.domain.Product;
import org.primefaces.demo.service.ProductService;

@Named
@ViewScoped
public class DashboardAnalyticsView implements Serializable {

    private List<Product> products;

    private BarChartModel monthlyChartModel;
    private DonutChartModel donutChartModel;
    private PieChartModel pieChartModel;

    private int storeADiff = 0;
    private int storeBDiff = 0;
    private int storeCDiff = 0;
    private int storeDDiff = 0;
    private int storeATotalValue = 100;
    private int storeBTotalValue = 120;
    private int storeCTotalValue = 150;
    private int storeDTotalValue = 80;

    private LineChartModel storeAModel;
    private LineChartModel storeBModel;
    private LineChartModel storeCModel;
    private LineChartModel storeDModel;

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        products = this.service.getProducts();

        createMonthlyChart();
        createDonutChart();
        createPieChart();

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

        createStoreAChart(labels);
        createStoreBChart(labels);
        createStoreCChart(labels);
        createStoreDChart(labels);
    }

    public void createMonthlyChart() {
        monthlyChartModel = new BarChartModel();
        ChartData data = new ChartData();

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);

        BarChartDataSet barDataSet1 = new BarChartDataSet();
        List<Number> values1 = new ArrayList<>();
        values1.add(6);
        values1.add(25);
        values1.add(97);
        values1.add(12);
        values1.add(7);
        values1.add(70);
        values1.add(42);
        barDataSet1.setLabel("2012");
        barDataSet1.setData(values1);
        barDataSet1.setBorderWidth(2);
        data.addChartDataSet(barDataSet1);

        BarChartDataSet barDataSet2 = new BarChartDataSet();
        List<Number> values2 = new ArrayList<>();
        values2.add(81);
        values2.add(3);
        values2.add(5);
        values2.add(11);
        values2.add(59);
        values2.add(47);
        values2.add(99);
        barDataSet2.setLabel("2013");
        barDataSet2.setData(values2);
        barDataSet2.setBorderWidth(2);
        data.addChartDataSet(barDataSet2);

        BarChartDataSet barDataSet3 = new BarChartDataSet();
        List<Number> values3 = new ArrayList<>();
        values3.add(68);
        values3.add(47);
        values3.add(46);
        values3.add(46);
        values3.add(61);
        values3.add(70);
        values3.add(94);
        barDataSet3.setLabel("2014");
        barDataSet3.setData(values3);
        barDataSet3.setBorderWidth(2);
        data.addChartDataSet(barDataSet3);

        BarChartDataSet barDataSet4 = new BarChartDataSet();
        List<Number> values4 = new ArrayList<>();
        values4.add(31);
        values4.add(9);
        values4.add(18);
        values4.add(76);
        values4.add(6);
        values4.add(11);
        values4.add(79);
        barDataSet4.setLabel("2015");
        barDataSet4.setData(values4);
        barDataSet4.setBorderWidth(2);
        data.addChartDataSet(barDataSet4);

        BarChartDataSet barDataSet5 = new BarChartDataSet();
        List<Number> values5 = new ArrayList<>();
        values5.add(85);
        values5.add(37);
        values5.add(47);
        values5.add(29);
        values5.add(2);
        values5.add(10);
        values5.add(54);
        barDataSet5.setLabel("2016");
        barDataSet5.setData(values5);
        barDataSet5.setBorderWidth(2);
        data.addChartDataSet(barDataSet5);

        BarChartDataSet barDataSet6 = new BarChartDataSet();
        List<Number> values6 = new ArrayList<>();
        values6.add(28);
        values6.add(48);
        values6.add(40);
        values6.add(19);
        values6.add(86);
        values6.add(27);
        values6.add(90);
        barDataSet6.setLabel("2017");
        barDataSet6.setData(values6);
        barDataSet6.setBorderWidth(2);
        data.addChartDataSet(barDataSet6);

        BarChartDataSet barDataSet7 = new BarChartDataSet();
        List<Number> values7 = new ArrayList<>();
        values7.add(89);
        values7.add(18);
        values7.add(95);
        values7.add(18);
        values7.add(97);
        values7.add(61);
        values7.add(54);
        barDataSet7.setLabel("2018");
        barDataSet7.setData(values7);
        barDataSet7.setBorderWidth(2);
        data.addChartDataSet(barDataSet7);

        BarChartDataSet barDataSet8 = new BarChartDataSet();
        List<Number> values8 = new ArrayList<>();
        values8.add(18);
        values8.add(36);
        values8.add(39);
        values8.add(58);
        values8.add(41);
        values8.add(50);
        values8.add(72);
        barDataSet8.setLabel("2019");
        barDataSet8.setData(values8);
        barDataSet8.setBorderWidth(2);
        data.addChartDataSet(barDataSet8);

        BarChartDataSet barDataSet9 = new BarChartDataSet();
        List<Number> values9 = new ArrayList<>();
        values9.add(31);
        values9.add(4);
        values9.add(35);
        values9.add(74);
        values9.add(47);
        values9.add(35);
        values9.add(46);
        barDataSet9.setLabel("2020");
        barDataSet9.setData(values9);
        barDataSet9.setBorderWidth(2);
        data.addChartDataSet(barDataSet9);

        monthlyChartModel.setData(data);
        monthlyChartModel.setExtender("monthlyChartExtender");
    }

    public void createDonutChart() {
        donutChartModel = new DonutChartModel();
        ChartData data = new ChartData();

        DonutChartDataSet dataSet = new DonutChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(11);
        values.add(29);
        values.add(71);
        values.add(33);
        values.add(28);
        values.add(95);
        values.add(6);
        dataSet.setData(values);
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("Sunday");
        labels.add("Monday");
        labels.add("Tuesday");
        labels.add("Wednesday");
        labels.add("Thursday");
        labels.add("Friday");
        labels.add("Saturday");
        data.setLabels(labels);

        donutChartModel.setData(data);
        donutChartModel.setExtender("donutChartExtender");
    }

    public void createPieChart() {
        pieChartModel = new PieChartModel();
        ChartData data = new ChartData();

        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(300);
        values.add(50);
        values.add(100);
        dataSet.setData(values);
        data.addChartDataSet(dataSet);

        List<String> labels = new ArrayList<>();
        labels.add("O");
        labels.add("D");
        labels.add("R");
        data.setLabels(labels);

        pieChartModel.setData(data);
        pieChartModel.setExtender("pieChartExtender");
    }

    public LineChartModel createStoreChart(List<String> labels, List<Object> values) {
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

        overviewChartModel.setData(data);

        return overviewChartModel;
    }

    public void createStoreAChart(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(55);
        values.add(3);
        values.add(45);
        values.add(6);
        values.add(44);
        values.add(58);
        values.add(84);
        values.add(68);
        values.add(64);

        storeAModel = createStoreChart(labels, values);
        storeAModel.setExtender("storeAChartExtender");
    }

    public void createStoreBChart(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(81);
        values.add(75);
        values.add(63);
        values.add(100);
        values.add(69);
        values.add(79);
        values.add(38);
        values.add(37);
        values.add(76);

        storeBModel = createStoreChart(labels, values);
        storeBModel.setExtender("storeBChartExtender");
    }

    public void createStoreCChart(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(99);
        values.add(55);
        values.add(22);
        values.add(72);
        values.add(24);
        values.add(79);
        values.add(35);
        values.add(91);
        values.add(48);

        storeCModel = createStoreChart(labels, values);
        storeCModel.setExtender("storeCChartExtender");
    }

    public void createStoreDChart(List<String> labels) {
        List<Object> values = new ArrayList<>();
        values.add(5);
        values.add(51);
        values.add(68);
        values.add(82);
        values.add(28);
        values.add(21);
        values.add(29);
        values.add(45);
        values.add(44);

        storeDModel = createStoreChart(labels, values);
        storeDModel.setExtender("storeDChartExtender");
    }

    public void calculateStore() {
        // A
        int randomNumber = (int)(Math.random() * 100 + 1);
        ChartData data = storeAModel.getData();
        LineChartDataSet dataSet = (LineChartDataSet)data.getDataSet().get(0);
        List<Object> values = dataSet.getData();

        storeADiff = randomNumber - (int)values.get(values.size() - 1);
        storeATotalValue += storeADiff;
        values.remove(0);
        values.add(randomNumber);

        // B
        randomNumber = (int)(Math.random() * 100 + 1);
        data = storeBModel.getData();
        dataSet = (LineChartDataSet)data.getDataSet().get(0);
        values = dataSet.getData();

        storeBDiff = randomNumber - (int)values.get(values.size() - 1);
        storeBTotalValue += storeBDiff;
        values.remove(0);
        values.add(randomNumber);

        // C
        randomNumber = (int)(Math.random() * 100 + 1);
        data = storeCModel.getData();
        dataSet = (LineChartDataSet)data.getDataSet().get(0);
        values = dataSet.getData();

        storeCDiff = randomNumber - (int)values.get(values.size() - 1);
        storeCTotalValue += storeCDiff;
        values.remove(0);
        values.add(randomNumber);

        // D
        randomNumber = (int)(Math.random() * 100 + 1);
        data = storeDModel.getData();
        dataSet = (LineChartDataSet)data.getDataSet().get(0);
        values = dataSet.getData();

        storeDDiff = randomNumber - (int)values.get(values.size() - 1);
        storeDTotalValue += storeDDiff;
        values.remove(0);
        values.add(randomNumber);
    }

    public List<Product> getProducts() {
        return products;
    }

    public BarChartModel getMonthlyChartModel() {
        return monthlyChartModel;
    }

    public DonutChartModel getDonutChartModel() {
        return donutChartModel;
    }

    public PieChartModel getPieChartModel() {
        return pieChartModel;
    }

    public int getStoreADiff() {
        return storeADiff;
    }

    public void setStoreADiff(int storeADiff) {
        this.storeADiff = storeADiff;
    }

    public int getStoreBDiff() {
        return storeBDiff;
    }

    public void setStoreBDiff(int storeBDiff) {
        this.storeBDiff = storeBDiff;
    }

    public int getStoreCDiff() {
        return storeCDiff;
    }

    public void setStoreCDiff(int storeCDiff) {
        this.storeCDiff = storeCDiff;
    }

    public int getStoreDDiff() {
        return storeDDiff;
    }

    public void setStoreDDiff(int storeDDiff) {
        this.storeDDiff = storeDDiff;
    }

    public int getStoreATotalValue() {
        return storeATotalValue;
    }

    public void setStoreATotalValue(int storeATotalValue) {
        this.storeATotalValue = storeATotalValue;
    }

    public int getStoreBTotalValue() {
        return storeBTotalValue;
    }

    public void setStoreBTotalValue(int storeBTotalValue) {
        this.storeBTotalValue = storeBTotalValue;
    }

    public int getStoreCTotalValue() {
        return storeCTotalValue;
    }

    public void setStoreCTotalValue(int storeCTotalValue) {
        this.storeCTotalValue = storeCTotalValue;
    }

    public int getStoreDTotalValue() {
        return storeDTotalValue;
    }

    public void setStoreDTotalValue(int storeDTotalValue) {
        this.storeDTotalValue = storeDTotalValue;
    }

    public LineChartModel getStoreAModel() {
        return storeAModel;
    }

    public LineChartModel getStoreBModel() {
        return storeBModel;
    }

    public LineChartModel getStoreCModel() {
        return storeCModel;
    }

    public LineChartModel getStoreDModel() {
        return storeDModel;
    }
}
