import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; ++i)
		{
			String[] str = br.readLine().split(" ");
			int k = Integer.parseInt(str[0]);
			for (int j = 0; j < str[1].length(); j ++)
			{
				for (int m = 0; m < k; m ++)
					System.out.print(str[1].charAt(j));
			}
			System.out.print("\n");
		}
	}
}