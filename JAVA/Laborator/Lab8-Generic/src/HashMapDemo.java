import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put("Elem1", 20.15);
		map.put("Elem2", 27.42);
		map.put("Elem3", 21.41);
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
		Set<Entry<String, Double>> element=map.entrySet();
		for(Entry<String, Double> elem:element) {
			System.out.println(elem.getKey()+" "+elem.getValue());
		}
		map.put("Elem2", 14.29);//modifica valoarea de la cheia respectiva
		System.out.println("___________");
		Set<Entry<String, Double>> elemente=map.entrySet();
		for(Entry<String, Double> elem:elemente) {
			System.out.println(elem.getKey()+" "+elem.getValue());
		}
	}
}
