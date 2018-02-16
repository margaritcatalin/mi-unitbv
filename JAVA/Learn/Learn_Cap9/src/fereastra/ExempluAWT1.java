package fereastra;

import java.awt.*;

public class ExempluAWT1 {
public static void main(String[] args) {
	Frame f=new Frame("O fereastra");
	f.setLayout(new FlowLayout());
	Button b1=new Button("OK");
	Button b2=new Button("Cancel");
	Button b=new Button("Hello");
	Label et=new Label("Nume:");
	TextField text=new TextField();
	Panel panel =new Panel();
	panel.add(et);
	panel.add(text);
	f.add(panel);
	f.add(b);
	f.add(b1);
	f.add(b2);
	f.pack();
	f.show();
}
}
