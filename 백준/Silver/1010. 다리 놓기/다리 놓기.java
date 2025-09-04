import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[][] dp = new int[30][30];
		
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		// dp[x][y] = dp[x - 1][y] + dp[x - 1][y - 1]
		// y == x or y == 0 --> = 1
		
		for (int i = 2; i < 30; ++i)
		{
			for (int j = 0; j <= i; ++j)
			{
				if (j == 0 || j == i)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dp[b][a]).append("\n");
		}
		System.out.println(sb);
	}
}