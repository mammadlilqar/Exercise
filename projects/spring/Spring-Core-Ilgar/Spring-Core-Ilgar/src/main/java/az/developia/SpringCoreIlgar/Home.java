package az.developia.SpringCoreIlgar;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope(scopeName = "prototype")
@Component
public class Home {
private int id;
private String adress;
private String colour;

public Home(){
	id=23;
	adress="Baku,Nasimi district";
	colour="red";
}
public void init() {
	System.out.println("init");
}
public void destroy() {
	System.out.println("destroy");
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}



}
