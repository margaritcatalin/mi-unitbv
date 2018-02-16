import java.io.Serializable;
import java.util.ArrayList;

public class ObjectToSerialize implements Serializable{
private ArrayList<Car> cars;
public ObjectToSerialize(ArrayList<Car> cars) {
	
	this.cars=cars;
}
public ArrayList<Car> getCars() {
	return cars;
}

public void setCars(ArrayList<Car> cars) {
	this.cars = cars;
}
@Override
public String toString() {
	return "ObjectToSerialize [cars=" + cars + "]";
}

}
