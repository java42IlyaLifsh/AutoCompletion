package xcompany.util;
import java.util.Collection;
public interface AutoCompletionInterface {
	
//IlyaL28 
	
	boolean addWord(String str);
		 
	boolean removeWord(String str);
		 
	Collection<String> getCompletionOptions(String prefix);




}
