import java.util.ArrayList;
import java.util.List;

public class BookStore {

   private final BookRepository bookRepository;

   public BookStore(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
   }

   public void createNewBook() {
      // infers to "java.lang.String"
      var title = "Macbeth";
      var author = "William Shakespeare";

      // infers to "Book"
      var book = new Book(title, author);

      bookRepository.saveBook(book);
   }

   public List<Book> getBooks() {
      // infers to "java.util.ArrayList<Book>"
      var books = new ArrayList<Book>();
      books.add(new Book("Some title", "Some author"));
      return books;
   }
}