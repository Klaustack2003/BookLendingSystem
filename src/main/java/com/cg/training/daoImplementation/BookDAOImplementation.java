package com.cg.training.daoImplementation;

import com.cg.training.dao.BookDAO;
import com.cg.training.model.Book;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * BookDAOImplementation provides an in-memory and file-based implementation of
 * the {@link BookDAO} interface. It manages operations such as adding,
 * removing, retrieving, and saving Book records.
 * <p>
 * Book data is loaded from and saved to a file at
 * <code>resources/books.txt</code>.
 * </p>
 * 
 * @author YourName
 */
public class BookDAOImplementation implements BookDAO {

	private final List<Book> books = new ArrayList<>();
	private static final String BOOK_FILE = "resources/books.txt";

	/**
	 * Constructs a BookDAOImplementation and loads books from file.
	 */
	public BookDAOImplementation() {
		loadBooksFromFile();
	}

	/**
	 * Adds a book to the system. If a book with the same title already exists, its
	 * count is incremented instead.
	 *
	 * @param book the Book object to be added; must not be null
	 * @throws IllegalArgumentException if the book is null
	 */
	@Override
	public void addBook(Book book) {
		if (book == null) {
			throw new IllegalArgumentException("Book cannot be null");
		}

		Optional<Book> existingBookOpt = findBookByTitle(book.getTitle());

		if (existingBookOpt.isPresent()) {
			for (int i = 0; i < book.getCount(); i++) {
				existingBookOpt.get().incrementCount();
			}
		} else {
			books.add(book);
		}
		saveBooksToFile();
	}

	/**
	 * Decrements the count of a book by title. If count reaches 0 or less, the book
	 * is marked as unavailable.
	 *
	 * @param title the title of the book to remove; must not be null or empty
	 * @throws IllegalArgumentException if the title is null or empty
	 */
	@Override
	public void removeBook(String title) {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be null or empty");
		}

		findBookByTitle(title).ifPresent(book -> {
			book.decrementCount();
			if (book.getCount() <= 0)
				book.setAvailable(false);
		});
		saveBooksToFile();
	}

	/**
	 * Searches for a book by its title.
	 *
	 * @param title the title of the book to find; must not be null
	 * @return an Optional containing the found Book, or empty if not found
	 * @throws IllegalArgumentException if the title is null
	 */
	@Override
	public Optional<Book> findBookByTitle(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Title cannot be null");
		}

		return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst();
	}

	/**
	 * Retrieves all books in the system.
	 *
	 * @return an unmodifiable list of Book objects; may be empty if no books exist
	 */
	@Override
	public List<Book> getAllBooks() {
		return Collections.unmodifiableList(books);
	}

	/**
	 * Saves the current list of books to the file system.
	 * 
	 * @throws RuntimeException if an I/O error occurs while saving
	 */
	@Override
	public void saveBooksToFile() {
		try {
			Path filePath = Paths.get(BOOK_FILE);
			Files.createDirectories(filePath.getParent());

			try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
				for (Book book : books) {
					writer.write(String.join(";", book.getTitle(), book.getAuthor(), String.valueOf(book.getCount()),
							String.valueOf(book.isAvailable())));
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.err.println("Error writing books: " + e.getMessage());
		}
	}

	/**
	 * Loads books from the file system into the internal list.
	 */
	private void loadBooksFromFile() {
		Path path = Paths.get(BOOK_FILE);
		if (!Files.exists(path))
			return;

		try (Stream<String> lines = Files.lines(path)) {
			lines.map(line -> line.split(";")).filter(parts -> parts.length == 4)
					.map(parts -> new Book(parts[0], parts[1], Integer.parseInt(parts[2]))).forEach(book -> {
						books.add(book);
						book.setAvailable(Boolean.parseBoolean(book.isAvailable() ? "true" : "false"));
					});
		} catch (IOException e) {
			System.err.println("Error loading books: " + e.getMessage());
		}
	}
}
