package adrese;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestAdrese {
	public static void showLocalHost() {
		String localHostAdress = null;
		String localHostName = null;

		try {
			localHostAdress = new String(InetAddress.getLocalHost().getHostAddress());
			localHostName = new String(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		// 1
		System.out.println("Local host adress: " + localHostAdress);
		System.out.println("Local host name: " + localHostName);

	}

	public static void searchHostName(String searchedHostName) {
		InetAddress[] iNetAdresses = null;
		try {
			iNetAdresses = InetAddress.getAllByName(searchedHostName);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Ip list:");
		for (int i = 0; i < iNetAdresses.length; i++) {
			System.out.println(iNetAdresses[i].getHostAddress());
		}
	}

	public static void searchIpAdress(String searchedIpString) {
		byte[] searchedIpList = new byte[4];
		int i = 0;
		StringTokenizer tok = new StringTokenizer(searchedIpString, ".");
		while (tok.hasMoreTokens()) {
			searchedIpList[i++] = (byte) Integer.parseInt(tok.nextToken(), 10);
		}
		InetAddress inetAdressForSearchedIp = null;
		try {
			inetAdressForSearchedIp = InetAddress.getByAddress(searchedIpList);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		System.out.println("Name:" + inetAdressForSearchedIp.getHostName());
		System.out.println("Adress: " + inetAdressForSearchedIp.getHostAddress());

	}

	public static void viewURLInfo(String specifiedWebAdress) {
		URL url;

		try {
			url = new URL(specifiedWebAdress);
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			String fileName = "webFile.html";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

			while ((inputLine = br.readLine()) != null) {
				bw.write(inputLine);
			}

			bw.close();
			br.close();

			System.out.println("Done");

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		showLocalHost();

		Scanner sc = new Scanner(System.in);
		String searchedHostName = null;
		String searchedIpString = null;
		System.out.println("Searched name: ");
		searchedHostName = new String(sc.nextLine());
		searchHostName(searchedHostName);

		System.out.println();
		System.out.println("Searched ip: ");
		searchedIpString = sc.nextLine();
		searchIpAdress(searchedIpString);

		String specifiedWebAdress = null;
		System.out.println();
		System.out.println("Adresa WEB specificata");
		specifiedWebAdress = new String(sc.nextLine());
		viewURLInfo(specifiedWebAdress);
		sc.close();

	}

}
