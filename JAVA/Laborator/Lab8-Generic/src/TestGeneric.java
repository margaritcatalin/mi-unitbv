import java.util.ArrayList;

public class TestGeneric {
	public static void main(String[] args) {
		GenericObject o1 = new GenericObject();
		o1.setObj(3);
		System.out.println(o1.getObj());
		GenericObject o2 = new GenericObject();
		o2.setObj("test");
		System.out.println(o2.getObj());
		ArrayList<GenericObject> list1 = new ArrayList<GenericObject>();
		list1.add(o1);
		list1.add(o2);
		String s = (String) list1.get(1).getObj();
		GenericElement<String> e1 = new GenericElement<String>();
		e1.setObj("abc");
		String s1 = e1.getObj();
		ArrayList<Integer> listInt=new ArrayList<Integer>();
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		System.out.println(GenericElement.searchElement(listInt,2));
		ArrayList<Object> listObj=new ArrayList<Object>();
		listObj.add("test1");
		listObj.add("test2");
		listObj.add(listInt);
		System.out.println(GenericElement.searchElement1(listObj,listInt));
		GenericElement2<String,Integer> elem=new GenericElement2<String,Integer>();
		elem.setLeft("primul elem");
		elem.setRight(10);
		System.out.println(elem);
		
	}
}
