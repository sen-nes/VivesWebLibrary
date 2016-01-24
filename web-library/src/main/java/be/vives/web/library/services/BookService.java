package be.vives.web.library.services;

import be.vives.web.library.dao.AuthorDAO;
import be.vives.web.library.dao.BookDAO;
import be.vives.web.library.models.Author;
import be.vives.web.library.models.Book;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService{
    
   @Inject
   BookDAO bookDAO;
   
   @Inject
   AuthorDAO authorDAO;
   
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Book> getBooks(){
        return bookDAO.findAll();
   }
   
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Book getBookById(@PathParam("id") int id) {
       return bookDAO.findById(id);
   }
   
   @POST
   @Path("/new")
   @Consumes(MediaType.APPLICATION_JSON)
   public void createBook(Book book) {
       Author author = authorDAO.findByName(book.getAuthor().getName());
       if (author == null) {
           authorDAO.save(book.getAuthor());
       } else {
           book.setAuthor(author);
       }
       bookDAO.update(book);
   }
   
   @PUT
   @Path("/edit/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   public void updateBook(@PathParam("id") int id, Book book) {
        if (book.getId() == id) {
            Book update = bookDAO.findById(id);
            Author author = authorDAO.findByName(book.getAuthor().getName());
            
            if (author == null) {
                authorDAO.save(book.getAuthor());
            } else {
                book.setAuthor(author);
            }
            
            if (update != null) {
                if (book.getTitle() != null){
                update.setTitle(book.getTitle());
                }
                if (book.getISBN() != null){
                    update.setISBN(book.getISBN());
                }
                if (book.getAuthor() != null) { 
                    update.setAuthor(book.getAuthor());
                }
            
                bookDAO.update(update);
            }
        }
   }
   
   @DELETE
   @Path("/delete/{id}")
   public void deleteBook(@PathParam("id") int id) {
       bookDAO.deleteById(id);
   }
}
