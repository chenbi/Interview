import java.util.TreeMap;
/* Author: Chen Bi
 * The concordancer assumes that the input text file is properly formated,
* case like: "I love Java.And you?" where there's no space between two sentences is not covered
* Some special words like "N/A", "Wi-Fi" are not covered, Abbreviation is covered such as "i.e.".
*/
public class Concordancer {
	private TreeMap<String, Word> wordMap;
	private StringBuilder document;
	private int sentenceNum;
	private int length;
	private int currIndex;

	public Concordancer(TreeMap<String, Word> wordMap, StringBuilder document) {
		this.document = document;
		this.wordMap = wordMap;
		this.length = document.length();
	}

	public void createConcordance() {
		sentenceNum = 1;
		currIndex = 0; //points to current character in document
		
		while (currIndex < length) {
			String word = nextWord(); //parse next word
			Word w = new Word(word);
			if (wordMap.containsKey(word)) {
				w = wordMap.get(word);
			}
			w.addFrequency(); // increment frequency of this word
			w.addSentenceNum(sentenceNum); // add sentence number
			wordMap.put(word, w); // put word in word map
		}
	}

	private String nextWord() {
		StringBuilder word = new StringBuilder();

		while (currIndex < length) {
			char c = document.charAt(currIndex);
			currIndex++;

			if (Character.isWhitespace(c)) // end of word
				break;

			else if (Character.isLetter(c)) // append a letter to word
				word.append(c);

			else if (c == '.') {
				// abbreviation like 'i.e.'
				if (currIndex < length	&& (Character.isLetter(document.charAt(currIndex)) || document.charAt(currIndex - 3) == '.')) {
					
					word.append(c); // if the next character is a letter or there is a period 2 characters before
					                // the current one, append the period. Otherwise, period is end of word, do nothing
				}
			}
			
			// begin of another sentence if c is upper case, and proceeded by period  2 spaces ahead
			if ( Character.isUpperCase(c) && (currIndex > 2 && document.charAt(currIndex - 3) == '.')) {
				sentenceNum++;
			}
		}
		return word.toString().toLowerCase();
	}
}
