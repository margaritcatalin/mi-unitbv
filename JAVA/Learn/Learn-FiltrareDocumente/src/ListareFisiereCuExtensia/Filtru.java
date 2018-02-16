package ListareFisiereCuExtensia;

import java.io.File;
import java.io.FilenameFilter;

public class Filtru implements FilenameFilter {
	String extensie;
	Filtru(String extensie){
		this.extensie=extensie;
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return (name.endsWith("."+extensie));
	}

}
