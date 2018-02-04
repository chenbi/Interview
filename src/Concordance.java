import java.util.*;
import java.io.*;
/* Author: Chen Bi 
 * Single Thread Concordance with Bonus solution
 * Generates concordance with sentence numbers
 * Dependencies between sentence numbers in document make it 
 * impossible to identify independent tasks in this case, so chose single thread approach
 */
public class Concordance {

	private TreeMap<String, Word> wordMap = new TreeMap<String, Word>();
	private StringBuilder document;


	public Concordance(String fileName) {
		try {
			readFile(fileName); //read the text file into memory
		} catch (IOException e) {
			System.out.println("Error Reading File");
			e.printStackTrace();
		}

		Concordancer concordancer = new Concordancer(wordMap,document);
		concordancer.createConcordance();
		
		printConcordance();
	}

	private void readFile(String fileName) throws IOException {

		File file = new File(fileName);
		document = new StringBuilder();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNext())
			document.append(scanner.nextLine());
		
		scanner.close();
		
	}

	private void printConcordance() {
		
		int count = 0;
		for (String s : wordMap.keySet()) {//loop through each word in word map
			Word word = wordMap.get(s);
			String sentenceNum = word.getSentenceNum().toString(); //convert list of sentence numbers to string
			sentenceNum = sentenceNum.replaceAll("\\s", "").replaceAll("^\\[|\\]$", ""); //remove white spaces and square brackets

			Formatter formatter = new Formatter();
			System.out.println(formatter.format("%-6s %-15s %-15s",
					printOrder(count) + ".", 
					s, "{" + 
					word.getFrequency()	+ ":" + sentenceNum + "}"));
			count++;
		}
	}

	private String printOrder(int count) {
		StringBuilder order = new StringBuilder();
		int remainder = (count) % 26;
		char alphabet = (char) (remainder + 97); // match the remainder to an alphabet by adding 97 to ASCII 'a'
		for (int i = count / 26; i >= 0; i--) {
			order.append(alphabet); 
		}
		return order.toString();
	}

	public static void main(String args[]) {
		 if(args.length == 0){
			 System.out.println("Please specify filename of text document");
		 }		
		 String fileName = args[0];
		 new Concordance(fileName);

	}
}