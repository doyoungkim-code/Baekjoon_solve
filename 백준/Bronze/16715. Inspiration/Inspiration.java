import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int maxZ = 0;
		int max = 0;
		for (int i = 2; i <= N; ++i)
		{
			int temp = N;
			
			int res = 0;
			while (temp >= 1)
			{
				res += temp % i;
				temp = temp / i;
			}
			if (max < res)
			{
				maxZ = i;
				max = res;
			}
		}
		System.out.println(max + " " + maxZ);
	}
}
