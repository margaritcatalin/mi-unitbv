package gestionare.gridbaglayout;

import java.awt.*;

public class TestGridBagLayout {
	static Frame f;
	static GridBagLayout gridBag;
	static GridBagConstraints gbc;

	static void adauga(Component comp, int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gridBag.setConstraints(comp, gbc);
		f.add(comp);
	}

	public static void main(String[] args) {
		f = new Frame("Login screen");
		gridBag = new GridBagLayout();
		gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5, 5, 5, 5);
		f.setLayout(gridBag);
		Label mesaj = new Label("Va rugam sa va autentificati!", Label.CENTER);
		mesaj.setFont(new Font("Arial", Font.BOLD, 24));
		mesaj.setBackground(Color.green);
		adauga(mesaj, 0, 0, 4, 2);

		Label etNume = new Label("Username:");
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		adauga(etNume, 0, 2, 1, 1);

		Label etLevel = new Label("Password:");
		adauga(etLevel, 0, 3, 1, 1);

		TextField nume = new TextField("", 30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		adauga(nume, 1, 2, 2, 1);

		TextField plictiseala = new TextField("", 30);
		adauga(plictiseala, 1, 3, 2, 1);

		Button adaugare = new Button("Login");
		gbc.fill = GridBagConstraints.NONE;
		adauga(adaugare, 4, 2, 1, 2);

		Button salvare = new Button("Register");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		adauga(salvare, 1, 4, 1, 1);

		f.pack();
		f.show();
	}
}
