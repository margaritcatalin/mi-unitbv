package logingrafic;

import java.awt.*;

public class Login {
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
		f.setBackground(Color.pink);
		Label mesaj = new Label("Va rugam sa va autentificati!", Label.CENTER);
		mesaj.setFont(new Font("Verdana", Font.BOLD, 24));
		//mesaj.setBackground(Color.green);
		adauga(mesaj, 0, 0, 4, 2);

		Label etUsername = new Label("Username:");
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		adauga(etUsername, 0, 2, 1, 1);

		Label etPassword = new Label("Password:");
		adauga(etPassword, 0, 3, 1, 1);

		TextField username = new TextField("", 30);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		adauga(username, 1, 2, 2, 1);

		TextField passowrd = new TextField("", 30);
		adauga(passowrd, 1, 3, 2, 1);

		Button login = new Button("Login");
		login.setBackground(Color.green);
		gbc.fill = GridBagConstraints.NONE;
		adauga(login, 4, 2, 1, 2);

		Button register = new Button("Register");
		register.setBackground(Color.red);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		adauga(register, 1, 4, 1, 1);

		f.pack();
		f.show();
	}
}
