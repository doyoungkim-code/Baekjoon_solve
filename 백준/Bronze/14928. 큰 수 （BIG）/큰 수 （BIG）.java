import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	String s = br.readLine();
    	
    	long remain = 0;
    	for (int i = 0; i < s.length(); ++i)
    	{
    		char c = s.charAt(i);
    		
    		int d = c - '0';
    		
    		remain = (remain * 10 + d) % 20000303;
    	}
    	
    	System.out.println(remain);

    }
}