import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] arr;
	static int[][][] visited;
	
	static class Point{
		int x;
		int y;
		int broken;
		
		public Point(int x, int y, int broken) {
			super();
			this.x = x;
			this.y = y;
			this.broken = broken;
		}
	}
	
	static void bfs() {
		
		ArrayDeque<Point> dq = new ArrayDeque<>();
		
		dq.add(new Point(0, 0, 0));
		visited[0][0][0] = 1;
		
		while (!dq.isEmpty())
		{
			Point pollData = dq.poll();
			
			int x = pollData.x;
			int y = pollData.y;
			int broken = pollData.broken;
			
			if (x == N - 1 && y == M - 1)
			{
				System.out.println(visited[x][y][broken]);
				return;
			}
			
			for (int d =  0; d < 4; ++d)
			{
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if (nx >= N || nx < 0 || ny >= M || ny < 0)
					continue;
				
				if (arr[nx][ny] == 0 && visited[nx][ny][broken] == 0)
				{
					visited[nx][ny][broken] = visited[x][y][broken] + 1;
					dq.add(new Point(nx, ny, broken));
				}
				else if (arr[nx][ny] == 1 && broken == 0 && visited[nx][ny][1] == 0)
				{
					visited[nx][ny][1] = visited[x][y][0] + 1;
					dq.add(new Point(nx, ny, 1));
				}
			}
		}
		
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new int[N][M][2];
		
		for (int i = 0; i < N; ++i)
		{
			String str = br.readLine();
			for (int j = 0; j < M; ++j)
			{
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
	}
}