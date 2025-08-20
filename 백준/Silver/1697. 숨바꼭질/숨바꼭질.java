import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static void bfs(int N, int K)
	{
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		
		dq.offer(new int[] {N, 0});
		visited[N] = true;
		
		while (!dq.isEmpty())
		{
			int[] pollData = dq.poll();
			
			if (pollData[0] == K)
			{
				System.out.println(pollData[1]);
				return;
			}
			if ((pollData[0] - 1 >= 0 && pollData[0] - 1 <= 100000) && !visited[pollData[0] - 1])
			{
				visited[pollData[0] - 1] = true;
				dq.offer(new int[] {pollData[0] - 1, pollData[1] + 1});
			}
			if ((pollData[0] + 1 >= 0 && pollData[0] + 1 <= 100000) && !visited[pollData[0] + 1])
			{
				visited[pollData[0] + 1] = true;
				dq.offer(new int[] {pollData[0] + 1, pollData[1] + 1});
			}
			if ((pollData[0] * 2 >= 0 && pollData[0] * 2 <= 100000) && !visited[pollData[0] * 2])
			{
				visited[pollData[0] * 2] = true;
				dq.offer(new int[] {pollData[0] * 2, pollData[1] + 1});
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
	}

}
