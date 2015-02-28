import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class CollectionUtilTest{

	@Test
	public void map_returns_new_list_with_incremented_integerValues(){
		List<String> list = new ArrayList<String>();
		List<Integer> expected = new ArrayList<Integer>();
		ListMapper<Integer,String> map = new Mapper();
		list.add("1"); list.add("2"); list.add("3");
		expected.add(1); expected.add(2); expected.add(3);
		
		List<Integer> result = CollectionUtils.map(list, map);
		for (int i=0; i<3; i++) 
			assertEquals(expected.get(i), result.get(i));
	}

	@Test
	public void filter_returns_new_list_of_even_numbers(){
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		ListFilter<Integer,Integer> filter = new Filter();
		list.add(1); list.add(2); list.add(3); list.add(4);
		expected.add(2); expected.add(4);
		
		List<Integer> result = CollectionUtils.filter(list, filter);
		for (int i=0; i<2; i++) 
			assertEquals(expected.get(i), result.get(i));
	}

	@Test
	public void reduce_returns_total_length_of_all_strings_in_the_list(){
		List<String> list = new ArrayList<String>();
		ListReducer<String,Integer> reduce = new Reducer();
		list.add("hiii"); list.add("vikas"); list.add("bye"); list.add("vikas");
		
		int result = CollectionUtils.str_reduce(list, reduce, 0);
		assertEquals(result, 17);
	}

	@Test
	public void reduce_returns_0_as_length_of_all_strings_in_the_list_are_empty(){
		List<String> list = new ArrayList<String>();
		ListReducer<String,Integer> reduce = new Reducer();
		list.add(""); list.add(""); list.add(""); list.add("");
		
		int result = CollectionUtils.str_reduce(list, reduce, 0);
		assertEquals(result, 0);
	}

	@Test
	public void reduce_returns_as_length_of_all_strings_in_the_list_are_empty(){
		List<Integer> list = new ArrayList<Integer>();
		ListReducer<Integer,Integer> reduce = new Reducer1();
		list.add(5); list.add(5); list.add(5); list.add(5);
		
		int result = CollectionUtils.int_reduce(list, reduce, 0);
		assertEquals(result, 20);
	}
}
