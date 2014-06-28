package palindrome;
import java.util.ArrayList;
/*
 * This program finds all character combinations of a given string.
 */

public class Palindrome{

	public static String [] test(String in){
		/*
		 * Input: A string.
		 * Output: An array containing all character combinations of the input string.
		 */
		ArrayList<String> out = new ArrayList<String>();
		if(in.length() == 1){
			out.add(in);
			return (String[]) out.toArray(new String[out.size()]);
		}
		for(int i = 0; i < in.length();++i){
			String g = in;
			StringBuilder sb = new StringBuilder(g);
			sb.deleteCharAt(i);
			
			for(String t: test(sb.toString())){
				out.add(in.charAt(i) + t);
			}
		}
		return (String[]) out.toArray(new String[out.size()]);
	}
	
	
	public static void main(String[] args) {
		for(String in: test("This is a long string.")){
			System.out.println(in);
		}

	}

}
