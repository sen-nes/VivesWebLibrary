/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vives.web.library.dao.impl;

import be.vives.web.library.dao.BookDAO;
import be.vives.web.library.models.Author;
import be.vives.web.library.models.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Szayel
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class BookDAOImpl implements BookDAO {
    
    @PersistenceContext(unitName = "library-pu")
    EntityManager em;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        
        cq.from(Book.class);
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Book findById(Integer id) {
        
        return em.find(Book.class, id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Book entity) {
        
        em.persist(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Book update(Book entity) {
        
        em.merge(entity);
        return entity;
    }
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Book saveOrUpdate(Book book) {
        if (em.find(Book.class, book) == null) {
            em.persist(book);
        } else {
            em.merge(book);
        }
        
        return book;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Book delete(Book entity) {

        em.remove(entity);

        return entity;
    }
    
    @Override
    public Book deleteById(int id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
        
        return book;
    }
}
