import java.util.List;
import java.util.ArrayList;


interface ListMapper{
	public List<Integer> GiveList(List<Integer> list);
}

class Mapper implements ListMapper{
	public List<Integer> GiveList(List<Integer> list){
		List<Integer> l = new ArrayList<Integer>();
		for (Integer i:list) {
			l.add(i+1);
		}
		return l;	
	}
}

class CollectionUtils{
	public static List<Integer> map(List<Integer> list, ListMapper mapper){
		return mapper.GiveList(list);
	}
}

public class Collection{
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		ListMapper lm = new Mapper();
		list.add(1); 
		list.add(2); 
		list.add(3);
		list.add(4);
		List<Integer> result = CollectionUtils.map(list, lm);
		for (Integer i : result) {
			System.out.println(i);
		}
	}
};