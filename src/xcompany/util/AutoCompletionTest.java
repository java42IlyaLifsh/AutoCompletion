package xcompany.util;
//IlyaL28 
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AutoCompletionTest {
	
	
	private static final String PREFIX = "qwerty";
	LinkedList<String> ll = getRandomList();
	String first = ll.getFirst();
	String last = ll.getLast();
	AutoCompletionImpl instLL = new AutoCompletionImpl(new LinkedList());

	@BeforeEach
	void setUp() throws Exception {
		fillCollection(ll, instLL);
	}

	private void fillCollection(Collection<String> source, AutoCompletionImpl destination) {
		Iterator<String> itr = source.iterator();
		while(itr.hasNext()) {
			destination.addWord(itr.next());
		}
	}
	

	private LinkedList<String> getRandomList() {
		LinkedList<String> res = new LinkedList<>();
		res.add("qwerty123456789");
		res.add("5555599999");
		res.add("qwerty987654321");
		res.add("aaaaazzzzz");
		
		return res;
	}

	@Test
	void testAutoCompletionImpl() {
		Collection<String> llRemoved = instLL.getCompletionOptions(PREFIX);
		System.out.println(llRemoved.toString());
	}

	
	@Test
	void testRemoveWord() {
		assertTrue(instLL.removeWord(first));
		assertTrue(instLL.removeWord(last));
		assertFalse(instLL.removeWord("xxxx"));
	}

	

}
