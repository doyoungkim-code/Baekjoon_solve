import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < a; ++i)
        {
        		int n = Integer.parseInt(br.readLine());
        		
        		for (int k = 0; k < (n / 5); ++k)
        		{
        			System.out.print("++++ ");
        		}
        		
        		for (int k = 0; k < (n % 5); ++k)
        		{
        			System.out.print("|");
        		}
        		System.out.print("\n");
        }
    }
}