import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int[][] boxes;
	static int[][] visited;
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0};
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs()
	{
		ArrayDeque<Point> dq = new ArrayDeque<>();
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < M; ++j)
			{
				if (boxes[i][j] == 1)
				{
					dq.add(new Point(i, j));
					visited[i][j] = 1;
				}
			}
		}
		
		while (!dq.isEmpty())
		{
			Point pollData = dq.poll();
			int x = pollData.x;
			int y = pollData.y;
			
			for (int d = 0; d < 4; ++d)
			{
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				
				if (visited[nx][ny] == 0 && boxes[nx][ny] == 0)
				{
					dq.add(new Point(nx, ny));
					boxes[nx][ny] = 1;
					visited[nx][ny] = visited[x][y] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		boxes = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j)
			{
				boxes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int max = 0;
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < M; ++j)
			{
				if (visited[i][j] != 0)
				{
					if (max < visited[i][j])
						max = visited[i][j];
				}
				else
				{
					if (boxes[i][j] == 0)
					{
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(max - 1);
	}
}
