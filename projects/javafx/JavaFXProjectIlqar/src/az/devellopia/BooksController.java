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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class BooksController implements Initializable {
	boolean updateMode = false;
	private Integer selectedBookId = 0;
	private BookService bookService = new BookService();

	@FXML
	private TextField bookName, bookAuthor, searchTextfield;
	@FXML
	private Label messages;
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
	@FXML
	private ComboBox<String> bookLanguageCombo;

	public void saveBook() {
		String bookLang=bookLanguageCombo.getValue();
		String name = bookName.getText();
		if (name.length() < 2 || name.length() > 12) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj")
					.text("Simvol sayı minimum 3 və maksimum 12 ola bilər").show();

			return;
		}
		String author = bookAuthor.getText();
		if (author.length() < 3 || author.length() > 12) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj")
					.text("Simvol sayı minimum 3 və maksimum 12 ola bilər").show();

			return;
		}

		String secretCode = secretCodePF.getText();
		LocalDate publishDate = publishDateDP.getValue();
		if (publishDate == null) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Tarixi daxil edin").show();
			return;
		}
		Book b = new Book();
		b.setName(name);
		b.setAuthor(author);
		b.setSecretCode(secretCode);
		b.setPublishDate(publishDate);
		b.setLanguage(bookLang);

		if (updateMode) {
			b.setId(selectedBookId);
			bookService.update(b);
			updateMode = false;
		} else {
			bookService.add(b);
		}

		bookName.setText("");
		bookAuthor.setText("");
		secretCodePF.setText("");
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

		booksTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		List<String> languages = List.of("Azərbaycan", "Türk", "İngilis", "Rus", "Fransız", "Alman");
		bookLanguageCombo.getItems().addAll(languages);
		bookLanguageCombo.getSelectionModel().select(0);
	}

	public void deleteBook() {
		List<Book> selectedBooks = booksTable.getSelectionModel().getSelectedItems();
		if (selectedBooks.size() == 0) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Siyahıdan seçim et").show();

			return;
		}

		int a = JOptionPane.showConfirmDialog(null, "Silməyə əminsən?");
		if (a == 0) {
			for (Book selectedBook : selectedBooks) {

				Integer bookId = selectedBook.getId();
				bookService.delete(bookId);

			}
			showAllBooks();
		}
	}

	public void searchBook() {
		String searchValue = searchTextfield.getText();
		searchValue = searchValue.toLowerCase();
		if (searchValue.equals("")) {
			ObservableList<Book> list = FXCollections.observableArrayList();
			messages.setText("");
			booksTable.setItems(list);

		} else {
			Integer bookCount = bookService.findAllSearchCount(searchValue);

			if (bookCount == -1) {
				messages.setText("Axtarışı dəqiqləşdirin");

				return;
			}
			messages.setText("");
			List<Book> findAllSearch = bookService.findAllSearch(searchValue);
			ObservableList<Book> list = FXCollections.observableArrayList();
			list.addAll(findAllSearch);
			booksTable.setItems(list);
		}
	}

	public void editBook() {
		Book selectedBook = booksTable.getSelectionModel().getSelectedItem();

		if (selectedBook == null) {
			Notifications.create().hideAfter(Duration.seconds(2)).title("Mesaj").text("Siyahıdan seçim et").show();
			return;
		}
		bookName.setText(selectedBook.getName());
		bookAuthor.setText(selectedBook.getAuthor());
		publishDateDP.setValue(selectedBook.getPublishDate());
		secretCodePF.setText(selectedBook.getSecretCode());
        
		updateMode = true;
		selectedBookId = selectedBook.getId();
	}
}