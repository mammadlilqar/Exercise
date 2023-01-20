package az.developia;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class HomeController implements Initializable {

	@FXML
	private TextField bookName;

	@FXML
	private TextField bookPrice;

	@FXML
	private ComboBox<String> bookLanguage;

	@FXML
	private DatePicker bookPublishDate;

	@FXML
	private TableView<Book> booksTable;

	@FXML
	private TableColumn<Book, Integer> idColumn;

	@FXML
	private TableColumn<Book, String> languageColumn;

	@FXML
	private TableColumn<Book, String> nameColumn;

	@FXML
	private TableColumn<Book, Double> priceColumn;

	@FXML
	private TableColumn<Book, LocalDate> publishDateColumn;

	public void saveBook() {
		String bookNameValue = bookName.getText(); // " "
		bookNameValue = bookNameValue.trim();

		if (bookNameValue.equals("")) {
			Notifications.create().title("Mesaj").text("Kitabın adını boş qoyma!").position(Pos.BOTTOM_RIGHT)
					.hideAfter(Duration.seconds(2)).show();

			return;
		}

		if (bookNameValue.length() > 50) {
			Notifications.create().title("Mesaj").text("Kitabın adı maksimum 50 simvol olmalıdır!")
					.position(Pos.BOTTOM_RIGHT).hideAfter(Duration.seconds(2)).show();

			return;
		}

		String priceValue = bookPrice.getText();
		priceValue = priceValue.trim();

		if (priceValue.equals("")) {
			Notifications.create().title("Mesaj").text("Kitabın qiymətini boş qoyma!").position(Pos.BOTTOM_RIGHT)
					.hideAfter(Duration.seconds(2)).show();

			return;
		}

		Double bookPriceValue = Double.parseDouble(priceValue);

		String bookLanguageValue = bookLanguage.getValue();

		if (bookLanguageValue == null) {
			Notifications.create().title("Mesaj").text("Dil seçilməlidir!").position(Pos.BOTTOM_RIGHT)
					.hideAfter(Duration.seconds(2)).show();

			return;
		}

		LocalDate bookPublishDateValue = bookPublishDate.getValue();

		if (bookPublishDateValue == null) {
			Notifications.create().title("Mesaj").text("Kitabın nəşr tarixini daxil edin!").position(Pos.BOTTOM_RIGHT)
					.hideAfter(Duration.seconds(2)).show();

			return;
		}

		Book book = new Book(0, bookNameValue, bookPriceValue, bookLanguageValue, bookPublishDateValue);
		System.out.println(book);
		// bu melumatlari mysql de olan books cedveline daxil etmek

		String sqlQuery = "insert into books (name,price,language,publish_date)" + "values ('" + book.getName() + "','"
				+ book.getPrice() + "','" + book.getLanguage() + "','" + book.getPublishDate() + "')";

		try {

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/java8?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		showBooksOnTable();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		bookLanguage.getItems().add("Azerbaycan");
		bookLanguage.getItems().add("Alman");
		bookLanguage.getItems().add("Turk");
		bookLanguage.getItems().add("Ingilis");
		bookLanguage.getItems().add("Fransiz");

		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
		publishDateColumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));

		showBooksOnTable();
	}

	private void showBooksOnTable() {
		String sqlQuery = "select * from books";
		ArrayList<Book> books = new ArrayList<>();
		try {

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/java8?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery(sqlQuery);

			while (results.next()) {
				Book book = new Book(results.getInt("id"), results.getString("name"), results.getDouble("price"),
						results.getString("language"), results.getDate("publish_date").toLocalDate());

				books.add(book);
			}
			ObservableList<Book> list = FXCollections.observableArrayList();
			list.addAll(books);
			booksTable.setItems(list);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBook() {

		Book selectedBook = booksTable.getSelectionModel().getSelectedItem();
		if (selectedBook == null) {
			Notifications.create().title("Mesaj").text("Siyahidan secim olunmayib!").position(Pos.BOTTOM_RIGHT)
					.hideAfter(Duration.seconds(2)).show();
			return;
		}

		Integer selectedBookId = selectedBook.getId();
		String sqlQuery = "delete from books where id=" + selectedBookId;

		try {

			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/java8?useSSL=false&serverTimezone=UTC", "root", "1234");

			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlQuery);
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		showBooksOnTable();

	}
}
