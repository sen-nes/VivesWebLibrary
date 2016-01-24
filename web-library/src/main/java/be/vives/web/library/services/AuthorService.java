package be.vives.web.library.services;

import be.vives.web.library.dao.AuthorDAO;
import be.vives.web.library.models.Author;
import be.vives.web.library.models.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authors")
public class AuthorService {

   @Inject
   AuthorDAO authorDAO;

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<Author> getAuthors(){
      return authorDAO.findAll();
   }
   
   @GET
   @Path("/{id}")
   @Produces(MediaType.APPLICATION_JSON)
   public Author getAuthorById(@PathParam("id") int id){
      return authorDAO.findById(id);
   }
   
   @POST
   @Path("/new")
   @Consumes(MediaType.APPLICATION_JSON)
   public void createAuthor(Author author) {
       authorDAO.update(author);
   }
   
   @PUT
   @Path("/edit/{id}")
   @Consumes(MediaType.APPLICATION_JSON)
   public void updateAuthor(@PathParam("id") int id, Author author) {
        if (author.getId() == id) {
            Author update = authorDAO.findById(id);
            update.setName(author.getName());
            if (author.getBooks() != null){
                update.setBooks(author.getBooks());
            }
            authorDAO.update(update);
        }
   }
   
   @DELETE
   @Path("/delete/{id}")
   public void deleteAuthor(@PathParam("id") int id) {
       authorDAO.deleteById(id);
   }
}
