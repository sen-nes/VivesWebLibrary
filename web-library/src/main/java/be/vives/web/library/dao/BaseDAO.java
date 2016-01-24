/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vives.web.library.dao;

import be.vives.web.library.dao.impl.*;
import be.vives.web.library.models.Author;
import java.util.List;

/**
 *
 * @author Szayel
 */
public interface BaseDAO<PK, T> {
    List<T> findAll();
    T findById(PK id);
    void save(T entity);
    T update(T entity);
    T saveOrUpdate(T entity);
    T delete(T entity);
    T deleteById(int id);
    
    // Maybe something here.
}
