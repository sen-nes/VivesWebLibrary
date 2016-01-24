package be.vives.web.library.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="book")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @Column(nullable=false, length = 60)
    private String title;
    
    @Column(nullable=false, length = 20)
    private String ISBN;
    
   @ManyToOne()
   private Author author;
    
    public Book() {
    }

    public Integer getId() {
        return (Integer) id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    @XmlElement
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    @XmlElement
    public void setAuthor(Author author) {
        this.author = author;
    }
}
