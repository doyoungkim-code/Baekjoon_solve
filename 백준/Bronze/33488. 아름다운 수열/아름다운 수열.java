import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; ++i)
		{
			int input = Integer.parseInt(br.readLine());
			
			System.out.println("YES");
			for (int j = 1; j <= input; ++j)
			{
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}
}
