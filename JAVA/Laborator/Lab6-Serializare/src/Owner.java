import java.io.Serializable;

public class Owner implements Serializable{
private String fName;
private String lName;
public Owner(String fN,String lN) {
	this.setfName(fN);
	this.setlName(lN);
}

public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}

@Override
public String toString() {
	return "Owner [fName=" + fName + ", lName=" + lName + "]";
}

}
