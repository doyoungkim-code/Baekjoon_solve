
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static ArrayDeque<Integer> dq = new ArrayDeque<>();
	static boolean[] visited;
	static int[] depth;
	static int n;
	static int m;
	static int result = 0;
	
	public static void bfs()
	{
		dq.add(1);
		visited[1] = true;
		depth[1] = 0;
		
		while (!dq.isEmpty())
		{
			int cur = dq.poll();
			if (depth[cur] == 2)
			{
				continue ;
			}
			for (int data : graph.get(cur))
			{
				if (!visited[data])
				{
					result ++;
					dq.add(data);
					visited[data] = true;
					depth[data] = depth[cur] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visited = new boolean[n + 1];
		depth = new int[n + 1];
		for (int i = 0; i <= n; ++i)
		{
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; ++i)
		{
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			graph.get(a).add(b);
			graph.get(b).add(a);			
		}
		bfs();
		System.out.println(result);
	}
}
