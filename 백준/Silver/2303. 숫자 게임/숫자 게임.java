import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		int maxMan = 0;
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[5];
			
			for (int j = 0; j < 5; ++j)
			{
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int a = 0; a < 5; ++a)
			{
				for (int b = a + 1; b < 5; ++b)
				{
					for (int c = b + 1 ; c < 5; ++c)
					{
						int res = (arr[a] + arr[b] + arr[c]) % 10;
						if (res >= max)
						{
							max = res;
							maxMan = i + 1;
						}
					}
				}
			}
		}
		System.out.println(maxMan);
	} 
}
