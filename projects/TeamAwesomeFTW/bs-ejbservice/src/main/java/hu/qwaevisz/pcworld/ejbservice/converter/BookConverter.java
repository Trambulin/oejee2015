package hu.qwaevisz.pcworld.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.qwaevisz.pcworld.ejbservice.domain.BookStub;
import hu.qwaevisz.pcworld.persistence.entity.Book;

@Local
public interface BookConverter {

	BookStub to(Book book);

	List<BookStub> to(List<Book> books);

}
