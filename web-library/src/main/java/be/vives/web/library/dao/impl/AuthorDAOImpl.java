package be.vives.web.library.dao.impl;

import be.vives.web.library.dao.AuthorDAO;
import be.vives.web.library.models.Author;
import be.vives.web.library.models.Author_;
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
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author Szayel
 */
@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class AuthorDAOImpl implements AuthorDAO {
    
    @PersistenceContext(unitName = "library-pu")
    EntityManager em;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public List findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        
        cq.from(Author.class);
        
        return em.createQuery(cq).getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Author findById(Integer id) {
        return em.find(Author.class, id);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Author entity) {
        em.persist(entity);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Author update(Author entity) {
        
        em.merge(entity);
        return entity;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Author saveOrUpdate(Author author) {
        if (em.find(Author.class, author) == null) {
            em.persist(author);
        } else {
            em.merge(author);
        }
        
        return author;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Author delete(Author author) {

        em.remove(author);

        return author;
    }

    @Override
    public Author deleteById(int id) {
        Author author = em.find(Author.class, id);
        em.remove(author);
        
        return author;
    }
    
    

    @Override
    public Author findByName(String authorName) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> author = cq.from(Author.class);
        
        cq.select(author);
        cq.where(cb.equal(author.get(Author_.name), authorName));

        List<Author> results = em.createQuery(cq).getResultList();
        Author foundAuthor = null;
        if (!results.isEmpty()) {
                foundAuthor = results.get(0);
        }
        return foundAuthor;
    }
}
