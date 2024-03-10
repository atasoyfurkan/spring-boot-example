package com.atasoy.examplewithchatgpt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import com.atasoy.examplewithchatgpt.dto.BookInputDTO;
import com.atasoy.examplewithchatgpt.dto.BookOutputDTO;
import com.atasoy.examplewithchatgpt.model.Author;
import com.atasoy.examplewithchatgpt.service.BookService;

@SpringBootTest
@ActiveProfiles("test")
public class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testCreateAndRetrieveBook() {
        // Arrange
        // String title = "Test Book Title";
        // Author author = new Author();
        // author.setName("Test Author");

        // BookInputDTO newBook = new BookInputDTO();
        // newBook.setTitle(title);
        // newBook.setAuthor(author);

        // // Act
        // BookOutputDTO createdBook = bookService.createBook(newBook);
        // BookOutputDTO retrievedBook = bookService.getBookById(createdBook.getId());

        // System.out.println("retrievedBook: " + retrievedBook);
    }

    // @Test
    // public void testCreateAndRetrieveBook() {
    // // Arrange
    // String title = "Test Book Title";
    // String author = "Test Author";

    // BookInputDTO newBook = new BookInputDTO();
    // newBook.setTitle(title);
    // newBook.setAuthor(author);

    // // Act
    // BookOutputDTO createdBook = bookService.createBook(newBook);
    // BookOutputDTO retrievedBook = bookService.getBookById(createdBook.getId());

    // // Assert
    // assertThat(retrievedBook).isNotNull();
    // assertThat(retrievedBook.getTitle()).isEqualTo(title);
    // assertThat(retrievedBook.getAuthor()).isEqualTo(author);

    // // Cleanup (optional if you have data.sql or a similar mechanism to reset DB)
    // bookService.deleteBook(createdBook.getId());
    // }
}
