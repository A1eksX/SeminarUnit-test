import book.Book;
import book.BookRepository;
import book.BookService;
import book.InMemoryBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * У вас есть класс BookService, который использует интерфейс BookRepository
 * для получения информации о книгах из базы данных. Ваша задача написать
 * unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
 */
public class BookServiceTest {
    private BookRepository bookRepository;
    @BeforeEach
    void setup(){
        // Создаю заглушку для BookRepository
        bookRepository = mock(BookRepository.class);
    }

    @Test
    void testBookServiceFindBookById(){
        // Создаю объект тестируемого класса
        BookService bookService = new BookService(bookRepository);

        // Вызываю метод, который хочу протестировать
        bookService.findBookById("2");

        // Проверяю, что метод findById был вызван с ожидаемым аргументом
        verify(bookRepository).findById("2");
    }

    @Test
    void testBookServiceListFindAllBooks(){
        // Создаю список книг для проверки
        List<Book> books = new ArrayList<>();
        books.add(new Book("1", "Book1", "Author1"));
        books.add(new Book("2", "Book2", "Author2"));
        books.add(new Book("3", "Book3", "Author3"));
        books.add(new Book("4", "Book4", "Author4"));

        // Устанавливаю жёсткий ответ для метода findAll(), при вызове метода - должен вернуться список книг
        when(bookRepository.findAll()).thenReturn(books);

        // Создаю экземпляр BookService с заглушкой
        BookService bookService = new BookService(bookRepository);

        // Проверяю, что метод findAllBooks() возвращает правильное кол-во книг в списке
        assertThat(bookService.findAllBooks().size()).isEqualTo(4);
    }
}
