package ListareFisiereCuExtensia;

import java.io.*;

public class Listare {
	public static void main(String[] args) {
		try {
			File director = new File(".");
			String[] list;
			if (args.length > 0)
				list = director.list((FilenameFilter) new File(args[0]));
			else
				list = director.list();
			for (int i = 0; i < list.length; i++)
				System.out.println(list[i]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
