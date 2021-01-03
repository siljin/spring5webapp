package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author ac = new Author("Agatha", "Christie");
        authorRepository.save(ac);

        Book motoe = new Book("Murder on the orient express", "22334");
        bookRepository.save(motoe);

        Publisher pg = new Publisher("Penguin", "USA");
        publisherRepository.save(pg);

        ac.getBooks().add(motoe);
        motoe.getAuthors().add(ac);
        motoe.setPublisher(pg);
        pg.getBooks().add(motoe);

        authorRepository.save(ac);
        publisherRepository.save(pg);
        bookRepository.save(motoe);

        Author db = new Author("Dan", "Brown");
        Book dvc  = new Book("Da Vinci Code", "443322");
        db.getBooks().add(dvc);
        dvc.getAuthors().add(db);
        dvc.setPublisher(pg);
        pg.getBooks().add(dvc);

        authorRepository.save(db);
        bookRepository.save(dvc);
        publisherRepository.save(pg);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("publisher number of books: " + pg.getBooks().size());




    }



}
