/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.controller;

import com.tsms.controller.exceptions.NonexistentEntityException;
import com.tsms.entity.Vehicle_Expense;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ravindu
 */
public class Vehicle_ExpenseJpaController implements Serializable {

    public Vehicle_ExpenseJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TabonaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehicle_Expense vehicle_Expense) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vehicle_Expense);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehicle_Expense vehicle_Expense) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Vehicle_Expense ve = em.find(Vehicle_Expense.class, vehicle_Expense.getId());
            ve.setAmount(vehicle_Expense.getAmount());
            ve.setExpenseDate(vehicle_Expense.getExpenseDate());
           // ve.setExpenses(vehicle_Expense.getExpenses());
            ve.setRemarks(vehicle_Expense.getRemarks());
            //ve.setVehicle(vehicle_Expense.getVehicle());
            em.getTransaction().begin();
            vehicle_Expense = em.merge(ve);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = vehicle_Expense.getId();
                if (findVehicle_Expense(id) == null) {
                    throw new NonexistentEntityException("The vehicle_Expense with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehicle_Expense vehicle_Expense;
            try {
                vehicle_Expense = em.getReference(Vehicle_Expense.class, id);
                vehicle_Expense.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehicle_Expense with id " + id + " no longer exists.", enfe);
            }
            em.remove(vehicle_Expense);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehicle_Expense> findVehicle_ExpenseEntities() {
        return findVehicle_ExpenseEntities(true, -1, -1);
    }

    public List<Vehicle_Expense> findVehicle_ExpenseEntities(int maxResults, int firstResult) {
        return findVehicle_ExpenseEntities(false, maxResults, firstResult);
    }

    private List<Vehicle_Expense> findVehicle_ExpenseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehicle_Expense.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vehicle_Expense findVehicle_Expense(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehicle_Expense.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehicle_ExpenseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehicle_Expense> rt = cq.from(Vehicle_Expense.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
     public List<Vehicle_Expense> findVehicle_ExpenseEntitiesByMonth(Integer month){
         EntityManager em = getEntityManager();
         try{
             Query q = em.createQuery("select ve from Vehicle_Expense ve where  SUBSTRING(ve.expenseDate,6,2)=" + month );
             return  q.getResultList();
         }finally{
             if (em != null) {
                 em.close();
             }
         }                  
     }
     
     public List<Vehicle_Expense> findVehicle_ExpenseEntitiesByMonth(Long vehicleId,Integer month){
         EntityManager em = getEntityManager();
         try{
             Query q = em.createQuery("select ve from Vehicle_Expense ve where ve.vehicle.id=" + vehicleId + "L and SUBSTRING(ve.expenseDate,6,2)=" + month);
             return  q.getResultList();
         }finally{
             if (em != null) {
                 em.close();
             }
         }                  
     }
     
     public List<Vehicle_Expense> findVehicle_ExpenseEntities(Long vehicleId){
         EntityManager em = getEntityManager();
         try{
             Query q = em.createQuery("select ve from Vehicle_Expense ve where ve.vehicle.id=" + vehicleId + "L");
             return  q.getResultList();
         }finally{
             if (em != null) {
                 em.close();
             }
         }                  
     }
}
