/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.facade;

import com.dp.entity.TblRawData;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author ZAMBRED
 */
@Stateless
public class TblRawDataFacade extends AbstractFacade<TblRawData> {

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
    
    public TblRawDataFacade() {
        super(TblRawData.class);
    }
    
}
