
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int min_result = 2147483647;
	static int N;
	static int[] S;
	static int[] B;
	static boolean[] visited;
	
	public static void dfs(int max_depth, int depth, int now_S, int now_B)
	{
		if (depth == max_depth)
		{
			if (min_result > Math.abs(now_B - now_S))
				min_result = Math.abs(now_B - now_S);
		}
		
		for (int i = 0; i < N; ++i)
		{
			if (!visited[i])
			{
				visited[i] = true;
				dfs(max_depth, depth + 1, now_S * S[i], now_B + B[i]);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	S = new int[N];
    	B = new int[N];
    	visited = new boolean[N];
    	
    	for (int i = 0; i < N; ++i) {
    		String[] str = br.readLine().split(" ");
    		S[i] = Integer.parseInt(str[0]);
    		B[i] = Integer.parseInt(str[1]);
    	}
    	
    	for (int i = 1; i <= N; ++i)
    		dfs(i, 0, 1, 0);
    	
    	System.out.println(min_result);
    }
}