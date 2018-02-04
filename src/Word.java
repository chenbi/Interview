import java.util.*;

/* Author: Chen Bi 
 * each object of Word represents a word in text document
 */
public class Word {

	private String word;

	private int frequency;

	private List<Integer> sentenceNum;  //list storing sentence numbers of each word



	public Word(String s) {
		this.word = s;
		this.sentenceNum = new LinkedList<Integer>();
	}

	public void addSentenceNum(int num) {
		this.sentenceNum.add(num);
	}

	public void addFrequency() {
		this.frequency++;
	}

	public String getWord() {
		return this.word;
	}

	public List<Integer> getSentenceNum() {
		return this.sentenceNum;
	}

	public int getFrequency() {
		return this.frequency;
	}
}