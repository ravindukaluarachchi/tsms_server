/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.controller;

import com.tsms.controller.exceptions.NonexistentEntityException;
import com.tsms.entity.Customer_Location;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ravindu
 */
public class Customer_LocationJpaController implements Serializable {

    public Customer_LocationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customer_Location customer_Location) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(customer_Location);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer_Location customer_Location) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            customer_Location = em.merge(customer_Location);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customer_Location.getId();
                if (findCustomer_Location(id) == null) {
                    throw new NonexistentEntityException("The customer_Location with id " + id + " no longer exists.");
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
            Customer_Location customer_Location;
            try {
                customer_Location = em.getReference(Customer_Location.class, id);
                customer_Location.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer_Location with id " + id + " no longer exists.", enfe);
            }
            em.remove(customer_Location);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer_Location> findCustomer_LocationEntities() {
        return findCustomer_LocationEntities(true, -1, -1);
    }

    public List<Customer_Location> findCustomer_LocationEntities(int maxResults, int firstResult) {
        return findCustomer_LocationEntities(false, maxResults, firstResult);
    }

    private List<Customer_Location> findCustomer_LocationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer_Location.class));
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

    public Customer_Location findCustomer_Location(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer_Location.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomer_LocationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer_Location> rt = cq.from(Customer_Location.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
