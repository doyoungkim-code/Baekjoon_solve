import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        String str = br.readLine();
	        
	        for (int i = 0; i < str.length(); ++i)
	        {
	        	if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
	        		System.out.print((char)(str.charAt(i) - 32));
	        	else
	        		System.out.print((char)(str.charAt(i) + 32));
	        }
		}

}
