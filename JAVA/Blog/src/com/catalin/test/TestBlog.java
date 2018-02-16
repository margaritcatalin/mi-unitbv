package com.catalin.test;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import com.catalin.connections.DataAccessLayer;
import com.catalin.models.User;
import com.catalin.utils.States;

public class TestBlog {
	public static void printNotLoggedMenu() {
		System.out.println("Introdu \'1\' pentru inregistrare.\n" + "Introdu \'2\' pentru autentificare.\n"
				+ "Introdu \'0\' pentru a iesi.");
	}

	public static void printLoggedMenu() {
		System.out.println("0.Exit\r\n" + "1.LogOut\r\n" + "2.ChangePassword\r\n" + "3.Bloguri postate\r\n"
				+ "4.Cauta o postare dupa titlu\r\n" + "5.Postari existente\r\n" + "6.Adauga o postare\r\n"
				+ "7.Sterge o postare\r\n" + "8.Adauga un comentariu\r\n" + "9.Accepta un comentariu\r\n"
				+ "10.Vezi comentariile unui post");
	}

	public static void main(String[] args) {
		DataAccessLayer dal = new DataAccessLayer();
		Scanner sc = new Scanner(System.in);
		States state = States.WAITING;
		User l = new User();
		boolean start = true;
		while (start) {
			switch (state) {
			case WAITING: {
				state = States.NOTLOGGED;
				break;
			}
			case NOTLOGGED: {
				printNotLoggedMenu();
				switch (Integer.parseInt(sc.nextLine())) {
				case 0: {
					state = States.EXIT;
					break;
				}
				case 1: {
					dal.register();
					state = States.SIGNUP;
					break;
				}
				case 2: {
					l = dal.login(l, sc);
					if (l == null) {
						System.out.println("Datele dumneavoastra de utlizator nu stunt corecte!");
						state = States.NOTLOGGED;
					} else
						state = States.LOGGED;
					break;
				}
				default:
					System.out.println("Alegeti o optiune valida!");
					break;
				}
				break;
			}
			case SIGNUP: {
				state = States.NOTLOGGED;
				break;
			}
			case LOGGED: {
				printLoggedMenu();
				switch (Integer.parseInt(sc.nextLine())) {
				case 0: {
					state = States.EXIT;
					break;
				}
				case 1: {
					System.out.println("V-ati deconectat cu succes!");
					state = States.NOTLOGGED;
					break;
				}
				case 2: {
					dal.changePassword(l, sc);
					System.out.println("Va rugam sa va autentificati!");
					state = States.NOTLOGGED;
					break;
				}
				case 3: {
					dal.bloguriPostate(l);
					break;
				}
				case 4: {
					System.out.println("Introduceti Titlul:");
					System.out.println(dal.cautareTitlu(sc.nextLine()).toString());
					break;
				}
				case 5: {
					dal.postariExistente();
					break;
				}
				case 6: {
					dal.adaugaPostare(l);
					break;
				}
				case 7: {
					dal.removePost(l, sc);
					break;
				}
				case 8: {
					dal.adaugaComentariu(l, sc);
					break;
				}
				case 9: {
					dal.acceptaComentariu(l, sc);
					break;
				}
				case 10: {
					dal.comentariiPost();
					break;
				}
				default: {
					System.out.println("Alegeti o optiune valida!");
					break;
				}
				}
				break;
			}
			case EXIT: {
				System.out.println("La revedere!");
				start = false;
				break;
			}
			}
		}
	}
}
