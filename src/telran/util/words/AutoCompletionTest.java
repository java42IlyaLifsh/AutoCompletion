package telran.util.words;
//IlyaL29
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class AutoCompletionTest {

	String words[]= {"abcdef","ab123","aaa","ab","ablmn","abbbb",
			"a", "ABd","bbb", "B12"};
	String wordsStartB[] = {"B12", "bbb"};
	String wordsStartAB[] = {"ab","ab123","abbbb","abcdef","ABd","ablmn"};
	String wordsStartABC[] = {"abcdef"};
	AutoCompletion autoCompletion;
		@BeforeEach
		void setUp() throws Exception {
			autoCompletion = new AutoCompletionMapImpl();
			for(String word: words) {
				autoCompletion.addWord(word);
			}
				
				
		}

		@Test
		void testCompletionOptions() {
			assertIterableEquals(Arrays.asList(wordsStartABC),
					autoCompletion.getCompletionOptions("abc"));
			assertIterableEquals(Arrays.asList(wordsStartB), autoCompletion.getCompletionOptions("B"));
			assertIterableEquals(Arrays.asList(wordsStartAB), autoCompletion.getCompletionOptions("ab"));
			
		}
		@Test
		void testRemoveIf_1() {
			assertEquals(8, ((AutoCompletionMapImpl) autoCompletion).removeIf(p -> p.length() >= 3));
			
		}
		@Test
		void testRemoveIf_2() {
			assertEquals(5, ((AutoCompletionMapImpl) autoCompletion)
					.removeIf(p -> p.startsWith("ab") || p.startsWith("CC")));
			
		}
		@Test
		void testRemoveIf_3() {
			assertEquals(0, ((AutoCompletionMapImpl) autoCompletion).removeIf(p -> p.endsWith("EEE")));
			
		}

}
