package com.dp.controller;

import com.dp.entity.TblTypeSources;
import com.dp.facade.TblTypeSourcesFacade;
import com.dp.facade.util.JsfUtil;
import com.dp.util.DAOFile;
import com.dp.util.TblBudgetTracker;
import com.dp.util.TblDV360SPD;
import com.dp.util.TblDailyProcess;
import com.dp.util.TblCatalogo;
import com.dp.util.TblHistoricalDSP;
import com.dp.util.TblLineItems;
import com.dp.util.TblPacing;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.util.Arrays;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.util.LangUtils;
import com.google.gson.Gson;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Named("tblRawDataController")
@ViewScoped
public class TblRawDataController implements Serializable {
    private List<TblDV360SPD> items = null;
    private List<TblDV360SPD> itemsPerf = null;
    private List<TblDV360SPD> itemsPerfSummary = null;
    private List<TblDV360SPD> monthlyItems = null;
    private List<TblDV360SPD> filteredItems = null;    
    private List<TblHistoricalDSP> historicalItems = null;
    private List<TblPacing> pacingItems = null;
    private List<TblBudgetTracker> budgetTrackerItems = null;
    private List<TblBudgetTracker> budgetTrackerSummary = null;
    private List<TblBudgetTracker> bTrackerSummaryIO = null;
    private boolean lbChartExpandedIO = false;
    private List<TblBudgetTracker> bTrackerSummaryCA = null;
    private boolean lbChartExpandedCA = false;
    private List<TblBudgetTracker> bTrackerSummaryCH = null;
    private boolean lbChartExpandedCH = false;
    private List<TblBudgetTracker> bTrackerSummaryAD = null;                
    private boolean lbChartExpandedAD = false;
    private List<TblLineItems> spendLineItems = null;
    private TblBudgetTracker budgetSelected;
    private TblDV360SPD selected;
    private TblDV360SPD selectedPerf;
    private TblDV360SPD selectedPerfSummary;
    private Date dDateSelected;
    private Date dMonthSelected;    
    private Date maxDate;    
    private TblDailyProcess idDailySelected;
    private Boolean lbDataFound;
    private Boolean lbDataTransfer;
    private TblCatalogo editCatalog;
    private List<TblTypeSources> itemsTypes = null;    
    private boolean globalFilterOnly = true;
    
    private String todayAsString;
    private String vPartnerSelected;
    private String vInitialCampaign;
    private String vCampaignSelected = "";
    private String vIOSelected = "";
    private String vOptionSummary = "vChannel, vCampaign";
    private String vPerfSummary = "vAdvertiser, vCampaign";
    private List<TblCatalogo> itemsCatalogo = null;
    private List<String> itemsVPartners = null;
    private List<String> rawColumns;
    private List<String> rawPartners;
    private List<String> rawExchanges;
    private List<String> rawDeviceTypes;
    private List<String> rawCampaign;
    private List<String> rawDsp;
    private List<String> rawClient;
    private List<String> rawAgency;
    private List<String> rawChannel;
    private List<String> rawVendor;
    private List<String> rawLineItems;
    private List<String> rawInsertionOrders;
    private String[] selectedrawColumns;   
    private Integer iYear;
    private Integer iMonth;
    private Integer iWeek;
    private Integer iShowQtyRows;
    private Integer iUnderPacingOrange;
    private Integer iUnderpacingRed;
    public static Random numGen =new Random();
    private HorizontalBarChartModel hbarModelCH = new HorizontalBarChartModel();
    private HorizontalBarChartModel hbarModel = new HorizontalBarChartModel();
    private HorizontalBarChartModel hbarModelC = new HorizontalBarChartModel();
    private HorizontalBarChartModel hbarModelI = new HorizontalBarChartModel();
    private BarChartModel barModelCA = new BarChartModel();
    private BarChartModel barModelIO = new BarChartModel();
    private BarChartModel barModelAD = new BarChartModel();
    private List<BarChartModel> barCampaignItems = new ArrayList<>();
    
    private final Map<String, List<String>> labelsMap = new HashMap<>();
    private final Map<String, List<Number>> valoresMap = new HashMap<>();

    public List<BarChartModel> getBarCampaignItems() {
        return barCampaignItems;
    }

    public void setBarCampaignItems(List<BarChartModel> barCampaignItems) {
        this.barCampaignItems = barCampaignItems;
    }    
    
    public HorizontalBarChartModel getHbarModelCH() {
        return hbarModelCH;
    }

    public List<String> getRawDeviceTypes() {
        return rawDeviceTypes;
    }

    public String getvPerfSummary() {
        return vPerfSummary;
    }

    public Integer getiWeek() {
        return iWeek;
    }

    public void setiWeek(Integer iWeek) {
        this.iWeek = iWeek;
    }

    public void setvPerfSummary(String vPerfSummary) {
        this.vPerfSummary = vPerfSummary;
    }

    public TblDV360SPD getSelectedPerfSummary() {
        return selectedPerfSummary;
    }

    public void setSelectedPerfSummary(TblDV360SPD selectedPerfSummary) {
        this.selectedPerfSummary = selectedPerfSummary;
    }

    public void setRawDeviceTypes(List<String> rawDeviceTypes) {
        this.rawDeviceTypes = rawDeviceTypes;
    }

    public boolean isLbChartExpandedIO() {
        return lbChartExpandedIO;
    }

    public void setLbChartExpandedIO(boolean lbChartExpandedIO) {
        this.lbChartExpandedIO = lbChartExpandedIO;
    }

    public boolean isLbChartExpandedCA() {
        return lbChartExpandedCA;
    }

    public List<TblDV360SPD> getItemsPerfSummary() {
        return itemsPerfSummary;
    }

    public void setItemsPerfSummary(List<TblDV360SPD> itemsPerfSummary) {
        this.itemsPerfSummary = itemsPerfSummary;
    }

    public TblDV360SPD getSelectedPerf() {
        return selectedPerf;
    }

    public void setSelectedPerf(TblDV360SPD selectedperf) {
        this.selectedPerf = selectedperf;
    }

    public void setLbChartExpandedCA(boolean lbChartExpandedCA) {
        this.lbChartExpandedCA = lbChartExpandedCA;
    }

    public String getvIOSelected() {
        return vIOSelected;
    }

    public List<TblDV360SPD> getItemsPerf() {
        if(itemsPerf == null || itemsPerf.isEmpty()){
            getItemPerfByMonthYear();
        }
        return itemsPerf;
    }

    public void setItemsPerf(List<TblDV360SPD> itemsPerf) {
        this.itemsPerf = itemsPerf;
    }

    public void setvIOSelected(String vIOSelected) {
        this.vIOSelected = vIOSelected;
    }

    public Integer getiUnderPacingOrange() {
        return iUnderPacingOrange;
    }

    public void setiUnderPacingOrange(Integer iUnderPacingOrange) {
        this.iUnderPacingOrange = iUnderPacingOrange;
    }

    public Integer getiUnderpacingRed() {
        return iUnderpacingRed;
    }

    public void setiUnderpacingRed(Integer iUnderpacingRed) {
        this.iUnderpacingRed = iUnderpacingRed;
    }

    public boolean isLbChartExpandedCH() {
        return lbChartExpandedCH;
    }

    public void setLbChartExpandedCH(boolean lbChartExpandedCH) {
        this.lbChartExpandedCH = lbChartExpandedCH;
    }

    public boolean isLbChartExpandedAD() {
        return lbChartExpandedAD;
    }

    public void setLbChartExpandedAD(boolean lbChartExpandedAD) {
        this.lbChartExpandedAD = lbChartExpandedAD;
    }

    public List<TblBudgetTracker> getbTrackerSummaryIO() {
        return bTrackerSummaryIO;
    }

    public void setbTrackerSummaryIO(List<TblBudgetTracker> bTrackerSummaryIO) {
        this.bTrackerSummaryIO = bTrackerSummaryIO;
    }

    public List<TblBudgetTracker> getbTrackerSummaryCA() {
        return bTrackerSummaryCA;
    }

    public String getvCampaignSelected() {
        return vCampaignSelected;
    }

    public void setvCampaignSelected(String vCampaignSelected) {
        this.vCampaignSelected = vCampaignSelected;
    }

    public void viewCampaign() {
        vCampaignSelected = (budgetSelected != null) ? budgetSelected.getvCampaign() : "";
    }    

    public void viewIO() {
        vIOSelected = (budgetSelected != null) ? budgetSelected.getvInsertionOrder() : "";
    }  
    
    public void setbTrackerSummaryCA(List<TblBudgetTracker> bTrackerSummaryCA) {
        this.bTrackerSummaryCA = bTrackerSummaryCA;
    }

    public List<TblBudgetTracker> getbTrackerSummaryCH() {
        return bTrackerSummaryCH;
    }

    public void setbTrackerSummaryCH(List<TblBudgetTracker> bTrackerSummaryCH) {
        this.bTrackerSummaryCH = bTrackerSummaryCH;
    }

    public List<TblBudgetTracker> getbTrackerSummaryAD() {
        return bTrackerSummaryAD;
    }

    public void setbTrackerSummaryAD(List<TblBudgetTracker> bTrackerSummaryAD) {
        this.bTrackerSummaryAD = bTrackerSummaryAD;
    }

    public void setHbarModelCH(HorizontalBarChartModel hbarModelCH) {
        this.hbarModelCH = hbarModelCH;
    }

    protected void getiShowQtyRows() {   
        DAOFile dbCon = new DAOFile();
        iShowQtyRows = dbCon.getQtyParameter("%QTY%ROWS%IO%");                
    }

    protected void getParamOrange() {   
        DAOFile dbCon = new DAOFile();
        iUnderPacingOrange = dbCon.getQtyParameter("%PCT%Underpacing%Orange%");                
    }    
    
    protected void getParamRed() {   
        DAOFile dbCon = new DAOFile();
        iUnderpacingRed = dbCon.getQtyParameter("%PCT%Underpacing%Red%");                
    }    
    
    public TblRawDataController() {
        internalLimpiar();
        getiShowQtyRows();
        getParamOrange();
        getParamRed();
        getDateBounds();
        getItemCalendarByDate();        
        getItemsCatalogo();
        getRawColumnsBySource();        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        todayAsString = df.format(JsfUtil.getFechaSistema().getTime());               
    }

    public void createHorizontalBarModelChannel(List<TblBudgetTracker> bTrackerSummaryCH){
        if( bTrackerSummaryCH != null && !bTrackerSummaryCH.isEmpty()){
            List<Number> values = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            lbChartExpandedCH = (bTrackerSummaryCH.size() > iShowQtyRows);

            for (TblBudgetTracker itemTracker : bTrackerSummaryCH) {
                Double ldValor = new BigDecimal(itemTracker.getdBudgetPacing() * 100.00).setScale(2, RoundingMode.HALF_UP).doubleValue();
                values.add(ldValor);
                labels.add(itemTracker.getvChannel());
            }        

            if(lbChartExpandedCH){
                labelsMap.put("barChartCH", IntStream.rangeClosed(1, 20)
                    .mapToObj(i -> "Etiqueta " + i)
                    .collect(Collectors.toList()));

                valoresMap.put("barChartCH", IntStream.rangeClosed(1, 20)
                    .map(i -> new Random().nextInt(100))
                    .boxed()
                    .collect(Collectors.toList()));             
            }else{
                labelsMap.put("barChartCH", labels);
                valoresMap.put("barChartCH", values);              
            }            
        }
        
    }
    public void createHorizontalBarModelInsertionOrder(List<TblBudgetTracker> bTrackerSummaryIO){
        if( bTrackerSummaryIO != null && !bTrackerSummaryIO.isEmpty()){        
            List<Number> values = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            lbChartExpandedIO = (bTrackerSummaryIO.size() > iShowQtyRows);

            for (TblBudgetTracker itemTracker : bTrackerSummaryIO) {
                Double ldValor = new BigDecimal(itemTracker.getdBudgetPacing() * 100.00).setScale(2, RoundingMode.HALF_UP).doubleValue();
                values.add(ldValor);            
                labels.add(itemTracker.getvInsertionOrder());
            }

            /*if(lbChartExpandedIO){
                labelsMap.put("barChartIO", IntStream.rangeClosed(1, 20)
                    .mapToObj(i -> "Etiqueta " + i)
                    .collect(Collectors.toList()));

                valoresMap.put("barChartIO", IntStream.rangeClosed(1, 20)
                    .map(i -> new Random().nextInt(100))
                    .boxed()
                    .collect(Collectors.toList()));             
            }else{*/
                labelsMap.put("barChartIO", labels);
                valoresMap.put("barChartIO", values);              
            //}
        }
    }
    public void createHorizontalBarModelCampaign(List<TblBudgetTracker> bTrackerSummaryCA){
        if( bTrackerSummaryCA != null && !bTrackerSummaryCA.isEmpty()){
            List<Number> values = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            lbChartExpandedCA = (bTrackerSummaryCA.size() > iShowQtyRows);

            for (TblBudgetTracker itemTracker : bTrackerSummaryCA) {
                Double ldValor = new BigDecimal(itemTracker.getdBudgetPacing() * 100.00).setScale(2, RoundingMode.HALF_UP).doubleValue();
                values.add(ldValor);
                labels.add(itemTracker.getvCampaign());
            }        

            if(lbChartExpandedCA){
                labelsMap.put("barChartCP", IntStream.rangeClosed(1, 20)
                    .mapToObj(i -> "Etiqueta " + i)
                    .collect(Collectors.toList()));

                valoresMap.put("barChartCP", IntStream.rangeClosed(1, 20)
                    .map(i -> new Random().nextInt(100))
                    .boxed()
                    .collect(Collectors.toList()));             
            }else{
                labelsMap.put("barChartCP", labels);
                valoresMap.put("barChartCP", values);              
            }                    
        }        
    }
    public void createHorizontalBarModel(List<TblBudgetTracker> bTrackerSummaryAD){
        if( bTrackerSummaryAD != null && !bTrackerSummaryAD.isEmpty()){
            List<Number> values = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            lbChartExpandedAD = (bTrackerSummaryAD.size() > iShowQtyRows);

            for (TblBudgetTracker itemTracker : bTrackerSummaryAD) {
                Double ldValor = new BigDecimal(itemTracker.getdBudgetPacing() * 100.00).setScale(2, RoundingMode.HALF_UP).doubleValue();
                values.add(ldValor);
                labels.add(itemTracker.getvClient());
            }        
            if(lbChartExpandedAD){
                labelsMap.put("barChartAD", IntStream.rangeClosed(1, 20)
                    .mapToObj(i -> "Etiqueta " + i)
                    .collect(Collectors.toList()));

                valoresMap.put("barChartAD", IntStream.rangeClosed(1, 20)
                    .map(i -> new Random().nextInt(100))
                    .boxed()
                    .collect(Collectors.toList()));             
            }else{
                labelsMap.put("barChartAD", labels);
                valoresMap.put("barChartAD", values);              
            }                    

        }
    }                       
    
    public HorizontalBarChartModel getHbarModelC() {
        return hbarModelC;
    }

    public void setHbarModelC(HorizontalBarChartModel hbarModelC) {
        this.hbarModelC = hbarModelC;
    }

    public HorizontalBarChartModel getHbarModel() {
        return hbarModel;
    }

    public HorizontalBarChartModel getHbarModelI() {
        return hbarModelI;
    }

    public void setHbarModelI(HorizontalBarChartModel hbarModelI) {
        this.hbarModelI = hbarModelI;
    }

    public List<String> getRawLineItems() {
        return rawLineItems;
    }

    public List<TblBudgetTracker> getBudgetTrackerItems() {
        return budgetTrackerItems;        
    }

    public String getvInitialCampaign() {
        return vInitialCampaign;
    }

    public void setvInitialCampaign(String vInitialCampaign) {
        this.vInitialCampaign = vInitialCampaign;
    }

    public List<String> getItemsVPartners() {
        if(itemsVPartners == null || itemsVPartners.isEmpty()){
            DAOFile dbCon = new DAOFile();
            itemsVPartners = dbCon.getVPartnersFromBudgetTracker(JsfUtil.getUsuarioSesion().getvAgency());
        }        
        return itemsVPartners;
    }

    public void setItemsVPartners(List<String> itemsVPartners) {
        this.itemsVPartners = itemsVPartners;
    }

    public void setBudgetTrackerItems(List<TblBudgetTracker> budgetTrackerItems) {
        this.budgetTrackerItems = budgetTrackerItems;
    }

    public void setRawLineItems(List<String> rawLineItems) {
        this.rawLineItems = rawLineItems;
    }

    public List<String> getRawInsertionOrders() {
        return rawInsertionOrders;
    }

    public void setRawInsertionOrders(List<String> rawInsertionOrders) {
        this.rawInsertionOrders = rawInsertionOrders;
    }

    public Integer getIYear() {
        return iYear;
    }

    public void setIYear(Integer iYear) {
        this.iYear = iYear;
    }

    public Integer getIMonth() {
        return iMonth;
    }

    public void setIMonth(Integer iMonth) {
        this.iMonth = iMonth;
    }

    public Double getTotalSpendLineItems() {
        return spendLineItems.stream().map(TblLineItems::getdSpendYesterday).reduce(Double.valueOf(0), Double::sum);
    }    
        
    public Double getTotalBudget(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).map(TblBudgetTracker::getdBudget).reduce(Double.valueOf(0), Double::sum);
    }    
    
    public Double getTotalBudgetGrouped(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvChannel())).map(TblBudgetTracker::getdBudget).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getTotalPerfCPMGrouped(String name){ 
        return itemsPerf.stream().filter(customer -> name.equals(customer.getvClient())).map(TblDV360SPD::getdRevenueCPM).reduce(Double.valueOf(0), Double::sum);
    }    
    public Integer getTotalPerfImpGrouped(String name){ 
        return itemsPerf.stream().filter(customer -> name.equals(customer.getvClient())).map(TblDV360SPD::getiImpressions).reduce(0, Integer::sum);
    }    
    public Integer getTotalPerfCliGrouped(String name){ 
        return itemsPerf.stream().filter(customer -> name.equals(customer.getvClient())).map(TblDV360SPD::getiClicks).reduce(0, Integer::sum);
    }    

    public Double getTotalPerfCPMByAgency() {
        return itemsPerf.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblDV360SPD::getdRevenueCPM).reduce(Double.valueOf(0), Double::sum);
    }        

    public Integer getTotalPerfImpByAgency() {
        return itemsPerf.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblDV360SPD::getiImpressions).reduce(0, Integer::sum);
    }        

    public Integer getTotalPerfCliByAgency() {
        return itemsPerf.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblDV360SPD::getiClicks).reduce(0, Integer::sum);
    }        

    
    public Double getTotaldProjBudgPercGrouped(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvChannel())).map(TblBudgetTracker::getdProjBudgPerc).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getTotaldBudgetPacingGrouped(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvChannel())).map(TblBudgetTracker::getdBudgetPacing).reduce(Double.valueOf(0), Double::sum);
    }    
    
    public Double getTotalBudgetByAgency() {
        return budgetTrackerSummary.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblBudgetTracker::getdBudget).reduce(Double.valueOf(0), Double::sum);
    }        

    public Double getTotaldProjBudgPercByAgency() {
        return budgetTrackerSummary.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblBudgetTracker::getdProjBudgPerc).reduce(Double.valueOf(0), Double::sum);
    }        

    public Double getTotaldBudgetPacingByAgency() {
        return budgetTrackerSummary.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblBudgetTracker::getdBudgetPacing).reduce(Double.valueOf(0), Double::sum);
    }        
    
    public Double getTotalBudgetGroupedPartner(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvPartner())).map(TblBudgetTracker::getdBudget).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getTotalBalance(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).map(TblBudgetTracker::getdBalance).reduce(Double.valueOf(0), Double::sum);
    }      
    
    public Double getTotalBalanceGrouped(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvChannel())).map(TblBudgetTracker::getdBalance).reduce(Double.valueOf(0), Double::sum);
    }      

    public Double getTotalBalanceByAgency() {
        return budgetTrackerSummary.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblBudgetTracker::getdBalance).reduce(Double.valueOf(0), Double::sum);
    }          
    
    public Double getTotalBalanceGroupedPartner(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvPartner())).map(TblBudgetTracker::getdBalance).reduce(Double.valueOf(0), Double::sum);
    }      

    public void onTabChange(TabChangeEvent event){ 
        vOptionSummary = (event.getTab().getTitle().contains("Campaign")) ? "vChannel, vCampaign" : (event.getTab().getTitle().contains("Channel") ? "vChannel" : "vClient");
        getDataBudgetTrackerSumary();
    }        
    
    public void onTabPerfChange(TabChangeEvent event) {
        if (event.getTab().getTitle().contains("Campaign")){
            vPerfSummary = "vAdvertiser, vCampaign";
            getDataPerGoals();
        }else if(event.getTab().getTitle().contains("InsertionOrder")){
            vPerfSummary = "vAdvertiser, vCampaign, vInsertionOrder";
            getDataPerfSumary();
        }else{
            vPerfSummary = "vAdvertiser";
            getDataPerfSumary();
        }
    }      

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, null);
    }    
    
    public Double getTotalMediaSpend(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).map(TblBudgetTracker::getdMediaSpend).reduce(Double.valueOf(0), Double::sum);
    }        
    
    public Double getTotalMediaSpendGrouped(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvChannel())).map(TblBudgetTracker::getdMediaSpend).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getPacingPercentGrouped(String name) {
        Double ldBudget = getTotalBudgetGrouped(name);
        Double ldSpend = getTotalMediaSpendGrouped(name);
        return (ldBudget > 0) ? (ldSpend / ldBudget) : 0.00;        
    }        

    public Double getPacingPercentByAgency() {
        Double ldBudget = getTotalBudgetByAgency();
        Double ldSpend = getTotalMediaSpendByAgency();
        return (ldBudget > 0) ? (ldSpend / ldBudget) : 0.00;        
    }        
    
    public Double getTotalMediaSpendByAgency() {
        return budgetTrackerSummary.stream().filter(customer -> vPartnerSelected.equals(customer.getvAgency())).map(TblBudgetTracker::getdMediaSpend).reduce(Double.valueOf(0), Double::sum);
    }    
    
    public Double getTotalMediaSpendGroupedPartner(String name) {
        return budgetTrackerSummary.stream().filter(customer -> name.equals(customer.getvPartner())).map(TblBudgetTracker::getdMediaSpend).reduce(Double.valueOf(0), Double::sum);
    }    
    
    public List<TblLineItems> getSpendLineItems() {
        return spendLineItems;
    }

    public void setSpendLineItems(List<TblLineItems> spendLineItems) {
        this.spendLineItems = spendLineItems;
    }

    public String getvPartnerSelected() {
        return vPartnerSelected;
    }

    public void setvPartnerSelected(String vPartnerSelected) {
        this.vPartnerSelected = vPartnerSelected;
    }

    
    public Double getTotalBudgetPacing(String name){
        Double totBudget = getTotalBudget(name);
        Double totSpend = getTotalMediaSpend(name);   
        Double totPerc = (totBudget > 0) ? (totSpend / totBudget) : 0.00;        
        return (totPerc > 1.00) ? 1.00 : totPerc;
    }
    
    public Double getTotalDailyTarget(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).map(TblBudgetTracker::getdDailyTarget).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getTotalYesterdaySpend(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).map(TblBudgetTracker::getdYesterdaySpend).reduce(Double.valueOf(0), Double::sum);
    }    

    public Double getTotalYesterdayCTR(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).mapToDouble(TblBudgetTracker::getdYestCTR).average().orElse(Double.NaN);
    }   
    
    public Double getTotalMTDCTR(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).mapToDouble(TblBudgetTracker::getdMtdCTR).average().orElse(Double.NaN);
    }       
        
    public Double getTotalProjSpendPerct(String name) {
        return budgetTrackerItems.stream().filter(customer -> name.equals(customer.getvCampaign())).mapToDouble(TblBudgetTracker::getdProjBudgPerc).average().orElse(Double.NaN);
    }    
    
    protected void getRawColumnsBySource() {
        rawColumns = null;
        DAOFile dbCon = new DAOFile();
        rawColumns = dbCon.getItemsColumnNames("D");
    }

    public List<String> getRawColumns() {
        return rawColumns;
    }

    public List<String> getRawPartners() {
        return rawPartners;
    }

    public void setRawPartners(List<String> rawPartners) {
        this.rawPartners = rawPartners;
    }

    public List<String> getRawExchanges() {
        return rawExchanges;
    }

    public void setRawExchanges(List<String> rawExchanges) {
        this.rawExchanges = rawExchanges;
    }

    public List<String> getRawCampaign() {
        return rawCampaign;
    }

    public void setRawCampaign(List<String> rawCampaign) {
        this.rawCampaign = rawCampaign;
    }

    public List<String> getRawDsp() {
        return rawDsp;
    }

    public void setRawDsp(List<String> rawDsp) {
        this.rawDsp = rawDsp;
    }

    public List<String> getRawClient() {
        return rawClient;
    }

    public void setRawClient(List<String> rawClient) {
        this.rawClient = rawClient;
    }

    public List<String> getRawAgency() {
        return rawAgency;
    }

    public void setRawAgency(List<String> rawAgency) {
        this.rawAgency = rawAgency;
    }

    public List<String> getRawChannel() {
        return rawChannel;
    }

    public void setRawChannel(List<String> rawChannel) {
        this.rawChannel = rawChannel;
    }

    public List<String> getRawVendor() {
        return rawVendor;
    }

    public void setRawVendor(List<String> rawVendor) {
        this.rawVendor = rawVendor;
    }

    protected void cleanInternalFilters(){
        rawPartners = new ArrayList();
        rawExchanges = new ArrayList();
        rawDeviceTypes = new ArrayList();
        rawCampaign = new ArrayList();
        rawDsp = new ArrayList();
        rawClient = new ArrayList();
        rawAgency = new ArrayList();
        rawChannel = new ArrayList();
        rawVendor = new ArrayList();
        rawInsertionOrders = new ArrayList();
        rawLineItems = new ArrayList();
        budgetTrackerItems = new ArrayList();
        budgetTrackerSummary = new ArrayList();
    }
    
    public void setRawColumns(List<String> rawColumns) {
        this.rawColumns = rawColumns;
    }

    public List<TblPacing> getPacingItems() {
        if(pacingItems == null || pacingItems.isEmpty()){
            DAOFile dbCon = new DAOFile();
            pacingItems = dbCon.getMonthPacingData(iYear, iMonth);
        }
        return pacingItems;
    }

    public void setPacingItems(List<TblPacing> pacingItems) {
        this.pacingItems = pacingItems;
    }

    public String[] getSelectedrawColumns() {
        return selectedrawColumns;
    }

    public void setSelectedrawColumns(String[] selectedrawColumns) {
        this.selectedrawColumns = selectedrawColumns;
    }
    
    protected void getItemsCatalogo() {
        if (itemsCatalogo == null){
            DAOFile dbCon = new DAOFile();
            itemsCatalogo = dbCon.getCatalogoItems("D");
        }
    }    
    
    public String getTodayAsString() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        todayAsString = df.format(JsfUtil.getFechaSistema().getTime());          
        return todayAsString;
    }

    public void setTodayAsString(String todayAsString) {
        this.todayAsString = todayAsString;
    }

    public List<TblDV360SPD> getItems() {
        if ((items == null || items.isEmpty()) && idDailySelected != null && idDailySelected.getId_daily() > 0) {
            cleanInternalFilters();
            DAOFile dbCon = new DAOFile();
            items = dbCon.getRawDatabyDate(idDailySelected.getId_daily(),JsfUtil.getUsuarioSesion().getvAgency());
            if (items != null && !items.isEmpty()){
                setRawPartners(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vPartner"));
                setRawAgency(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vAgency"));
                setRawCampaign(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vCampaign"));
                setRawChannel(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vChannel"));
                setRawClient(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vClient"));
                setRawDsp(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vDSP"));
                setRawVendor(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vVendor"));
                setRawExchanges(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vExchange"));
                setRawDeviceTypes(new ArrayList());//dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vDeviceTypes"));
                setRawVendor(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vVendor"));
                setRawInsertionOrders(dbCon.getRawDatabyDateDistinctbyPattern("DSP", idDailySelected.getId_daily(),"vInsertionOrder"));
                //setRawLineItems(dbCon.getRawDatabyDateDistinctbyPattern(idDailySelected.getId_daily(),"vLineItem"));
                setLbDataFound(true);            
            }else{
                 setLbDataFound(false);
            }
        }
        return items;
    }

    public void onRenameCampaign() {
        if (budgetSelected != null && !budgetSelected.getvCampaign().isEmpty() && !vCampaignSelected.isEmpty()){
            DAOFile dbCon = new DAOFile();
            if(dbCon.updateCampaign(iYear, iMonth, vPartnerSelected, budgetSelected.getvCampaign().trim(), vCampaignSelected)){
                JsfUtil.addSuccessMessage("Campaign updated successfully");
            }                                    
        }
    }    

    public void onRenameIO() {
        if (budgetSelected != null && !budgetSelected.getvInsertionOrder().isEmpty() && !vIOSelected.isEmpty()){
            DAOFile dbCon = new DAOFile();
            if(dbCon.updateInsertionOrder(iYear, iMonth, vPartnerSelected, budgetSelected.getvInsertionOrder().trim(), vIOSelected)){
                JsfUtil.addSuccessMessage("Insertion Order updated successfully");
            }                                    
        }
    }  
      
    public void onRowEdit(RowEditEvent<TblPacing> event) {
        DAOFile dbCon = new DAOFile();
        if(dbCon.updatePacing(event.getObject())){
            pacingItems = null;
            JsfUtil.addSuccessMessage("Data updated successfully");
        }else{
            JsfUtil.addErrorMessage("Something went wrong! Try again");
        }
    }

    public void onRowEditBudgetTracker(RowEditEvent<TblBudgetTracker> event) {
        DAOFile dbCon = new DAOFile();
        budgetSelected = null;
        if(dbCon.updateBudgetTracker(event.getObject())){
            budgetSelected = event.getObject();
            JsfUtil.addSuccessMessage("Data updated successfully");
        }else{
            JsfUtil.addErrorMessage("Something went wrong! Try again");
        }
    }

    public void onRowEditPerfCampaign(RowEditEvent<TblDV360SPD> event) {
        DAOFile dbCon = new DAOFile();
        selectedPerfSummary = event.getObject();
        if(dbCon.updateGoalPerf(selectedPerfSummary)){
            JsfUtil.addSuccessMessage("Data updated successfully");
        }else{
            JsfUtil.addErrorMessage("Something went wrong! Try again");
        }
    }
    
    
    public List<TblDV360SPD> getMonthlyItems() {
        if ((monthlyItems == null || monthlyItems.isEmpty()) && dMonthSelected != null) {
            LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dMonthSelected));
            DAOFile dbCon = new DAOFile();
            monthlyItems = dbCon.getRawDatabyMonth(localDate.getYear(), localDate.getMonthValue());
            if (monthlyItems != null && !monthlyItems.isEmpty()){
                setLbDataFound(true);
            }else{
                 setLbDataFound(false);
            }
        }        
        return monthlyItems;
    }

    public void getHistoricalByParams(){
        historicalItems = null;
        setLbDataFound(false);
        DAOFile dbCon = new DAOFile();
        historicalItems = dbCon.getHistoricalbyMonth(iYear, iMonth);
        if (historicalItems != null && !historicalItems.isEmpty()){
            setLbDataFound(true);
        }
    }  

    public void getBudgetTrackerByParams(){
        budgetTrackerItems = null;
        vInitialCampaign = "";
        vCampaignSelected = "";
        vIOSelected = "";
        setLbDataFound(false);
        DAOFile dbCon = new DAOFile();
        budgetTrackerItems = dbCon.getBudgetTrackerData(iYear, iMonth, vPartnerSelected);
        if (budgetTrackerItems != null && !budgetTrackerItems.isEmpty()){
            vInitialCampaign = (budgetSelected != null) ? budgetSelected.getvCampaign() : budgetTrackerItems.get(0).getvCampaign();
            vCampaignSelected = vInitialCampaign;
        }
    }      

    public void getDataPerfSumary(){
        itemsPerfSummary = null;
        DAOFile dbCon = new DAOFile();
        itemsPerfSummary = dbCon.getPerfDataSummary(iYear, iMonth, vPartnerSelected, vPerfSummary);
    }      

    public void getDataPerGoals(){
        itemsPerfSummary = null;
        DAOFile dbCon = new DAOFile();
        itemsPerfSummary = dbCon.getPerfDataGoals(iYear, iMonth, vPartnerSelected);
    }      
    

    
    public void getDataBudgetTrackerSumary(){
        budgetTrackerSummary = null;
        DAOFile dbCon = new DAOFile();
        budgetTrackerSummary = dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, vOptionSummary);
    }          

    public BarChartModel getBarModelCA() {
        return barModelCA;
    }

    public void setBarModelCA(BarChartModel barModelCA) {
        this.barModelCA = barModelCA;
    }

    public BarChartModel getBarModelIO() {
        return barModelIO;
    }

    public void setBarModelIO(BarChartModel barModelIO) {
        this.barModelIO = barModelIO;
    }

    public BarChartModel getBarModelAD() {
        return barModelAD;
    }

    public void setBarModelAD(BarChartModel barModelAD) {
        this.barModelAD = barModelAD;
    }

    public void getDataPerfGraphs(){
        DAOFile dbCon = new DAOFile(); //vAdvertiser, vCampaign, vInsertionOrder
        createBarModelCampaign(dbCon.getPerfDataSummary(iYear, iMonth, vPartnerSelected, "vCampaign"));
        createBarModelInsertionOrder(dbCon.getPerfDataSummary(iYear, iMonth, vPartnerSelected, "vInsertionOrder"));        
        createBarModelAd(dbCon.getPerfDataSummary(iYear, iMonth, vPartnerSelected, "vAdvertiser"));                
    }       
    
    public void getDataBarListPerfGraphs(){
        barCampaignItems = new ArrayList<>();
        DAOFile dbCon = new DAOFile(); //vAdvertiser, vCampaign, vInsertionOrder
        List<TblDV360SPD> items = dbCon.getPerfDataPivot(iYear, iMonth, vPartnerSelected);
        if(items != null){
            List<String> labels = new ArrayList<>();
            labels.add("W1");
            labels.add("W2");
            labels.add("W3");
            labels.add("W4");
            labels.add("W5");
            labels.add("AVG");
            labels.add("Goal");
            for (TblDV360SPD itemPerf : items) {
                if(itemPerf != null){
                    List<Number> dataPoints = new ArrayList<>();                
                    dataPoints.add(itemPerf.getdCPM_W1());
                    dataPoints.add(itemPerf.getdCPM_W2());
                    dataPoints.add(itemPerf.getdCPM_W3());
                    dataPoints.add(itemPerf.getdCPM_W4());
                    dataPoints.add(itemPerf.getdCPM_W5());
                    dataPoints.add(itemPerf.getdAVG_W());
                    dataPoints.add((itemPerf.getdCPMGoal() > 0) ? itemPerf.getdCPMGoal() : itemPerf.getdCTRGoal());
                    barCampaignItems.add(createChart(itemPerf.getvCampaign(), dataPoints, labels));                    
                }
            }
        }
    }               

    public void createBarListCampaign(List<TblDV360SPD> items ){
        //barModelCA = new BarChartModel();
        barCampaignItems = new ArrayList<>();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Monthly Performance Campaign");        
        List<String> bgColor = new ArrayList<>();
        List<String> borderColor = new ArrayList<>();

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        cScales.setWeight(0.01f);
        options.setScales(cScales);
        //options.setBarThickness(2);
        //options.setResponsive(false);
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Monthly Performance");
        options.setTitle(title);        
        
        for (TblDV360SPD itemPerf : items) {
            BarChartModel itembarModelCA = new BarChartModel();
            List<Number> values = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            
            values.add(itemPerf.getdRevenueCPM());
            bgColor.add("rgb(54, 162, 235, 0.2)");
            borderColor.add("rgb(54, 162, 235)");
            
            labels.add(itemPerf.getvCampaign());

            barDataSet.setData(values);
            barDataSet.setBackgroundColor(bgColor);                 
            barDataSet.setBorderColor(borderColor);
            barDataSet.setBorderWidth(1); 
                        
            data.addChartDataSet(barDataSet); 
        
            data.setLabels(labels);
            itembarModelCA.setData(data);
        
        
            itembarModelCA.setOptions(options);
            
            barCampaignItems.add(itembarModelCA);
            
        }                
    }
    
    private BarChartModel createChart(String label, List<Number> dataPoints, List<String> labels) {
        BarChartModel model = new BarChartModel();
        ChartData data = new ChartData();

        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        cScales.setWeight(0.01f);
        options.setScales(cScales);        
        
        
        BarChartDataSet dataset = new BarChartDataSet();
        dataset.setLabel(label);
        dataset.setData(dataPoints);
        dataset.setBackgroundColor("rgba(153, 102, 255, 0.6)");
        data.addChartDataSet(dataset);
        data.setLabels(labels);        
        
        model.setData(data);
        
        return model;
    }    
    
    public void createBarModelInsertionOrder(List<TblDV360SPD> items ){
        barModelIO = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Monthly Performance I/O");        
        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<String> bgColor = new ArrayList<>();
        List<String> borderColor = new ArrayList<>();

        for (TblDV360SPD itemPerf : items) {
            values.add(itemPerf.getdRevenueCPM());            
            bgColor.add("rgb(54, 162, 235, 0.2)");
            borderColor.add("rgb(54, 162, 235)");
            labels.add(itemPerf.getvInsertionOrder());
        }            
        
        barDataSet.setData(values);
        barDataSet.setBackgroundColor(bgColor);                 
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1);                         
        data.addChartDataSet(barDataSet);         
        data.setLabels(labels);
        barModelIO.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        cScales.setWeight(0.01f);
        options.setScales(cScales);
        //options.setBarThickness(2);
        //options.setResponsive(false);
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Monthly Performance");
        options.setTitle(title);

        barModelIO.setOptions(options);       
    }
    
    public void createBarModelCampaign(List<TblDV360SPD> items ){
        barModelCA = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Monthly Performance Campaign");        
        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<String> bgColor = new ArrayList<>();
        List<String> borderColor = new ArrayList<>();

        for (TblDV360SPD itemPerf : items) {
            values.add(itemPerf.getdRevenueCPM());
            bgColor.add("rgb(54, 162, 235, 0.2)");
            borderColor.add("rgb(54, 162, 235)");
            labels.add(itemPerf.getvCampaign());
            
        }        
        
        barDataSet.setData(values);
        barDataSet.setBackgroundColor(bgColor);                 
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1); 
                        
        data.addChartDataSet(barDataSet); 
        
        data.setLabels(labels);
        barModelCA.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        cScales.setWeight(0.01f);
        options.setScales(cScales);
        //options.setBarThickness(2);
        //options.setResponsive(false);
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Monthly Performance");
        options.setTitle(title);

        barModelCA.setOptions(options);
        
    }
        
    public void createBarModelAd(List<TblDV360SPD> items ){
        barModelAD = new BarChartModel();
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Monthly Performance Advertiser");        
        List<Number> values = new ArrayList<>();
        List<String> labels = new ArrayList<>();
        List<String> bgColor = new ArrayList<>();
        List<String> borderColor = new ArrayList<>();

        for (TblDV360SPD itemPerf : items) {
            values.add(itemPerf.getdRevenueCPM());
            bgColor.add("rgb(54, 162, 235, 0.2)");
            borderColor.add("rgb(54, 162, 235)");
            labels.add(itemPerf.getvClient());
        }        
        
        barDataSet.setData(values);
        barDataSet.setBackgroundColor(bgColor);                 
        barDataSet.setBorderColor(borderColor);
        barDataSet.setBorderWidth(1); 
                        
        data.addChartDataSet(barDataSet); 
        
        data.setLabels(labels);
        barModelAD.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        cScales.setWeight(0.01f);
        options.setScales(cScales);
        //options.setBarThickness(2);
        //options.setResponsive(false);
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Monthly Performance");
        options.setTitle(title);

        barModelAD.setOptions(options);
        
    }

    public String getLabelsJson(String id) {
        return new Gson().toJson(labelsMap.getOrDefault(id, Collections.emptyList()));
    }

    public String getValoresJson(String id) {
        return new Gson().toJson(valoresMap.getOrDefault(id, Collections.emptyList()));
    }
    
    public void getDataBudgetTrackerGraphs(){
        DAOFile dbCon = new DAOFile();//"vClient";//"vChannel, vCampaign";                                           
        createHorizontalBarModelInsertionOrder(dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vInsertionOrder"));
        createHorizontalBarModelCampaign(dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vCampaign"));
        createHorizontalBarModelChannel(dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vChannel"));
        createHorizontalBarModel(dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vClient"));                        
    }      
    
    public void getDataBudgetTrackerSumaryGraph(){
        budgetTrackerSummary = null;
        DAOFile dbCon = new DAOFile();//"vClient";//"vChannel, vCampaign";
        budgetTrackerSummary = dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vClient");
        if (budgetTrackerSummary != null && !budgetTrackerSummary.isEmpty()){
            createHorizontalBarModel(budgetTrackerSummary);
        }
    }  

    public void getDataBudgetTrackerSumaryGraphCampaign(){
        budgetTrackerSummary = null;
        DAOFile dbCon = new DAOFile();//"vClient";//"vChannel, vCampaign";
        budgetTrackerSummary = dbCon.getBudgetTrackerDataSummary(iYear, iMonth, vPartnerSelected, "vCampaign");
        if (budgetTrackerSummary != null && !budgetTrackerSummary.isEmpty()){
            createHorizontalBarModelCampaign(budgetTrackerSummary);
        }
    }  
    
    public List<TblBudgetTracker> getBudgetTrackerSummary() {
        return budgetTrackerSummary;
    }

    public void setBudgetTrackerSummary(List<TblBudgetTracker> budgetTrackerSummary) {
        this.budgetTrackerSummary = budgetTrackerSummary;
    }

    public void getSpendYesterday(){
        if (budgetSelected != null){
            spendLineItems = null;
            DAOFile dbCon = new DAOFile();
            vIOSelected = (budgetSelected != null) ? budgetSelected.getvInsertionOrder() : "";
            spendLineItems = dbCon.getSpendLineItems(budgetSelected);            
        }else{
            JsfUtil.addErrorMessage("Something went wrong! Try again");
        }
    }      
    
    public void getPacingByParams(){
        pacingItems = null;
        setLbDataFound(false);
        DAOFile dbCon = new DAOFile();
        pacingItems = dbCon.getMonthPacingData(iYear, iMonth);
        if (pacingItems != null && !pacingItems.isEmpty()){
            setLbDataFound(true);
        }
    }  

    public void getHistoricalPacingByParams(){
        pacingItems = null;
        setLbDataFound(false);
        DAOFile dbCon = new DAOFile();
        pacingItems = dbCon.getHistoricalPacing(iYear, iMonth);
        if (pacingItems != null && !pacingItems.isEmpty()){
            setLbDataFound(true);
        }
    }      
    
    public List<TblHistoricalDSP> getHistoricalItems() {        
        return historicalItems;
    }

    public void setHistoricalItems(List<TblHistoricalDSP> historicalItems) {
        this.historicalItems = historicalItems;
    }

    public void setMonthlyItems(List<TblDV360SPD> monthlyItems) {
        this.monthlyItems = monthlyItems;
    }
    
    public TblDV360SPD getSelected() {
        return selected;
    }

    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }

    public Boolean getLbDataFound() {
        return lbDataFound;
    }

    public TblCatalogo getEditCatalog() {
        return editCatalog;
    }

    public List<TblDV360SPD> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<TblDV360SPD> filteredItems) {
        this.filteredItems = filteredItems;
    }

    public void toggleGlobalFilter() {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }

    private int getInteger(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();

        if (LangUtils.isBlank(filterText)) {
            return true;
        }
        //int filterInt = getInteger(filterText);
        TblDV360SPD item = (TblDV360SPD) value;
        
        return item.getvAgency().toLowerCase().contains(filterText)
                || item.getvAlias().toLowerCase().contains(filterText)
                || item.getIdDaily().getdDate().toString().toLowerCase().contains(filterText)
                || item.getvCampaign().toLowerCase().contains(filterText)
                || item.getvChannel().toLowerCase().contains(filterText)
                || item.getvClient().toLowerCase().contains(filterText)
                || item.getvDSP().toLowerCase().contains(filterText)
                || item.getvDealName().toLowerCase().contains(filterText)
                || item.getvExchange().toLowerCase().contains(filterText)
                || item.getvInsertionOrder().toLowerCase().contains(filterText)
                || item.getvLineItem().toLowerCase().contains(filterText)
                || item.getvPartner().toLowerCase().contains(filterText)
                || item.getvVendor().toLowerCase().contains(filterText)
                || item.getvVendorSource().toLowerCase().contains(filterText);
    }    
    
    public TblCatalogo prepareEdit() {        
        editCatalog = new TblCatalogo();
        editCatalog.setvSource("D");
        editCatalog.setvPattern("");
        editCatalog.setvType("");
        editCatalog.setvValue("");

        return editCatalog;
    }    
    
    protected boolean isValid(){
        if (editCatalog == null) {
            JsfUtil.addErrorMessage("Something went wrong! Try again");
            return false;
        }else if(editCatalog.getvPattern().isEmpty()){
            JsfUtil.addErrorMessage("Pattern is empty");
            return false;
        }else if(editCatalog.getvValue().isEmpty()){
            JsfUtil.addErrorMessage("Value is empty");
            return false;            
        }else if(editCatalog.getvType().isEmpty()){
            JsfUtil.addErrorMessage("Category is not selected");
            return false;            
        }else if(selectedrawColumns == null){
            JsfUtil.addErrorMessage("Something went wrong! Try again");
            return false;
        }else if(selectedrawColumns.length == 0){
            JsfUtil.addErrorMessage("You have to selected any Search file");
            return false;
        }
        return true;        
    }    
    
    public void updateEdit(){
        if(isValid()){
            DAOFile dbCon = new DAOFile();
            if (dbCon.createItemCatalogColumnsRelated(editCatalog,selectedrawColumns)){
                dbCon.setItemsCatalogo(itemsCatalogo);                 
                dbCon.setItemsDV360Refactor((filteredItems !=null && !filteredItems.isEmpty()) ? filteredItems:items);                   
                if (dbCon.refactorRawData(idDailySelected.getId_daily(), editCatalog, selectedrawColumns)){
                    selected = null;
                    items =  null;
                    filteredItems = null;
                    editCatalog =  null;
                    selectedrawColumns = null;
                    JsfUtil.addSuccessMessage("Refactor completes successfully");                    
                }
            }else{
                JsfUtil.addErrorMessage("Can´t add new item catalog");
            }
        }else{
            JsfUtil.addErrorMessage("Check all fields for Edit catalog Form");
        }  
    }
    
    public void setEditCatalog(TblCatalogo editCatalog) {
        this.editCatalog = editCatalog;
    }

    public void setLbDataFound(Boolean lbDataFound) {
        this.lbDataFound = lbDataFound;
    }
    
    public void setConfirm(){
        setLbDataFound(false);
    }
    
    public void setSelected(TblDV360SPD selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public List<TblTypeSources> getItemsTypes() {            
        if (itemsTypes == null && editCatalog != null){
            DAOFile dbCon = new DAOFile();
            itemsTypes = dbCon.getCatalogoItemsTypes(editCatalog.getvSource());         
        }
        return itemsTypes;                        
    }

    public void getItemsTypesBySource() {
        if(editCatalog != null){
            itemsTypes = null;
            TblTypeSourcesFacade itemsEjb = new TblTypeSourcesFacade();
            itemsTypes = itemsEjb.getItemsBySource(editCatalog.getvSource());
        }        
    }    
    
    public void setItemsTypes(List<TblTypeSources> itemsTypes) {
        this.itemsTypes = itemsTypes;
    }

    protected void initializeEmbeddableKey() {
    }

    public Date getDMonthSelected() {
        return dMonthSelected;
    }

    public void setDMonthSelected(Date dMonthSelected) {
        this.dMonthSelected = dMonthSelected;
    }

    public Date getDDateSelected() {
        return dDateSelected;
    }

    public TblDailyProcess getIdDailySelected() {
        return idDailySelected;
    }

    public void setIdDailySelected(TblDailyProcess idDailySelected) {
        this.idDailySelected = idDailySelected;
    }

    public void removeSelected(){
        if (selected != null){
            DAOFile dbCon = new DAOFile();
            if (dbCon.cleanRawDataSelected(selected.getId(), "DSP")){
                items.remove(selected);               
                if (filteredItems != null) filteredItems.remove(selected);
                selected = null;                
                monthlyItems = null;
            }
        }
    }

    public void deletePerfData(){
        if (filteredItems != null && !filteredItems.isEmpty()){
            DAOFile dbCon = new DAOFile();
            if (dbCon.clearPerfYearMonthData(filteredItems)){
                itemsCatalogo = dbCon.getCatalogoItems("D");
                rawColumns = dbCon.getItemsColumnNames("D");
                itemsPerf = null;
                selectedPerf = null; 
                filteredItems = null;                
                JsfUtil.addSuccessMessage("Items filtered deleted successfully");
            }
        }else{        
            if (itemsPerf != null && !itemsPerf.isEmpty()){
                DAOFile dbCon = new DAOFile();
                if (dbCon.clearPerfYearMonthData(itemsPerf)){
                    itemsPerf = null;
                    selectedPerf = null;                
                    JsfUtil.addSuccessMessage("Items deleted successfully");
                }
            }
        }
    }    
    
    public void complexLimpiar(){
        if (filteredItems != null && !filteredItems.isEmpty()){
            DAOFile dbCon = new DAOFile();
            if (dbCon.cleanMonthlyRawData(filteredItems)){
                itemsCatalogo = dbCon.getCatalogoItems("D");
                rawColumns = dbCon.getItemsColumnNames("D");
                items = null;
                monthlyItems = null;
                filteredItems = null;
                selected = null;                
                JsfUtil.addSuccessMessage("Items deleted successfully");
            }
        }else{
            if (idDailySelected != null && idDailySelected.getId_daily() > 0){
                DAOFile dbCon = new DAOFile();
                if (dbCon.cleanRawDataByDaily(idDailySelected.getId_daily(), "DSP")){
                    itemsCatalogo = dbCon.getCatalogoItems("D");
                    rawColumns = dbCon.getItemsColumnNames("D");
                    items = null;
                    monthlyItems = null;
                    filteredItems = null;
                    selected = null;                
                    JsfUtil.addSuccessMessage("Items deleted successfully");
                }
            }
        }
    }    
    
    public void transferToHistorical(){
        if (idDailySelected != null){
            DAOFile dbCon = new DAOFile();
            if (dbCon.transferToHistorical("DSP", idDailySelected.getiYear(), idDailySelected.getiMonth() )){
                items = null;
                monthlyItems = null;
                filteredItems = null;
                selected = null;       
                JsfUtil.addSuccessMessage("Data transfered successfully"); 
            }
        }
    }    

    public void transferBudgetToHistorical(){
        DAOFile dbCon = new DAOFile();
        if (dbCon.transferBudgetToHistorical(iYear, iMonth)){
            items = null;
            pacingItems = null;
            monthlyItems = null;
            filteredItems = null;
            selected = null;       
            JsfUtil.addSuccessMessage("Data transfered successfully"); 
        }
    }   
    
    public void montlyClean(){
        if (filteredItems != null && !filteredItems.isEmpty()){
            DAOFile dbCon = new DAOFile();
            if (dbCon.cleanMonthlyRawData(filteredItems)){
                itemsCatalogo = dbCon.getCatalogoItems("D");
                rawColumns = dbCon.getItemsColumnNames("D");
                items = null;
                monthlyItems = null;
                filteredItems = null;
                selected = null;                
                JsfUtil.addSuccessMessage("Items deleted successfully");
            }
        }else{
            JsfUtil.addErrorMessage("No items filtered to clear");
        }
    }

    public void getItemPerfByMonthYear() {              
        selectedPerf = null;
        DAOFile dbCon = new DAOFile();
        itemsPerf = dbCon.getRawDataPerfbyDate(iYear, iMonth, vPartnerSelected);          
        if (itemsPerf != null && !itemsPerf.isEmpty()){
            setRawCampaign(dbCon.getRawDataPerfbyDateDistinctbyPattern(iYear, iMonth, vPartnerSelected,"vCampaign"));
            setRawDeviceTypes(dbCon.getRawDataPerfbyDateDistinctbyPattern(iYear, iMonth, vPartnerSelected,"vDeviceType"));
            setRawClient(dbCon.getRawDataPerfbyDateDistinctbyPattern(iYear, iMonth, vPartnerSelected,"vAdvertiser"));
            setRawInsertionOrders(dbCon.getRawDataPerfbyDateDistinctbyPattern(iYear, iMonth, vPartnerSelected,"vInsertionOrder"));
            setRawLineItems(dbCon.getRawDataPerfbyDateDistinctbyPattern(iYear, iMonth, vPartnerSelected,"vLineItem"));
        }        
    } 
    
    public void getItemCalendarByMonth() {              
        try { 
            internalClear();
            if (dMonthSelected != null){ 
                DAOFile dbCon = new DAOFile();
                LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dMonthSelected));
                idDailySelected = new TblDailyProcess();
                iYear = localDate.getYear();
                iMonth = localDate.getMonthValue();
                idDailySelected.setiDay(localDate.lengthOfMonth());
                idDailySelected.setiMonth(iMonth);
                idDailySelected.setiYear(iYear);
                idDailySelected.setdDate(new java.sql.Date(dMonthSelected.getTime()));
                idDailySelected.setdDate(java.sql.Date.valueOf(LocalDate.of(localDate.getYear(), localDate.getMonthValue(), localDate.lengthOfMonth())));
                idDailySelected.setId_daily(dbCon.getItemDailybyDate(idDailySelected));
            }   
        } catch (Exception ex) {
            System.out.println("getItemCalendarByMonth");
            System.out.println(ex.getMessage());
            ex.printStackTrace();            
        }              
    } 

    public void getPerfCalendarByMonth() {              
        try { 
            //internalClear();
            if (dMonthSelected != null){ 
                DAOFile dbCon = new DAOFile();
                LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dMonthSelected));
                iYear = localDate.getYear();
                iMonth = localDate.getMonthValue();
            }   
        } catch (Exception ex) {
            System.out.println("getPerfCalendarByMonth");
            System.out.println(ex.getMessage());
            ex.printStackTrace();            
        }              
    }     
    
    public Boolean getLbDataTransfer() {
        return lbDataTransfer;
    }

    public void setLbDataTransfer(Boolean lbDataTransfer) {
        this.lbDataTransfer = lbDataTransfer;
    }

    public void getItemCalendarByDate() {
        try {           
            internalClear();
            if (dDateSelected != null){ 
                DAOFile dbCon = new DAOFile();
                LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(dDateSelected) );
                idDailySelected = new TblDailyProcess();
                idDailySelected.setiDay(localDate.getDayOfMonth());
                idDailySelected.setiMonth(localDate.getMonthValue());
                idDailySelected.setiYear(localDate.getYear());
                idDailySelected.setdDate(new java.sql.Date(dDateSelected.getTime()));
                idDailySelected.setId_daily(dbCon.getItemDailybyDate(idDailySelected));
                setLbDataFound(false);
                lbDataTransfer = false;
                if(localDate.lengthOfMonth() == localDate.getDayOfMonth()) lbDataTransfer = true;
            }
        } catch (Exception ex) {
            System.out.println("getItemCalendarByDate");
            System.out.println(ex.getMessage());
            ex.printStackTrace();            
        }            
    }   
    
    protected void getDateBounds(){
        Calendar cal = JsfUtil.getFechaSistema();
        LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
        cal.add(Calendar.DATE, -1);
        setMaxDate(cal.getTime());
        setDDateSelected(cal.getTime());        
        setIYear(localDate.getYear());
        setIMonth(localDate.getMonthValue()); 
        setDMonthSelected(cal.getTime());
        setiWeek(1);
    }    
    
    public void handleFileUpload(FileUploadEvent event) throws ClassNotFoundException, Exception {            
        if( dDateSelected != null){
            if (event != null && event.getFile() != null){
                DAOFile dbCon = new DAOFile();
                dbCon.setItemsCatalogo(itemsCatalogo);
                dbCon.ScanFiles("DSP", event.getFile(), idDailySelected);
                JsfUtil.addSuccessMessage(event.getFile().getFileName() + " uploaded successfully");
                items = null;
                filteredItems = null;
            }            
        }else{
            JsfUtil.addErrorMessage("No date selected");
        }
    }    

    public void handleFileUploadMonthly(FileUploadEvent event) throws ClassNotFoundException, Exception {            
        if( dMonthSelected != null){
            if (event != null && event.getFile() != null){
                DAOFile dbCon = new DAOFile();
                dbCon.setItemsCatalogo(itemsCatalogo);
                dbCon.ScanFiles("DSP", event.getFile(), idDailySelected);
                JsfUtil.addSuccessMessage(event.getFile().getFileName() + " uploaded successfully");
                monthlyItems = null;
                filteredItems = null;
            }            
        }else{
            JsfUtil.addErrorMessage("No date selected");
        }
    }  

    public void handleFilePerfUploadWeeklyData(FileUploadEvent event) throws ClassNotFoundException, Exception {            
        if (event != null && event.getFile() != null){
            DAOFile dbCon = new DAOFile();
            dbCon.uploadFilePerfMassiveData(event.getFile(), vPartnerSelected, iWeek);
            JsfUtil.addSuccessMessage(event.getFile().getFileName() + " uploaded successfully");
            itemsPerf = null;
            selectedPerf = null;
            filteredItems = null;
        }
    }      
    
    public void handleFileUploadMassiveData(FileUploadEvent event) throws ClassNotFoundException, Exception {            
        if( dMonthSelected != null){
            if (event != null && event.getFile() != null){
                DAOFile dbCon = new DAOFile();
                dbCon.setItemsCatalogo(itemsCatalogo);
                dbCon.ScanFileMassiveData("DSP", event.getFile());
                JsfUtil.addSuccessMessage(event.getFile().getFileName() + " uploaded successfully");
                monthlyItems = null;
                filteredItems = null;
            }            
        }else{
            JsfUtil.addErrorMessage("No date selected");
        }
    }     

    public String getVPartnerSelected() {
        return vPartnerSelected;
    }

    public void setVPartnerSelected(String vPartnerSelected) {
        this.vPartnerSelected = vPartnerSelected;
    }

    public String getvOptionSummary() {
        return vOptionSummary;
    }

    public void setvOptionSummary(String vOptionSummary) {
        this.vOptionSummary = vOptionSummary;
    }
        
    protected void internalClear(){      
        setLbDataFound(true);
        lbDataTransfer = false;
        vPartnerSelected = "";
        vOptionSummary = "vChannel, vCampaign";
        vPerfSummary = "vAdvertiser, vCampaign"; 
        vInitialCampaign = "";
        items = null;
        monthlyItems = null;
        itemsPerf = null;
        selectedPerf = null;        
        pacingItems = null;
        budgetTrackerItems = null;
        filteredItems = null;
        selected = null;
        idDailySelected = null;
        //PrimeFaces.current().executeScript("$('#TblRawDataListForm\\:datalist\\:globalFilter').val('').keyup(); return false;");
    }

    public TblBudgetTracker getBudgetSelected() {
        return budgetSelected;
    }

    public void setBudgetSelected(TblBudgetTracker budgetSelected) {
        this.budgetSelected = budgetSelected;
    }
    
    public void simpleLimpiar(){      
        setLbDataFound(true);
        lbDataTransfer = false;
        vPartnerSelected = "";
        vOptionSummary = "vChannel, vCampaign";
        vPerfSummary = "vAdvertiser, vCampaign";
        vInitialCampaign = "";
        items = null;
        monthlyItems = null;
        pacingItems = null;
        budgetTrackerItems = null;
        budgetTrackerSummary = null;
        lbChartExpandedIO = false;
        lbChartExpandedCA = false;
        lbChartExpandedCH = false;
        lbChartExpandedAD = false;        
        bTrackerSummaryIO = null;
        bTrackerSummaryCA = null;
        bTrackerSummaryCH = null;
        bTrackerSummaryAD = null;         
        budgetSelected = null;
        spendLineItems = null;
        filteredItems = null;
        selected = null;
        dDateSelected = null;
        dMonthSelected = null;
        idDailySelected = null;
        cleanInternalFilters();
    }

    public void internalLimpiar(){      
        setLbDataFound(true);
        lbDataTransfer = false;
        lbChartExpandedIO = false;
        lbChartExpandedCA = false;
        lbChartExpandedCH = false;
        lbChartExpandedAD = false;
        vPartnerSelected = "";
        vCampaignSelected = "";
        vIOSelected = "";
        vOptionSummary = "vChannel, vCampaign";
        vPerfSummary = "vAdvertiser, vCampaign";
        vInitialCampaign = "";
        items = null;
        itemsPerf = null;
        selectedPerf = null;
        monthlyItems = null;
        pacingItems = null;
        budgetTrackerItems = null;
        budgetTrackerSummary = null;
        bTrackerSummaryIO = null;
        bTrackerSummaryCA = null;
        bTrackerSummaryCH = null;
        bTrackerSummaryAD = null;        
        budgetSelected = null;
        spendLineItems = null;
        filteredItems = null;
        selected = null;
        dDateSelected = null;
        dMonthSelected = null;
        idDailySelected = null;
        cleanInternalFilters();
    }    
    
    public void setDDateSelected(Date dDateSelected) {
        this.dDateSelected = dDateSelected;
    }
}
