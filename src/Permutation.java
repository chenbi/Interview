import java.util.ArrayList;
import java.util.List;
 public class Permutation {
 	/**
	 * @param args
	 */
	public static void main(String[] args) {
// 		List<String> list = new ArrayList<String>();
//		list.add("a");
		//permutation("", "abc");
		//permutation2("abcde",1,list);
//		List<String> t = permutation3("abcd", 0);
//		for (String s : t) {
//			System.out.println(s);
//		}
		
		permutation4("", "abcde123");

 	}
	

 	private static void permutation4(String prefix, String string) {
 	
	 	if (string.length()==0){	
	 		System.out.println(prefix); 		
	 	}
	 	else{
	 		for (int i=0; i<string.length(); i++){
	 			
	 			//System.out.print(string.charAt(i));
	 			
	 			//permutation4(string.substring(0, i)+string.substring(i+1, string.length()));
	 			permutation4(prefix+string.charAt(i), string.replace(String.valueOf(string.charAt(i)), "")); 			
	 		}
	 	
	 	}
 	}
	

 	 private static void permutation(String prefix, String str) {
 		    if (0 == str.length()) System.out.println(prefix);
		    else {
		        for (int i = 0; i < str.length(); i++)
		           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
		    }
 	}
 	 
 	private static List<String> permutation2(String string, int n,	List<String> list) {
 		if (string.length() != n) {
			ArrayList<String> l = new ArrayList<String>();
 			for (String s : list) {
 				for (int i = 0; i <= s.length(); i++) {
 					String temp = s.substring(0, i) + string.charAt(n)	+ s.substring(i);
 					l.add(temp);
 				}
 			}
 			permutation2(string, n + 1, l);
 		} else
			for (String s : list) {
				System.out.println(s);
 			}
 		return list;
 	}
 	
 	private static List<String> permutation3(String string, int n) {
 		if (n == string.length()) {
 			List<String> l =  new ArrayList<String>();
 			l.add("");
 			return l;
 		} else{ 			
 			List<String> l = permutation3(string, n+1);
 			List<String> t =  new ArrayList<String>();
 			for (String s : l) {
 				for (int i = 0; i <= s.length(); i++) {
 					String temp = s.substring(0, i) + string.charAt(n)	+ s.substring(i);
 					t.add(temp);
 				}
 			}
 			return t;
 			
 			
 		}

 	}
 	
 		
}
 	
 	

 