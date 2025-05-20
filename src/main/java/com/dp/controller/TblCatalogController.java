package com.dp.controller;

import com.dp.entity.TblCatalog;
import com.dp.entity.TblTypeSources;
import com.dp.facade.util.JsfUtil;
import com.dp.facade.util.JsfUtil.PersistAction;
import com.dp.facade.TblCatalogFacade;
import com.dp.facade.TblTypeSourcesFacade;
import com.dp.util.DAOFile;
import com.dp.util.TblCatalogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.ejb.EJBException;
import jakarta.inject.Named;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.faces.view.ViewScoped;

@Named("tblCatalogController")
@ViewScoped
public class TblCatalogController implements Serializable {

    //@EJB
    //private TblCatalogFacade ejbFacade = new TblCatalogFacade();
    private List<TblCatalogo> items = null;
    private TblCatalogo selected;
    private List<TblTypeSources> itemsTypes = null;
    private List<String> itemsCategories = null;
    private List<String> rawColumns;
    private String[] selectedrawColumns;

    public TblCatalogController() {
        DAOFile dbCon = new DAOFile();
        itemsCategories = dbCon.getItemsCategories();        
    }

    public TblCatalogo getSelected() {
        return selected;
    }

    public List<String> getItemsCategories() {
        return itemsCategories;
    }

    public String[] getSelectedrawColumns() {
        return selectedrawColumns;
    }

    public void setSelectedrawColumns(String[] selectedrawColumns) {
        this.selectedrawColumns = selectedrawColumns;
    }

    public List<String> getRawColumns() {
        return rawColumns;
    }

    public void getRawColumnsBySource() {
        rawColumns = null;
        if(selected != null){            
            DAOFile dbCon = new DAOFile();
            rawColumns = dbCon.getItemsColumnNames(selected.getvSource());
        }        
    }    
    
    public void setRawColumns(List<String> rawColumns) {
        this.rawColumns = rawColumns;
    }

    public void setItemsCategories(List<String> itemsCategories) {
        this.itemsCategories = itemsCategories;
    }

    public void setSelected(TblCatalogo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public List<TblTypeSources> getItemsTypes() {
        if (itemsTypes == null && selected != null){
            DAOFile dbCon = new DAOFile();
            itemsTypes = dbCon.getCatalogoItemsTypes(selected.getvSource());         
        }
        return itemsTypes;
    }

    public void setItemsTypes(List<TblTypeSources> itemsTypes) {
        this.itemsTypes = itemsTypes;
    }

    public void getItemsTypesBySource() {
        if(selected != null){
            itemsTypes = null;
            selectedrawColumns = null;
            DAOFile dbCon = new DAOFile();
            itemsTypes = dbCon.getCatalogoItemsTypes(selected.getvSource());
            /*************************************************************/            
            rawColumns = dbCon.getItemsColumnNames(selected.getvSource());
            /*************************************************************/  
            List<String> lsRet =  new ArrayList();
            selected.getTblCatalogColumnList().stream().forEachOrdered((a) -> {
                    lsRet.add(a.getvColumnName());
            });
            if(lsRet != null && !lsRet.isEmpty()) selectedrawColumns = lsRet.toArray(new String[0]);             
        }        
    }
   
    public void destroy() {
        if(selected != null){
            DAOFile dbCon = new DAOFile();
            if(dbCon.removeItemCatalogAndColumnsRelated(selected)){
                selected = null; // Remove selection
                items = null;    // Invalidate list of items to trigger re-query.
                JsfUtil.addSuccessMessage("Item deleted successfully");
            }
        }        
    }    

    public TblCatalogo prepareCreate() {
        selected = new TblCatalogo();
        selected.setvSource("");
        selected.setvPattern("");
        selected.setvType("");
        selected.setvValue("");
        selected.setTblCatalogColumnList(new ArrayList());
        selectedrawColumns = null;
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        if (isValid()){
            DAOFile dbCon = new DAOFile();
            dbCon.createItemCatalogColumnsRelated(selected,selectedrawColumns);
            JsfUtil.addSuccessMessage("Item added successfully");
            selected = null;
            items = null;            
            selectedrawColumns = null;
            rawColumns = null;
        }
    }

    protected boolean isValid(){
        if (selected == null) {
            JsfUtil.addErrorMessage("Something went wrong! Try again");
            return false;
        }else if(selected.getvPattern().isEmpty()){
            JsfUtil.addErrorMessage("Pattern is empty");
            return false;
        }else if(selected.getvValue().isEmpty()){
            JsfUtil.addErrorMessage("Value is empty");
            return false;            
        }else if(selected.getvType().isEmpty()){
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
    
    public void update() {
        if (isValid()){
            DAOFile dbCon = new DAOFile();
            dbCon.updateItemCatalogColumnsRelated(selected,selectedrawColumns);
            selected = null;            
            items = null;    // Invalidate list of items to trigger re-query.  
            selectedrawColumns = null;
            rawColumns = null;
            JsfUtil.addSuccessMessage("Updated successfully");        
        }
    }

    public List<TblCatalogo> getItems() {
        if (items == null) {
            DAOFile dbCon = new DAOFile();
            items = dbCon.getCatalogItemsActive();
        }
        return items;
    }
}
