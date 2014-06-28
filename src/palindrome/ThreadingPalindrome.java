package palindrome;

public class ThreadingPalindrome extends Palindrome implements Runnable{
	String toParse;
	char threadLetter;
	String [] returnValues;
	
	public ThreadingPalindrome(char thread_letter, String to_parse){
		threadLetter = thread_letter;
		toParse = to_parse;
	}
	
	public void run() {
		for(String in: test(toParse)){
			System.out.println(threadLetter + in);
		}
	}
	
	
	
	public static void main(String[] args) {
		String toParse = "Some string";
		Thread [] threads = new Thread[toParse.length()];
		for(int i = 0; i < toParse.length();++i){
			StringBuilder sb = new StringBuilder(toParse);
			sb.deleteCharAt(i);
			threads[i] = new Thread(new ThreadingPalindrome(toParse.charAt(i), sb.toString()));
			threads[i].start();
		}
		
	}


}
