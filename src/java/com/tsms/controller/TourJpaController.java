/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.controller;

import com.tsms.controller.exceptions.NonexistentEntityException;
import com.tsms.entity.Customer;
import com.tsms.entity.Location;
import com.tsms.entity.Tour;
import java.io.Serializable;
import java.util.Calendar;
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
public class TourJpaController implements Serializable {

    public TourJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TabonaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tour tour) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tour);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tour tour) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tour = em.merge(tour);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tour.getId();
                if (findTour(id) == null) {
                    throw new NonexistentEntityException("The tour with id " + id + " no longer exists.");
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
            Tour tour;
            try {
                tour = em.getReference(Tour.class, id);
                tour.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tour with id " + id + " no longer exists.", enfe);
            }
            em.remove(tour);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tour> findTourEntities() {
        return findTourEntities(true, -1, -1);
    }

    public List<Tour> findTourEntities(int maxResults, int firstResult) {
        return findTourEntities(false, maxResults, firstResult);
    }

    private List<Tour> findTourEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tour.class));
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

    public Tour findTour(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tour.class, id);
        } finally {
            em.close();
        }
    }

    public int getTourCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tour> rt = cq.from(Tour.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void create(Long customerId, Calendar date, int noOfDates, Calendar time, Long locationId, int noOfVehicles) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Customer customer = em.find(Customer.class, customerId);
            Location location = em.find(Location.class, locationId);
            Tour tour = new Tour();
            tour.setCustomer(customer);
            tour.setStartTime(time);
            tour.setStartDate(date);
            tour.setLocation(location);
            em.getTransaction().begin();
            em.persist(tour);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tour> findRequestedTours() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select t from Tour t where t.status=" + Tour.REQUESTED);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
  
    public List<Tour> findTours(Long customerId,Integer month){
       EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select t from Tour t where t.status=" + Tour.Finished + " and SUBSTRING(t.startDate,6,2)=" + month + " and t.customer.id=" + customerId + "L");
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Tour> findTours(Long customerId){
       EntityManager em = null;
        try {
            em = getEntityManager();
            System.out.println("find customer tours by customer id : " + customerId);
            Query q = em.createQuery("select t from Tour t where t.customer.id = :id ");
            q.setParameter("id", customerId);
            List<Tour> tours = q.getResultList();
            System.out.println("no of tours : " + tours.size());
            return tours;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    

    public List<Tour>  findTours(Integer month){
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createQuery("select t from Tour t where t.status=" + Tour.Finished + " and SUBSTRING(t.startDate,6,2)=" + month + "");         
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
