import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

public class CollectionUtilTest{

	@Test
	public void map_returns_new_list_with_incremented_integerValues(){
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		ListMapper map = new Mapper();
		list.add(1); list.add(2); list.add(3);
		expected.add(2); expected.add(3); expected.add(4);
		List<Integer> result = CollectionUtils.map(list, map);
		for (int i=0; i<3; i++) 
			assertEquals(expected.get(i), result.get(i));
	}

	@Test
	public void filter_returns_new_list_of_even_numbers(){
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> expected = new ArrayList<Integer>();
		ListFilter map = new Filter();
		list.add(1); list.add(2); list.add(3); list.add(4);
		expected.add(2); expected.add(4);
		List<Integer> result = CollectionUtils.filter(list, map);
		for (int i=0; i<2; i++) 
			assertEquals(expected.get(i), result.get(i));
	}


}


