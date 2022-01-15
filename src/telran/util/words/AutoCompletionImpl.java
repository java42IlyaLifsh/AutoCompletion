package telran.util.words;
//IlyaL29
import java.util.*;
public class AutoCompletionImpl implements AutoCompletion {
	private TreeSet<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
 public AutoCompletionImpl() {
		
	}
 public AutoCompletionImpl(Collection<String> collection) {
		words.addAll(collection);
	}
 
	@Override
	public boolean addWord(String word) {
		
		return words.add(word);
	}

	@Override
	public boolean removeWord(String word) {
		
		return words.remove(word);
	}

	@Override
	public Iterable<String> getCompletionOptions(String prefix) {
		// V.R AutoCompletionUtils.getPrefixLimit() has to be called
		// instead of getPrefixLimit
		return words.subSet(prefix, getPrefixLimit(prefix));
	}
	// V.R. This method has to removed
	private String getPrefixLimit(String prefix) {
		char lastChar = prefix.charAt(prefix.length() - 1);
		char limitChar = (char) (lastChar + 1);
		return prefix.substring(0, prefix.length() - 1) + limitChar;

	}

}
