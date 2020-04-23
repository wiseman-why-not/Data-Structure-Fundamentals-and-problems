package hashes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashPlayground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashPlayground hpg = new HashPlayground();
		Set<Character> ex = new LinkedHashSet<>();
		hpg.loadCharaters(ex);
		hpg.printCharacters(ex);
		System.out.println("===========================");
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "jan");
		hm.put(2, "feb");
		hm.put(3, "mar");
		hm.put(4, "apr");
		hm.put(5, null);
		
		Hashtable<Integer, String> ht = new Hashtable();
		ht.put(1, "jan");
		ht.put(2, "feb");
		ht.put(3, "mar");
		ht.put(4, "apr");

		
		
		
		System.out.println(hm.get(5));
		System.out.println(ht.get(4));
		
		Integer sumNum = hm.hashCode();
		System.out.println("hahscode is: " + sumNum);
		System.out.println("hash size: " + hm.size());

		Set<Integer> keyset = hm.keySet();
		Iterator<Integer> it = keyset.iterator();
		
		while (it.hasNext()) {
			Integer key = it.next();
			System.out.println("key: " + key);
			System.out.println("value: " + hm.get(key));
		}
		System.out.println("______________________________");
		Collection<String> keyset2 = hm.values();
		System.out.println(keyset2.size());
		Iterator<String> it2 = keyset2.iterator();
		
		while (it2.hasNext()) {
			String value = it2.next();
			System.out.println("value: " + value);
		}
	}
	
	public void loadCharaters(Set<Character> setOfCharacters) {
		Character a = new Character("rick", "sanchez");
		Character b = new Character("morty", "sanchez");
		Character c = new Character("beth", "sanchez");
		Character d = new Character("jerry", "sanchez");
		
		setOfCharacters.add(a);
		setOfCharacters.add(b);
		setOfCharacters.add(c);
		setOfCharacters.add(d);
	}
	
	public void printCharacters(Set<Character> charCollection) {
		Iterator<Character> iter = charCollection.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public class Character {
		private String fname;
		private String lname;
		
		public Character(String fname, String lname) {
			this.fname = fname;
			this.lname = lname;
		}
		
		public String toString() {
			return "" + fname + " " + lname;
		}
	}

}
