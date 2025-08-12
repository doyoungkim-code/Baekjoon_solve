
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb;
	
	static void dfs(int depth)
	{
		if (depth == M)
		{
			boolean ordered = true;
			
			for (int i = 0; i < depth - 1; ++i)
			{
				if (result[i] <= result[i + 1])
					continue;
				else
					ordered = false;
			}
			if (ordered)
			{
				for (int i = 0; i < depth; ++i)
				{
					sb.append(result[i]).append(" ");
				}
				sb.append("\n");
			}
			return ;
		}
		
		for (int i = 1; i <= N; ++i)
		{
//			if (!visited[i])
//			{
//				visited[i] = true;
				result[depth] = i;
				dfs(depth + 1);
//				visited[i] = false;
//			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M + 1];
		visited = new boolean[N + 1];
		
		dfs(0);
		System.out.println(sb);
	}
}