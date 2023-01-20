package az.developia;

import java.time.LocalDate;

public class Book {
private Integer id;
private String name;
private Double price;
private String language;
private LocalDate publishDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public LocalDate getPublishDate() {
	return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
	this.publishDate = publishDate;
}
public Book(Integer id, String name, Double price, String language, LocalDate publishDate) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.language = language;
	this.publishDate = publishDate;
}
@Override
public String toString() {
	return "Book [id=" + id + ", name=" + name + ", price=" + price + ", language=" + language + ", publishDate="
			+ publishDate + "]";
}

}
