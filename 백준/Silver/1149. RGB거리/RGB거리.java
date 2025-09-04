import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N + 1][3];
		
		for (int i = 1; i <= N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; ++j)
			{
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[0][2] = 0;
		
		for (int i = 1; i < N + 1; ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				if (j == 0)
					dp[i][j] += Math.min(dp[i - 1][1], dp[i - 1][2]);
				else if (j == 1)
					dp[i][j] += Math.min(dp[i - 1][0], dp[i - 1][2]);
				else
					dp[i][j] += Math.min(dp[i - 1][0], dp[i - 1][1]);
			}
		}
		
		int min = 2147483647;
		for (int i = 0; i < 3; ++i)
		{
			if (dp[N][i] < min)
				min = dp[N][i];
		}
		System.out.println(min);
	}
}