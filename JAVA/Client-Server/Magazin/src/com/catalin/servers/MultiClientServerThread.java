package com.catalin.servers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.catalin.model.Comanda;
import com.catalin.model.Detaliicomanda;
import com.catalin.model.Produs;
import com.catalin.model.User;
import com.catalin.protocols.UserProtocol;
import com.catalin.utils.States;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiClientServerThread implements Runnable {
	private Socket socket = null;

	public MultiClientServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Magazin");
		EntityManager entityManager = factory.createEntityManager();

		try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String inputLine, outputLine;
			UserProtocol userProtocol = new UserProtocol();
			outputLine = userProtocol.processInput(null);
			out.println(outputLine);

			User user = null;
			while ((inputLine = in.readLine()) != null) {
				outputLine = userProtocol.processInput(inputLine);
				if (outputLine.equals("EXIT")) {
					break;
				}
				if (userProtocol.getState() == States.SIGNUP) {
					out.println(outputLine);
					String username, password, confirmPassword, userType;
					username = in.readLine();
					outputLine = userProtocol.processInput("username_entered");
					out.println(outputLine);
					password = in.readLine();
					outputLine = userProtocol.processInput("password_entered");
					out.println(outputLine);
					confirmPassword = in.readLine();
					outputLine = userProtocol.processInput("password_reentered");
					out.println(outputLine);
					userType = in.readLine();

					Query query = entityManager
							.createQuery("select user from User user where " + "user.username = :user  ");
					query.setParameter("user", username);

					if (query.getResultList().isEmpty()) {
						if (password.equals(confirmPassword)) {
							User cont = new User();
							cont.setUsername(username);
							cont.setPassword(password);
							out.println("Enter money amount:");
							int moneyAmount;
							String money = in.readLine();
							moneyAmount = Integer.parseInt(money);
							cont.setBuget(moneyAmount);
							if (userType.equals("yes")) {
								cont.setTip(1);
							}
							entityManager.getTransaction().begin();
							entityManager.persist(cont);
							entityManager.getTransaction().commit();
							out.println("Successfully created account.");
						} else {
							out.println("Password not matching!");
						}
					} else {
						out.println("User already exists.");
					}
				} else if (userProtocol.getState() == States.LOGGING) {
					out.println(outputLine);
					String username, password;
					username = in.readLine();
					outputLine = userProtocol.processInput("username_entered");
					out.println(outputLine);
					password = in.readLine();
					outputLine = userProtocol.processInput("password_entered");
					out.println(outputLine);

					Query query = entityManager.createQuery("select user from User user where "
							+ "user.username = :user and user.password = :password ");
					query.setParameter("user", username);
					query.setParameter("password", password);

					if (!query.getResultList().isEmpty())
						user = (User) query.getSingleResult();
					if (user == null) {
						outputLine = userProtocol.processInput("unsuccessful");
						out.println(outputLine);
					} else {
						outputLine = userProtocol.processInput("successful");
						if (user.getTip() == 0)
							outputLine += "buyer";
						else if (user.getTip() > 0)
							outputLine += "seller";
						out.println(outputLine);
					}

				} else if (userProtocol.getState() == States.LOGGED) {
					switch (inputLine.toLowerCase()) {
					case "change password": {
						String oldPassword, newPassword, confirmNewPassword;
						out.println("Enter old password:");
						oldPassword = in.readLine();
						out.println("Enter new password:");
						newPassword = in.readLine();
						out.println("Confirm new password:");
						confirmNewPassword = in.readLine();
						try {
							user.changePassword(oldPassword, newPassword, confirmNewPassword);
							entityManager.getTransaction().begin();
							entityManager.persist(user);
							entityManager.getTransaction().commit();
							out.println("Password successfully changed.");
						} catch (IllegalArgumentException e) {
							outputLine = e.getMessage();
							out.println(outputLine);
						}
					}
					case "seeproducts": {
						if (user.getTip() > 0)
							out.println(user.getProduses().toString());
						out.println("The operation was successful.");
						break;
					}
					case "addproduct": {
						int cod, cantitate, pret;
						String denumire;
						out.println("Product code:");
						cod = Integer.parseInt(in.readLine());
						out.println("Product name:");
						denumire = in.readLine();
						out.println("Product price:");
						pret = Integer.parseInt(in.readLine());
						out.println("Product quantity:");
						cantitate = Integer.parseInt(in.readLine());

						Query query = entityManager
								.createQuery("select produs from Produs produs where produs.idProdus=:cod");
						query.setParameter("cod", cod);

						if (query.getResultList().isEmpty()) {
							Produs product = new Produs();
							product.setIdProdus(cod);
							product.setDenumire(denumire);
							product.setPret(pret);
							product.setStoc(cantitate);
							product.setUser(user);
							entityManager.getTransaction().begin();
							entityManager.persist(product);
							entityManager.getTransaction().commit();

							out.println("Successfully added product.");
						} else {
							out.println("Product already exists.");
						}
						break;
					}
					case "seeallproducts": {
						Query query = entityManager.createQuery("select produs from Produs produs");
						out.println(query.getResultList().toString());
						out.println("The operation was successful.");
						break;
					}
					case "search": {
						String product;
						out.println("Enter product code or name:");
						product = in.readLine();
						int codProdus;
						Query query = null;
						if (product.matches("[0-9]+")) {
							codProdus = Integer.parseInt(product);
							query = entityManager
									.createQuery("select produs from Produs produs where produs.idProdus=:codProdus");
							query.setParameter("codProdus", codProdus);
						} else {
							query = entityManager
									.createQuery("select produs from Produs produs where produs.denumire = :product");
							query.setParameter("product", product);
						}
						out.println(query.getResultList());
						out.println("The operation was successful.");
						break;
					}
					case "buy": {
						String product;
						out.println("Enter product code or name:");
						product = in.readLine();
						int codProdus;
						Query query = null;
						if (product.matches("[0-9]+$")) {
							codProdus = Integer.parseInt(product);
							query = entityManager
									.createQuery("select produs from Produs produs where produs.idProdus=:codProdus");
							query.setParameter("codProdus", codProdus);
						} else {
							query = entityManager
									.createQuery("select produs from Produs produs where produs.denumire = :product");
							query.setParameter("product", product);
						}
						Produs productToBuy = (Produs) query.getSingleResult();
						Comanda comanda = new Comanda();
						entityManager.getTransaction().begin();
						comanda.setUser(user);
						entityManager.persist(comanda);

						try {
							int cantitate = productToBuy.getStoc();
							if (cantitate > 0) {
								int price = productToBuy.getPret();
								if (price <= user.getBuget()) {
									// productToBuy.setStoc(cantitate - 1);
									if (null != entityManager) {
										EntityTransaction updateTransaction = entityManager.getTransaction();
										updateTransaction.begin();
										Query query1 = entityManager.createQuery(
												"UPDATE Produs p SET p.stoc = ?1 " + "WHERE p.idProdus = ?2");
										query1.setParameter(1, productToBuy.getStoc() - 1);
										query1.setParameter(2, productToBuy.getIdProdus());
										int updateCount = query1.executeUpdate();
										updateTransaction.commit();
									}
									Detaliicomanda detaliu = new Detaliicomanda();
									detaliu.setProdus(productToBuy);
									detaliu.setComanda(comanda);
									entityManager.persist(detaliu);
									entityManager.getTransaction().commit();
									// comanda.setPretTotal(comanda.getPretTotal() + price);
									if (null != entityManager) {
										EntityTransaction updateTransaction = entityManager.getTransaction();
										updateTransaction.begin();
										Query query2 = entityManager
												.createQuery("UPDATE Comanda c SET c.pretTotal =c.pretTotal+ ?1 "
														+ "WHERE c.idComanda = ?2");
										query2.setParameter(1, cantitate * productToBuy.getPret());
										query2.setParameter(2, comanda.getIdComanda());
										int updateCount = query2.executeUpdate();
										updateTransaction.commit();
									}
									// user.setBuget(user.getBuget() - price);
									if (null != entityManager) {
										EntityTransaction updateTransaction = entityManager.getTransaction();
										updateTransaction.begin();
										Query query3 = entityManager
												.createQuery("UPDATE User u SET u.buget = ?1 " + "WHERE u.idUser = ?2");
										query3.setParameter(1, (user.getBuget() - price));
										query3.setParameter(2, user.getIdUser());
										int updateCount = query3.executeUpdate();
										updateTransaction.commit();
									}
									entityManager.getTransaction().commit();
								} else {
									throw new IllegalStateException("Not enough money to buy");
								}
							} else {
								throw new IllegalStateException("Product out of stock");
							}
							out.println("Product successfully purchased.");
						} catch (IllegalStateException e) {
							out.println(e.getMessage());
						}
						break;
					}
					case "orders": {
						List<Comanda> comenzi = new ArrayList<>();
						try {
							TypedQuery<Comanda> query = entityManager
									.createQuery("SELECT c FROM Comanda c WHERE c.user = ?1 ", Comanda.class);
							query.setParameter(1, user);
							comenzi = query.getResultList();
							for (Comanda comanda : comenzi) {
								out.println("Comanda " + comanda.getIdComanda());
								TypedQuery<Produs> query1 = entityManager.createQuery(
										"SELECT p FROM Produs p JOIN p.detaliicomandas d WHERE d.comanda = ?1 ",
										Produs.class);
								query1.setParameter(1, comanda);
								List<Produs> produsecomandate = query1.getResultList();
								for (Produs detaliiComanda : produsecomandate) {
									out.println(detaliiComanda);
								}
								out.println("Comanda a fost platita cu " + comanda.getPretTotal());
							}
						} catch (NoResultException e) {
							out.println("Nu ai dat pana acum nicio comanda!");
						}
						out.println("The operation was successful.");
						break;
					}
					case "balance": {
						out.println("Bugetul tau este:" + user.getBuget());
						out.println("The operation was successful.");
						break;
					}
					default: {
						out.println("Aceasta optiune nu exista!");
						break;
					}
					}
				} else {
					out.println(outputLine);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
