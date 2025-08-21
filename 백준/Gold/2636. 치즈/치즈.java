import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int numC;
	static int N;
	static int M;
	static int[][] arr;
	
	private static void dfs(int i, int j, boolean[][] visited)
	{
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		for (int k = 0; k < 4; ++k)
		{
			int nx = i + dx[k];
			int ny = j + dy[k];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue ;
			if (!visited[nx][ny])
			{
				if (arr[nx][ny] == 1)
				{
					arr[nx][ny] = 0;
					numC --;
					visited[nx][ny] = true;
					continue ;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, visited);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
			{
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					numC ++;
			}
		}

		int level = 0;
		int temp = 0;
		while (numC > 0)
		{
			boolean[][] visited = new boolean[N][M];
			temp = numC;
			dfs(0, 0, visited);
			level ++;
		}
		System.out.println(level + "\n" + temp);
	}
}
