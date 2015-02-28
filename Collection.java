import java.util.List;
import java.util.ArrayList;


interface ListMapper{
	public List<Integer> giveList(List<Integer> list);
}

interface ListFilter{
	public List<Integer> giveEven(List<Integer> list);
}

class Mapper implements ListMapper{
	public List<Integer> giveList(List<Integer> list){
		List<Integer> new_list = new ArrayList<Integer>();
		for (Integer i:list) {
			new_list.add(i+1);
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
	public static List<Integer> map(List<Integer> list, ListMapper mapper){
		return mapper.giveList(list);
	}
	public static List<Integer> filter(List<Integer> list, ListFilter filter){
		return filter.giveEven(list);
	}
}

public class Collection{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		ListFilter lm = new Filter();
		list.add(1); 
		list.add(2); 
		list.add(3);
		list.add(4);
		List<Integer> result = CollectionUtils.filter(list, lm);
		for (Integer i : result) {
			System.out.println(i);
		}
	}
};