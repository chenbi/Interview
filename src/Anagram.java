import java.util.HashMap;
import java.util.Map;

/* 
 * Author: Chen Bi
 * Email: chen.bi@mail.mcgill.ca
 * The method returns true if the two arguments are anagrams of each other, false if they are not
 * For example, anagram(“glob”, “blog”) would return true; anagram(“glob”, “blag”) false.
 * Algorithm: use a hash map to store count difference of each char in each string. If 2 strings are anagram,
 * they should have no count difference of each char
 * Performance: Big (O) = n, linear
 */

public class Anagram {
	
	public static void main(String[] args) {
		System.out.println("anagram(\"glob\", \"blog\"): "+ anagram("glob", "blog"));  //true
		System.out.println("anagram(\"glob\", \"blog\"): "+ anagram("gl o b", "blog")); //true, ignore spaces
		System.out.println("anagram(\"glob\", \"blag\"): "+ anagram("glob", "blag"));//false
		System.out.println("anagram(\"glob\", \"blag\"): "+ anagram("glob", "bl a g"));//false, ignore spaces
	}
	
	public static boolean anagram(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;

		String s1 = str1.toLowerCase(); // convert all chars in string to lower case, big (O) = n
		String s2 = str2.toLowerCase();

		Map<Character, Integer> charCount = new HashMap<>(); //map to hold frequency of each char in string
		
		
		//s1 and s2 may have different length due to spaces, so loop through each string, big (O) = n
		for (int i = 0; i < s1.length(); i++) { 			
			char c = s1.charAt(i);			
			if (Character.isLetter(c)){ //ignore spaces, only count letters
				int count = charCount.containsKey(c) ? charCount.get(c) : 0;
				charCount.put(c, ++count); //count each char in str1, big (O) = 1
			}
		}
		
		for (int j = 0; j < s2.length(); j++) {
			char c = s2.charAt(j);
			if (Character.isLetter(c)){ //ignore spaces, only count letters
				int count = charCount.containsKey(c) ? charCount.get(c) : 0;
				charCount.put(c, --count); //count each char in str2, big (O) = 1
			}
		}

		for (Integer diff : charCount.values()) { //big (O) = n
			if (diff != 0) //if counts of each char in each string are NOT the same 
				return false;
		}
		return true;
	}
}
