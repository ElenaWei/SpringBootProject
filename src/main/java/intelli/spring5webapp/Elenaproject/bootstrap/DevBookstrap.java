package intelli.spring5webapp.Elenaproject.bootstrap;

import intelli.spring5webapp.Elenaproject.model.Author;
import intelli.spring5webapp.Elenaproject.model.Book;
import intelli.spring5webapp.Elenaproject.model.Publisher;
import intelli.spring5webapp.Elenaproject.repositories.AuthorRepository;
import intelli.spring5webapp.Elenaproject.repositories.BookRepository;
import intelli.spring5webapp.Elenaproject.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * created by Elena on 12/6/2018
 */
@Component
public class DevBookstrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBookstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Lai");

        Publisher publisher1 = new Publisher("Harper Colllins", "Newark, CA");
        publisherRepository.save(publisher1);

        Book book1 = new Book("Donain Driven Design", "12345", publisher1);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);


        Author elena = new Author("ELena", "Wei");

        Publisher publisher2 = new Publisher("Public Newspaper", "Newark, NY");
        publisherRepository.save(publisher2);

        Book book2 = new Book("J2EE Development without EJB", "45678", publisher2);
        elena.getBooks().add(book2);

        authorRepository.save(elena);
        bookRepository.save(book2);

    }
}
