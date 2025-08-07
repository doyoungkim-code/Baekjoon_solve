import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nanjaeng = new int[9];
		int sum = -100;
		
		for (int i = 0; i < 9; ++i)
		{
			nanjaeng[i] = Integer.parseInt(br.readLine());
			sum += nanjaeng[i];
		}
		
		int a;
		int b;
		
		for (a = 0; a < 9; ++a)
		{
			for (b = a + 1; b < 9; ++b)
			{
				if (nanjaeng[a] + nanjaeng[b] == sum)
				{
					for (int i = 0; i < 9; ++i)
					{
						if (i != a && i != b)
							System.out.println(nanjaeng[i]);
					}
				}
			}
		}
	}
}
