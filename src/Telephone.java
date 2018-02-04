import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Telephone {
	public static void main(String[] args) throws IOException {
		
		//print all combinations of alphabets on number pad
		
		 FileWriter fstream = new FileWriter("out.doc");
		 BufferedWriter out = new BufferedWriter(fstream);
		 numberpad(out, "","5147758880");		
		 out.close();
		
	}

	private static void numberpad(BufferedWriter out, String prefix, String string) throws IOException {

		if (string.equals("")){
			System.out.println(prefix);
			out.write(prefix+"\n");
		}
		else{
			for (int i=0;i<getChars(string.charAt(0)).length;i++){

				numberpad(out,prefix+getChars(string.charAt(0))[i],string.substring(1));
	
			}

		}
	}
	
	
	static char[] getChars(char c){
		
		if (c=='1') 
		{
			char chars[] = {'a','b','c'};	
			return 	chars;
		}
		if (c=='2') 
		{
			char chars[] = {'d','e','f'};	
			return 	chars;
		}
		if (c=='3') 
		{
			char chars[] = {'g','h','i'};	
			return 	chars;
		}
		if (c=='4') 
		{
			char chars[] = {'j','k','l'};	
			return 	chars;
		}
		if (c=='5') 
		{
			char chars[] = {'m','n','o'};	
			return 	chars;
		}		
		if (c=='6') 
		{
			char chars[] = {'p','q','r'};	
			return 	chars;
		}		if (c=='7') 
		{
			char chars[] = {'s','t','u'};	
			return 	chars;
		}		
		if (c=='8') 
		{
			char chars[] = {'v','w','x'};	
			return 	chars;
		}		
		if (c=='9') 
		{
			char chars[] = {'y','z'};	
			return 	chars;
		}		
		else
		{
			char chars[] = {'#'};	
			return 	chars;
		}		
		
	}

	
}
