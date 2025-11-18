import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static final int[] dx = {0, 0, -1, 1};
	static final int[] dy = {1, -1, 0, 0};
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static void bfs(int i, int j, int nowColor) {
		ArrayDeque<Point> dq = new ArrayDeque<>();
		
		visited[i][j] = true;
		dq.add(new Point(i, j));
		
		while (!dq.isEmpty())
		{
			Point now = dq.poll();
			int x = now.x;
			int y = now.y;
			
			for (int d = 0; d < 4; ++d)
			{
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= N || nx < 0 || ny >= N || ny < 0)
					continue;
				
				if (!visited[nx][ny] && map[nx][ny] == nowColor)
				{
					visited[nx][ny] = true;
					dq.add(new Point(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i)
		{
			String str = br.readLine();
			for (int j = 0; j < N; ++j)
			{
				if (str.charAt(j) == 'R')
					map[i][j] = 1;
				else if (str.charAt(j) == 'G')
					map[i][j] = 2;
				else if (str.charAt(j) == 'B')
					map[i][j] = 3;
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{
				if (!visited[i][j])
				{
					bfs(i, j, map[i][j]);
					cnt ++;
				}
			}
		}
		System.out.print(cnt + " ");
		
		cnt = 0;
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{
				if (map[i][j] == 2)
					map[i][j] = 1;
			}
		}
		
		for (int i = 0; i < N; ++i)
		{
			for (int j = 0; j < N; ++j)
			{	
				if (!visited[i][j])
				{
					bfs(i, j, map[i][j]);
					cnt ++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
