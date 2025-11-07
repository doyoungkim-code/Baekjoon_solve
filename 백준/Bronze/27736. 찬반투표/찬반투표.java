import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int a = 0;
		int r = 0;
		int in = 0;
		for (int i = 0; i < n; ++i)
		{
			int input = Integer.parseInt(st.nextToken());
			if (input == 1)
				a ++;
			else if (input == -1)
				r ++;
			else
				in ++;
				
		}
		
		if (n % 2 == 0 && n / 2 <= in)	
		{
			System.out.println("INVALID");
			return;
		}
		else if (n % 2 == 1 && n / 2 + 1 <= in)
		{
			System.out.println("INVALID");
			return;
		}
		
		if (a > r)
			System.out.println("APPROVED");
		else if (r >= a)
			System.out.println("REJECTED");
	}

}
