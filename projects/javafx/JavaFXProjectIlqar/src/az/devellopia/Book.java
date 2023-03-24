package az.devellopia;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Book {
private Integer id;
private String name;
private String author;
private LocalDate publishDate;
private String secretCode;
private LocalDateTime registerTime;
private String language;

public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getSecretCode() {
	return secretCode;
}
public void setSecretCode(String secretCode) {
	this.secretCode = secretCode;
}
public LocalDateTime getRegisterTime() {
	return registerTime;
}
public void setRegisterTime(LocalDateTime registerTime) {
	this.registerTime = registerTime;
}
public LocalDate getPublishDate() {
	return publishDate;
}
public void setPublishDate(LocalDate publishDate) {
	this.publishDate = publishDate;
}
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
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}



}
