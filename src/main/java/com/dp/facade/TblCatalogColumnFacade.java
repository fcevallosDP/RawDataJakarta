/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.facade;

import com.dp.entity.TblCatalogColumn;
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
public class TblCatalogColumnFacade extends AbstractFacade<TblCatalogColumn> {
    
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
    
    
    public TblCatalogColumnFacade() {
        super(TblCatalogColumn.class);
    }
    
    public List<TblCatalogColumn> getItemsEnabled(){
        try {
            return getEntityManager().createNamedQuery("TblCatalogColumn.findByIEstado").setParameter("iEstado", Boolean.TRUE).getResultList();                      
        }catch (Exception nre) {
            nre.printStackTrace();
            System.out.println(nre.getMessage());             
        }
        return null;        
    }        
    
     public List<String> getColumnsBySourceCategory(String strSource, String strCategory){
        try {
            return getEntityManager().createNamedQuery("TblCatalogColumn.findByVSourceVCategory").setParameter("vSource", strSource).setParameter("vCategory", strCategory).setParameter("iEstado", Boolean.TRUE).getResultList();                      
        }catch (Exception nre) {
            nre.printStackTrace();
            System.out.println(nre.getMessage());             
        }
        return null;
    }          
}
