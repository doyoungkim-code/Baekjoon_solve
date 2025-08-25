import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	static int N;
	static int M;
	static List <List <Integer>> arr;
	static boolean[] visited;
	static boolean result = false;
	
	private static void dfs(int now, int depth) {
		if (depth >= 4)
		{
			result = true;
			return ;
		}
		
		for (int node : arr.get(now))
		{
			if (!visited[node])
			{
				visited[node] = true;
				dfs(node, depth + 1);
				visited[node] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br. readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		visited = new boolean[N];
		for (int i = 0; i < N; ++i)
		{
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for (int i = 0; i < N; ++i)
		{
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
			if (result)
				break;
		}
		System.out.println(result ? 1 : 0);
	}
}