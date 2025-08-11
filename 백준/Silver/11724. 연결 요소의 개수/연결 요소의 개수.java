import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int groupNum;
	static boolean[] visited;
	static List<List<Integer>> arr;
	
	public static void bfs(int start) {
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		if (!visited[start])
		{
			visited[start] = true;
			dq.add(start);
			
			while (!dq.isEmpty())
			{
				int a = dq.poll();
				for (int i = 0; i < arr.get(a).size(); ++i)
				{
					int inp = arr.get(a).get(i);
					if (!visited[inp])
					{
						visited[inp] = true;
						dq.add(inp);
					}
				}
			}
			
			groupNum ++;
		}
	}
	
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		
		for (int i = 0; i <= N; ++i)
		{
			arr.add(new ArrayList<>());
		}
		
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());	
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		for (int i = 1; i <= N; ++i)
			bfs(i);
		
		System.out.println(groupNum);
	}

}
