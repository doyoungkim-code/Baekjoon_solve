import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; ++tc)
		{
			int N = Integer.parseInt(br.readLine());
			Point[] pointList = new Point[N + 2];
			boolean[][] d = new boolean[N + 2][N + 2];
			
			for (int i = 0; i < N + 2; ++i)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				pointList[i] = new Point(a, b);
			}
			
			for (int k = 0; k < N + 2; ++k)
			{
				for (int i = 0; i < N + 2; ++i)
				{
					for (int j = 0; j < N + 2; ++j)
					{
						if (Math.abs(pointList[i].x - pointList[j].x) +  Math.abs(pointList[i].y - pointList[j].y) <= 1000)
							d[i][j] = true;
						d[i][j] = (d[i][k] && d[k][j]) || d[i][j];
					}
				}
			}
			System.out.println(d[0][N + 1] ? "happy" : "sad");
		}
	}
}