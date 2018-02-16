import java.io.Serializable;

public class Car implements Serializable{
private Owner owner;
private String brand;
private String model;
private Integer year;
public Car(Owner o,String brand,String model,Integer year) {
	this.owner=o;
	this.brand=brand;
	this.model=model;
	this.year=year;// TODO Auto-generated constructor stub
}
public Owner getO() {
	return owner;
}
public void setO(Owner o) {
	this.owner = o;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public Integer getYear() {
	return year;
}
public void setYear(Integer year) {
	this.year = year;
}
@Override
public String toString() {
	return "Car [owner=" + owner + ", brand=" + brand + ", model=" + model + ", year=" + year + "]";
}

}
