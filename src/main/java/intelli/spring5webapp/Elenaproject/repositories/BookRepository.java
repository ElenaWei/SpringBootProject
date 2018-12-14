package intelli.spring5webapp.Elenaproject.repositories;

import intelli.spring5webapp.Elenaproject.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * created by Elena on 12/6/2018
 */
public interface BookRepository extends CrudRepository <Book, Long> {

}
