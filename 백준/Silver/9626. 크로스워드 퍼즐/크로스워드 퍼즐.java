import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int U = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		char[][] puz = new char[M + U + D][N + L + R];
		for (int i = 0; i < M + U + D; ++i)
		{
			for (int j = 0; j < N + L + R; ++j)
			{
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1))
					puz[i][j] = '#';
				else
					puz[i][j] = '.';
					
			}
		}
		
		for (int i = U; i < M + U; ++i)
		{
			String str = br.readLine();
			for (int j = L; j < N + L; ++j)
			{
				puz[i][j] = str.charAt(j - L);
			}
		}
		
		for (int i = 0; i < M + U + D; ++i)
		{
			for (int j = 0; j < N + L + R; ++j)
			{
				System.out.print(puz[i][j]);
			}
			System.out.print("\n");
		}
	}
}
