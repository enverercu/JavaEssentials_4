package Design.Prototype;
import java.util.*;
//The concept is to copy an existing object rather than creating a new instance from cache, something that may include costly operations.
//The newly copied object may change same properties only if required.
abstract class Data implements Cloneable{		
	@Override
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
class StudentData extends Data{
	private List<Integer> list = new ArrayList<Integer>();
	public StudentData(){
		for(int i=0;i<10000;i++){
			list.add(i);
		}
	}
}
class DataCache{
	private static HashMap<String,StudentData> map = new HashMap<String,StudentData>();
	static{
		map.put("StudentData", new StudentData());
	}
	public static Data getData(String dataName){
		Data data = map.get(dataName);
		return (Data)data.clone();
	}
}

public class AAPrototype {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Data data;
		for(int i=0;i<1000;i++){
			data = new StudentData();
		}
		long end = System.currentTimeMillis();
		System.out.println("New() cost:" + (end-start));
		
		start = System.currentTimeMillis();
		DataCache cache = new DataCache();
		Data clone;
		for(int i=0;i<1000;i++){
			clone = DataCache.getData("StudentData");
		}
		end = System.currentTimeMillis();
		System.out.println("Clone cost:" + (end-start));
	}

}
