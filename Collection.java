import java.util.*;


// interface ListMapper{
// 	public List<Integer> giveList(List<Integer> list);
// }

interface ListMapper<E,K>{
	public List<Integer> giveList(List<String> list);
}


interface ListFilter{
	public List<Integer> giveEven(List<Integer> list);
}

class Mapper implements ListMapper<Integer,String>{
	public List<Integer> giveList(List<String> list){
		List<Integer> new_list = new ArrayList<Integer>();
		for (String i:list) {
			new_list.add(Integer.parseInt(i));
		}
		return new_list;	
	}
}

class Filter implements ListFilter{
	public List<Integer> giveEven(List<Integer> list){
		List<Integer> filtered_list = new ArrayList<Integer>();
		for (Integer i:list) {
			if(i%2==0) filtered_list.add(i);
		}
		return filtered_list;
	}
}

class CollectionUtils{
	public static List<Integer> map(List<String> list, ListMapper<Integer,String> mapper){
		return mapper.giveList(list);
	}
	public static List<Integer> filter(List<Integer> list, ListFilter filter){
		return filter.giveEven(list);
	}
}

public class Collection{
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		ListMapper<Integer, String> lm = new Mapper();
		list.add("1"); 
		list.add("2"); 
		list.add("3");
		list.add("4");
		List<Integer> result = CollectionUtils.map(list, lm);
		for (Integer i : result) {
			System.out.println(i);	
		}
	}
};