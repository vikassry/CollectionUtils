import java.util.*;

interface ListMapper<E,K>{
	public List<E> giveList(List<K> list);
}

interface ListFilter<E,K>{
	public List<Integer> giveEven(List<Integer> list);
}

interface ListReducer<E,K>{
	public K giveTotalLength(List<E> list,  K initial);
}


class Mapper implements ListMapper<Integer,String>{
	public List<Integer> giveList(List<String> list){
		List<Integer> new_list = new ArrayList<Integer>();
		for (String i:list)
			new_list.add(Integer.parseInt(i));
		return new_list;	
	}
}

class Filter implements ListFilter<Integer,Integer>{
	public List<Integer> giveEven(List<Integer> list){
		List<Integer> filtered_list = new ArrayList<Integer>();
		for (Integer i:list)
			if(i%2==0) filtered_list.add(i);
		return filtered_list;
	}
}

class Reducer implements ListReducer<String, Integer>{
	public Integer giveTotalLength(List<String> list,Integer initial){
		for (String str : list) 
			initial += str.length();
		return initial;
	}
}

class Reducer1 implements ListReducer<Integer, Integer>{
	public Integer giveTotalLength(List<Integer> list,Integer initial){
		for (Integer i : list) 
			initial += i;
		return initial;
	}
}


class CollectionUtils{
	public static List<Integer> map(List<String> list, ListMapper<Integer,String> mapper){
		return mapper.giveList(list);
	}
	public static List<Integer> filter(List<Integer> list, ListFilter<Integer,Integer> filter){
		return filter.giveEven(list);
	}
	public static Integer str_reduce(List<String> list, ListReducer<String,Integer> reduce, Integer initial){
		return reduce.giveTotalLength(list, initial);
	}
	public static Integer int_reduce(List<Integer> list, ListReducer<Integer,Integer> reduce, Integer initial){
		return reduce.giveTotalLength(list, initial);
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