/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vives.web.library.dao;

import be.vives.web.library.models.Author;

/**
 *
 * @author Szayel
 */
public interface AuthorDAO extends BaseDAO<Integer, Author> {
    Author findByName(String authorName);
}
