package xcompany.util;
//IlyaL28 
import java.util.Collection;
import java.util.TreeSet;

public class AutoCompletionImpl implements AutoCompletionInterface {
	Collection<String> collection;

	public AutoCompletionImpl(Collection<String> collection) {
		this.collection = collection;
	}

	@Override
	public boolean addWord(String str) {
	 
		return collection.add(str);
	}

	@Override
	public boolean removeWord(String str) {
 
		return collection.remove(str);
	}
	@Override
	public Collection<String> getCompletionOptions(String prefix) {
	 
		TreeSet<String> searched = new TreeSet<String>(collection);		
		searched.removeIf(str -> !str.startsWith(prefix));		
		return searched;
	}

}
