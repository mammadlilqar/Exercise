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
import java.util.Observable;
import java.util.ResourceBundle;

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

public class BooksController implements Initializable {
	@FXML
	private TextField bookName, bookPrice, pageCount, bookAuthor;
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
	private TableColumn<Book, Integer> priceColumn;
	@FXML
	private TableColumn<Book, Integer> pageCountColumn;
	@FXML
	private TableColumn<Book, String> authorColumn;
	@FXML
	private TableColumn<Book, Date> publishDateColumn;

	public void saveBook() {
		String name = bookName.getText();
		String price = bookPrice.getText();
		String pagecount = pageCount.getText();
		String author = bookAuthor.getText();
		String secretCode = secretCodePF.getText();
		LocalDate publishDate = publishDateDP.getValue();
		LocalDateTime registerTime = LocalDateTime.now();

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java9", "root", "1234");
			Statement st = conn.createStatement();
			st.executeUpdate("insert into books (name,price,page_Count,author,secret_code,publish_date,register_time) "
					+ "values('" + name + "','" + price + "','" + pagecount + "','" + author + "','" + secretCode
					+ "','" + publishDate + "','" + registerTime + "');");
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		showAllBooks();
	}

	private void showAllBooks() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java9", "root", "1234");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from books");
			ArrayList<Book> books = new ArrayList<>();
		
			while (rs.next()) {
				Book book = new Book();

				Integer id = rs.getInt("id");
				book.setId(id);

				String name = rs.getString("name");
				book.setName(name);

				Integer price = rs.getInt("price");
				book.setPrice(price);

				Integer pageCount = rs.getInt("page_count");
				book.setPageCount(pageCount);

				String author = rs.getString("author");
				book.setAuthor(author);

				Date publishDate = rs.getDate("publish_date");
				
			LocalDate publishdate=publishDate.toLocalDate();
				book.setPublishDate(publishdate);
				books.add(book);

			}

			ObservableList<Book> list = FXCollections.observableArrayList();
			list.addAll(books);
			booksTable.setItems(list);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("pageCount"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		publishDateColumn.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
		showAllBooks();

	}
}
