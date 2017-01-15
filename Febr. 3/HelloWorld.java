import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.lang.Comparable;

public class HelloWorld implements Comparable<HelloWorld> {
	public int myWorld;
	public HelloWorld(int i){
		myWorld = i;
	}

	public int compareTo (HelloWorld o){
		Integer a = new Integer(myWorld);
		Integer b = new Integer(o.myWorld);

		return -a.compareTo(b);
	}

	public static void main (String[] args){
		List<HelloWorld> list = new ArrayList<HelloWorld>();
		for (int i=0; i < 11; i++) {
			HelloWorld myObject = new HelloWorld(i);
			list.add(myObject);	
		}
		
		for (HelloWorld myObject : list){
			System.out.println(myObject.myWorld);
		}

		HelloWorld key = new HelloWorld(5);
		int found = Collections.binarySearch(list, key);
		System.out.println(found);
	}
}