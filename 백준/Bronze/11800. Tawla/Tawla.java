import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.print("Case "+ (i + 1) + ": ");
			if ((a == 5 && b == 6) || (a == 6 && b == 5))
			{
				System.out.println("Sheesh Beesh");
				continue;
			}
			
			if (a < b)
			{
				int temp  = a;
				a = b;
				b = temp;
			}
			else if (a == b)
			{
				if (a == 1)
					System.out.println("Habb Yakk");
				else if (a == 2)
					System.out.println("Dobara");
				else if (a == 3)
					System.out.println("Dousa");
				else if (a == 4)
					System.out.println("Dorgy");
				else if (a == 5)
					System.out.println("Dabash");
				else if (a == 6)
					System.out.println("Dosh");
				
				continue;
			}
			
			if (a == 1)
				System.out.print("Yakk ");
			else if (a == 2)
				System.out.print("Doh ");
			else if (a == 3)
				System.out.print("Seh ");
			else if (a == 4)
				System.out.print("Ghar ");
			else if (a == 5)
				System.out.print("Bang ");
			else if (a == 6)
				System.out.print("Sheesh ");
			
			if (b == 1)
				System.out.println("Yakk");
			else if (b == 2)
				System.out.println("Doh");
			else if (b == 3)
				System.out.println("Seh");
			else if (b == 4)
				System.out.println("Ghar");
			else if (b == 5)
				System.out.println("Bang");
			else if (b == 6)
				System.out.println("Sheesh");
		}
	}
}
