import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*
 *Have some recursive algorithm/statement that loops through the lines and store each character in a list.
 *Make sure to save their properties.
 *ex. if given "ehghi" e<=h<=g 
 *Compare to futures strings what you have stored
 */

public class RecoverHash {
	
	public void recover_hash() throws IOException {
		HashMap<String, String>tableOne=new HashMap<String,String>();
		Map<Long,ArrayList<String>> hashTable=new HashMap<Long, ArrayList<String>>();
		
	}
	
	
	public void test_recover_hash() throws IOException {
		recover_hash();
	}
	
	public static void main(String[] args) throws IOException {
		RecoverHash rh= new RecoverHash();
		rh.test_recover_hash();
	}
}