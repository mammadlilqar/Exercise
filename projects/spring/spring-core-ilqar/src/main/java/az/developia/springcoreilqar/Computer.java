package az.developia.springcoreilqar;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value = "comp")
public class Computer{
private String model;
private int price;
public Computer() {
	model="Acer";
	price=1333;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public int getPrice() {
	return price; 
}
public void setPrice(int price) {
	this.price = price;
}




}
