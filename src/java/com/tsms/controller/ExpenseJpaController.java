/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.controller;

import com.tsms.controller.exceptions.NonexistentEntityException;
import com.tsms.entity.Expense;
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
public class ExpenseJpaController implements Serializable {

    public ExpenseJpaController() {
        this.emf = Persistence.createEntityManagerFactory("TabonaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Expense expense) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(expense);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Expense expense) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            expense = em.merge(expense);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = expense.getId();
                if (findExpense(id) == null) {
                    throw new NonexistentEntityException("The expense with id " + id + " no longer exists.");
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
            Expense expense;
            try {
                expense = em.getReference(Expense.class, id);
                expense.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The expense with id " + id + " no longer exists.", enfe);
            }
            em.remove(expense);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Expense> findExpenseEntities() {
        return findExpenseEntities(true, -1, -1);
    }

    public List<Expense> findExpenseEntities(int maxResults, int firstResult) {
        return findExpenseEntities(false, maxResults, firstResult);
    }

    private List<Expense> findExpenseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Expense.class));
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

    public Expense findExpense(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Expense.class, id);
        } finally {
            em.close();
        }
    }

    public int getExpenseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Expense> rt = cq.from(Expense.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
