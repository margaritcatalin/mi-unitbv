package cirireatomi;
import java.io.*;
public class CitireAtomi {
public static void main(String[] args) throws IOException {
	BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\catal\\eclipse-workspace\\Learn2\\src\\cirireatomi\\fisier.txt"));
	StreamTokenizer st=new StreamTokenizer(br);
	int tip=st.nextToken();
	while(tip!=StreamTokenizer.TT_EOF) {
		switch(tip) {
		case StreamTokenizer.TT_WORD:
			System.out.println("Cuvant: " +st.sval);
			break;
		case StreamTokenizer.TT_NUMBER:
			System.out.println("Numar:"+st.nval);
		}
		tip=st.nextToken();
	}
}
}
