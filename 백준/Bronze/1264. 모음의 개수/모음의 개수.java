import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        while(!s.equals("#"))
        {
        		int count = 0;
        		for (int i = 0; i < s.length(); ++i)
        		{
        			char a = s.charAt(i);
        			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U')
        				count ++;
        		}
        		System.out.println(count);
        		s = br.readLine();
        }
    }
}