import java.util.*;

/* 
 * Author: Chen Bi
 * Email: chen.bi@mail.mcgill.ca
 * In UniqueHashMap, each value in the map is always unique
 */

public class UniqueHashMap<V, K> extends HashMap<K, V> {

	public V put(K key, V value) {
		
		Set<K> keySets = this.keySet(); // get set of keys in the map
		
		Iterator<K> keyIterator = keySets.iterator();

		while (keyIterator.hasNext()) { //loop through the map
			K keyLookup = keyIterator.next();
			V valueLookup = super.get(keyLookup);
			if (valueLookup.equals(value)) { // if duplicated value found
				this.remove(keyLookup); //remove duplicated <key, value> pair
				super.put(key, value); //put the new <key, value> pair
				return value;
			}
		}
		super.put(key, value);
		return null;
	}

	public static void main(String[] args) {

		UniqueHashMap<String, String> uM = new UniqueHashMap<String, String>();
		uM.put("blog", "glob");
		System.out.println(uM);
		uM.put("blag", "glob");
		System.out.println(uM);
		uM.put("bi", "chen");
		System.out.println(uM);
		uM.put("chen", "chen");
		System.out.println(uM);
	}

}