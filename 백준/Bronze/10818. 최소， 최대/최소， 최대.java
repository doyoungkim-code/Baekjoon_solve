import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int max = -1000001;
		int min = 1000001;

		String[] str = br.readLine().split(" ");
		
		for (int i = 0; i < N; ++i)
		{
			int x = Integer.parseInt(str[i]);
			if (x > max)
			{
				max = x;
			}
			if (x < min)
			{
				min = x;
			}
		}
		
		System.out.println(min + " " + max);
	}
}