
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; ++i)
        {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (a <= 23 && a >= 0 && b <= 59 && b >= 0)
        		System.out.print("Yes ");
        	else
        		System.out.print("No ");
        	
        	if (a <= 12 && a >= 1)
        	{
        		if ((a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a ==12) && b <= 31 && b >= 1)
            		System.out.print("Yes\n");
        		else if ((a == 4 || a == 6 || a == 9 || a == 11) && b <= 30 && b >= 1)
            		System.out.print("Yes\n");
        		else if (a == 2 && b <= 29 && b >= 1)
            		System.out.print("Yes\n");
        		else
            		System.out.print("No\n");
        	}
        	else
        		System.out.print("No\n");
        }
    }
}
