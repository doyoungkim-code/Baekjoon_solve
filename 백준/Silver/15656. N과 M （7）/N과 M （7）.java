
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void dfs(int depth, List<Integer> result)
	{
		if (depth == M)
		{
			for (int res : result)
			{
				sb.append(res + " ");
			}
			sb.append("\n");
			return ;
		}
		
		for (int i = 0; i < N; ++i)
		{
//			if (!visited[i])
//			{
//				visited[i] = true;
				result.add(arr[i]);
				dfs(depth + 1, result);
//				visited[i] = false;
				result.remove(result.size() - 1);
//			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, new ArrayList<>());
		System.out.println(sb);
	}
}