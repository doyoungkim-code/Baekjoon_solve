import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	
	static void dfs(int depth)
	{
		boolean ordered = true;
		
		if (depth == M)
		{
			for (int i = 0; i < depth - 1; ++i)
			{
				if (result[i] < result[i + 1])
					continue;
				else
					ordered = false;
			}
			if (ordered)
			{
				for (int i = 0; i < depth; ++i)
				{
					System.out.print(result[i] + " ");
				}
				System.out.print("\n");
			}
			return ;
		}
		
		for (int i = 1; i <= N; ++i)
		{
			if (!visited[i])
			{
				visited[i] = true;
				result[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		result = new int[M + 1];
		visited = new boolean[N + 1];
		
		dfs(0);
	}
}
