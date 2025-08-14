import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	
	private static void dfs(int depth)
	{
		if (depth == M)
		{
			for (int i = 0; i < M - 1; ++i)
			{
				if (result[i] <= result[i + 1])
					continue;
				return;
			}
			for (int i = 0; i < M; ++i)
			{
				System.out.print(result[i] + " ");
			}
			System.out.print("\n");
			
			return ;
		}
		
		int temp = -1;
		for (int i = 0; i < N; ++i)
		{
			if (!visited[i] && arr[i] != temp)
			{
				temp = arr[i];
				visited[i] = true;
				result[depth] = arr[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		dfs(0);
		
	}

}
