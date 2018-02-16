package gestionare.panel;

import java.awt.*;
public class TestPanel {
	public static void main(String[] args) {
		Frame f = new Frame("Panel Test");
		Panel intro = new Panel();
		intro.setLayout(new GridLayout(1, 3));
		intro.add(new Label("Text:"));
		intro.add(new TextField("", 20));
		intro.add(new Button("Adaugare"));
		
		Panel lista=new Panel();
		lista.setLayout(new FlowLayout());
		lista.add(new List(10));
		lista.add(new Button("Stergere"));
		
		Panel control=new Panel();
		control.add(new Button("Salvare"));
		control.add(new Button("Iesire"));
		
		f.add(intro,BorderLayout.NORTH);
		f.add(lista,BorderLayout.CENTER);
		f.add(control,BorderLayout.SOUTH);
		
		f.pack();
		f.show();
	}
	
}
