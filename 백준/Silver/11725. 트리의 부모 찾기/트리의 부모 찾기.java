import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static List<List<Integer>> arr;
	static int[] visited;
	
	static void bfs()
	{
		visited = new int[N + 1];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.add(1);
		visited[1] = 1;
		
		while(!dq.isEmpty())
		{
			int pollData = dq.poll();
			
			List<Integer> lst = arr.get(pollData);
			for (int i = 0; i < lst.size(); ++i)
			{
				int now = lst.get(i);
				if (visited[now] == 0)
				{
					visited[now] = pollData;
					dq.add(now);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		for (int i = 0; i <= N; ++i)
		{
			arr.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);			
		}
		
		bfs();
		for (int i = 2; i <= N; ++i)
		{
			System.out.println(visited[i]);
		}
	}

}
