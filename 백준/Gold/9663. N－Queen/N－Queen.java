import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int count;	
	static boolean[] col;
	static boolean[] d_left;
	static boolean[] d_right;
	
	private static void dfs(int depth)
	{
		if (depth == N)
		{
			count ++;
			return;
		}
		
		  for (int c = 0; c < N; c++) {
		        if (!col[c] && !d_left[depth - c + N - 1] && !d_right[depth + c]) {
		            col[c] = d_left[depth - c + N - 1] = d_right[depth + c] = true;
		            dfs(depth + 1);
		            col[c] = d_left[depth - c + N - 1] = d_right[depth + c] = false;
		        }
		    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		col = new boolean[N];
		d_left = new boolean[2 * N - 1];
		d_right = new boolean[2 * N - 1];
		
		dfs(0);
		System.out.println(count);
	}

}
