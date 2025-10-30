import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	String[][] gaji = new String[10][10];
    	
    	for (int i = 0; i < 10; ++i)
    	{
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < 10; ++j)
    		{
    			gaji[i][j] = st.nextToken();
    		}
    	}
    	
    	for (int i = 0; i < 10; ++i)
    	{
    		String s = gaji[0][i];
    		boolean b = true;
    		for (int j = 1; j < 10; ++j)
    		{
    			if (!s.equals(gaji[j][i]))
    			{
    				b = false;
    				break;
    			}
    		}
    		if (b)
    		{
    			System.out.println(1);
    			return;
    		}
    	}
    	
    	for (int i = 0; i < 10; ++i)
    	{
    		String s = gaji[i][0];
    		boolean b = true;
    		for (int j = 1; j < 10; ++j)
    		{
    			if (!s.equals(gaji[i][j]))
    			{
    				b = false;
    				break;
    			}
    		}
    		if (b)
    		{
    			System.out.println(1);
    			return;
    		}
    	}
    	
    	System.out.println(0);
    }
}