package figuri;

import java.awt.*;
import java.awt.event.*;

public class Plansa extends Canvas implements Runnable {
	Dimension dim = new Dimension(300, 300);
	Color culoare;
	String figura;
	int x = 0, y = 0, r = 0;

	public Plansa(String figura, Color culoare) {
		this.figura = figura;
		this.culoare = culoare;
	}

	public Dimension getPreferedSize() {
		return dim;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, dim.width - 1, dim.height - 1);
		g.setColor(culoare);
		if (figura.equals("patrat"))
			;
		g.drawRect(x, y, r, r);
		if (figura.equals("cerc"))
			g.drawOval(x, y, r, r);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			x = (int) (Math.random() * dim.width);
			y = (int) (Math.random() * dim.height);
			r = (int) (Math.random() * 100);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Asteptati putin!");
			}
			repaint();
		}
	}
}
