package be.vives.web.library.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> ISBN;
	public static volatile SingularAttribute<Book, Author> author;
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, String> title;

}

