import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = 2147483647;
	static int count = 0;
	
	static void bfs(int N, int K)
	{
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.offer(N);
		visited[N] = 0;
		
		while (!dq.isEmpty())
		{
			int pollData = dq.poll();
			
			if (visited[pollData] > min)
				continue ;
			if (pollData == K)
			{
				min = visited[pollData];
				count ++;
				continue ;
			}
			
			for (int next : new int[]{pollData - 1, pollData + 1, pollData * 2}) {
                if (next < 0 || next > 100000)
                	continue;
                if (visited[next] == -1) {
                    visited[next] = visited[pollData] + 1;
                    dq.offer(next);
                }
                else if (visited[next] == visited[pollData] + 1) {
                    dq.offer(next);
                }
            }
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		bfs(N, K);
		System.out.println(min + "\n" + count);
	}

}
