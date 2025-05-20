/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.facade;

import com.dp.entity.TblCatalog;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author ZAMBRED
 */
@Stateless
public class TblCatalogFacade extends AbstractFacade<TblCatalog> {
    
    private EntityManager em;
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        if(em != null){
            if(em.isOpen()){
                return em;
            }
        }
        emf = Persistence.createEntityManagerFactory("RPTDataWebPU");
        em = emf.createEntityManager();
        return em;
    }
    
    public void setEM(EntityManager em){
        this.em = em;
    
    }
    public EntityManager getEM(){
        return getEntityManager();
    }
    
     public void generateEM(){
            if(em!=null)
            {
                if (em.getTransaction().isActive())
                    {
                        em.getTransaction().rollback();
                    }
                    if (em.isOpen())
                            em.close();
                    em=getEntityManager();
            }else
            {
                 em=getEntityManager();
            }
    }
    
    public void beginTransaction(){
        generateEM();
        em.getTransaction().begin();

    }
    
    public void commitTransaction(){
        em.getTransaction().commit();
    }
    public void rollbackTransaction(){
        em.getTransaction().rollback();
    }
    
    
    public TblCatalogFacade() {
        super(TblCatalog.class);
    }
    
    public List<TblCatalog> getItemsEnabled(){
        try {
            return getEntityManager().createNamedQuery("TblCatalog.findByIEstado").setParameter("iEstado", Boolean.TRUE).getResultList();                      
        }catch (Exception nre) {
            nre.printStackTrace();
            System.out.println(nre.getMessage());             
        }
        return null;        
    }        
    
    public String getValueByTypePattern(String strSource, String strType, String strPattern){
        String lsRet="OTROS";
        try {
            strPattern = strPattern.toUpperCase();
            List<TblCatalog> itemsGot = getEntityManager().createNamedQuery("TblCatalog.findByVSourceVType").setParameter("vSource", strSource).setParameter("vType", strType).getResultList();                      
            for (TblCatalog item : itemsGot) {
                if(strPattern.contains(item.getVPattern().toUpperCase())){
                    lsRet = item.getVValue();
                    break;
                }
            }
            
        }catch (Exception nre) {
            nre.printStackTrace();
            System.out.println(nre.getMessage());             
        }
        return lsRet;
    }          
}
