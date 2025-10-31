
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n - 1; ++i)
        {
        	for (int j = n - 1; j > i; --j)
        	{
        		System.out.print(" ");
        	}
        	
        	for (int j = 0; j < (i + 1) * 2 - 1; ++j)
        	{
        		System.out.print("*");
        	}
        	System.out.print("\n");
        }
        for (int i = n - 1; i >= 0; --i)
        {
        	for (int j = n - 1; j > i; --j)
        	{
        		System.out.print(" ");
        	}
        	
        	for (int j = 0; j < (i + 1) * 2 - 1; ++j)
        	{
        		System.out.print("*");
        	}
        	System.out.print("\n");
        }
    }
}
