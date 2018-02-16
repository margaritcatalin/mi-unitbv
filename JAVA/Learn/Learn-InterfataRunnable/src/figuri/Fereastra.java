package figuri;

import java.awt.*;
import java.awt.event.*;

public class Fereastra extends Frame {
	public Fereastra(String titlu) {
		super(titlu);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Plansa p1 = new Plansa("patrat", Color.blue);
		Plansa p2 = new Plansa("cerc", Color.red);
		setLayout(new GridLayout(1, 1));
		add(p1);
		add(p2);
		pack();
		new Thread(p1).start();
		new Thread(p2).start();
	}
}
