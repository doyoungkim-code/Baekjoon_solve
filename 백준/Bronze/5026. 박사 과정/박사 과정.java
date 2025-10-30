import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i < N; ++i)
    	{
    		String s = br.readLine();
    		
    		if (s.equals("P=NP"))
    		{
    			System.out.println("skipped");
    			continue;
    		}
    		
    		int a = 0;
    		int b = 0;
    		boolean c = false;
    		for (int j = 0; j < s.length(); ++j)
    		{
    			if (s.charAt(j) == '+')
    			{
    				c = true;
    				continue;
    			}
    			
    			if (!c)
    				a = (a * 10) + (s.charAt(j) - '0');
    			else
    				b = (b * 10) + (s.charAt(j) - '0');
    		}
    		
    		System.out.println(a + b);
    	}
    }
}