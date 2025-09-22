import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int ans;
	
	static void solve(int N, int r, int c) {
		while (N != 0)
		{
			N = N - 1;
			int size = 1;
			
			for (int i = 0; i < N; ++i)
			{
				size = size * 2;
			}
			
			if (r < size && c < size)
			{
				ans += (size * size * 0);
			}
			else if (r < size && c >= size)
			{
				ans += (size * size * 1);
				c -= size;
			}
			else if (r >= size && c < size)
			{
				ans += (size * size * 2);
				r -= size;
			}
			else
			{
				ans += (size * size * 3);
				r -= size;
				c -= size;
			}
		}
		// return (2 * (r % 2) + (c % 2) + 4 * solve(N - 1, r / 2, c / 2));
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		solve(N, r, c);
		
		System.out.println(ans);
	}

}
