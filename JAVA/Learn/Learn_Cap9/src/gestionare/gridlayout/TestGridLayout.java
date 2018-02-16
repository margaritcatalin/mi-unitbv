package gestionare.gridlayout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class TestGridLayout {
public static void main(String[] args) {
	Frame f=new Frame("Test Grid Layout");
	f.setLayout(new GridLayout(3, 2));
	f.add(new Button("1"));
	f.add(new Button("2"));
	f.add(new Button("3"));
	f.add(new Button("4"));
	f.add(new Button("5"));
	f.add(new Button("6"));
	f.pack();
	f.show();
}
}
