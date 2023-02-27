package az.devellopia;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.management.Notification;
import javax.swing.JOptionPane;

import org.controlsfx.control.Notifications;

import az.devellopia.service.BookService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class BooksController implements Initializable {
	private BookService bookService = new BookService();

	@FXML
	private TextField bookName, bookAuthor,searchTextfield;
	@FXML
	private PasswordField secretCodePF;
	@FXML
	private DatePicker publishDateDP;
	@FXML
	private TableView<Book> booksTable;
	@FXML
	private TableColumn<Book, Integer> idColumn;
	@FXML
	private TableColumn<Book, String> nameColumn;
	@FXML
	private TableColumn<Book, String> authorColumn;
	@FXML
	private TableColumn<Book, Date> publishDateColumn;

	public void saveBook() {
		String name = bookName.getText();
		String author = bookAuthor.getText();
		String secretCode = secretCodePF.getText();
		LocalDate publishDate = publishDateDP.getValue();

		Book b = new Book();
		b.setName(name);
		b.setAuthor(author);
		b.setSecretCode(secretCode);
		b.setPublishDate(publishDate);
		bookService.add(b);
		showAllBooks();
	}

	private void showAllBooks() {
		ObservableList<Book> list = FXCollections.observableArrayList();
		list.addAll(bookService.findAll());
		booksTable.setItems(list);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		publishDateColumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
		showAllBooks();

	}

	public void deleteBook() {
		Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
		if (selectedBook == null) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Siyahıdan seçim et").show();;
            return;
		}
int a=JOptionPane.showConfirmDialog(null, "Silməyə əminsən?");
if(a==0) {		
Integer bookId = selectedBook.getId();
		bookService.delete(bookId);
		showAllBooks();
	}}
	
	public void searchBook() {
		String searchValue=searchTextfield.getText();
		List<Book> findAllSearch= bookService.findAllSearch(searchValue);
		ObservableList<Book> list = FXCollections.observableArrayList();
		list.addAll(findAllSearch);
		booksTable.setItems(list);
	}
	
}
