
import java.util.*;
public class Unico{
	static public List<String> unico(List<String> a){
		HashMap<String,String> map = new HashMap<String,String>();
		for(String key: a){
			if(map.get(key)!=null){
				map.remove(key);
			}else{
				map.put(key,key);
			}
		}
		ArrayList<String> finalL = new ArrayList<String>();
		for(String st:map.values()){
			finalL.add(st);
		}
		return finalL;
	}
	public static void main(String... args){
		List<String> a= Arrays.asList("a","t","b","a","h","v","b","t","g");
		List<String> result = unico(a);
		Collections.sort(result);
		assert(result.equals(Arrays.asList("g","h","v")));
		System.out.println("Test Passes");
	};
}