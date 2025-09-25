import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] arr;
	
	static void pre(int k) {
		if (k == -19)
			return;
		System.out.print((char)(k + 'A'));
		pre(arr[k][0]);
		pre(arr[k][1]);
	}
	static void mid(int k) {
		if (k == -19)
			return;
		mid(arr[k][0]);
		System.out.print((char)(k + 'A'));
		mid(arr[k][1]);
	}
	static void aft(int k) {
		if (k == -19)
			return;
		aft(arr[k][0]);
		aft(arr[k][1]);	
		System.out.print((char)(k + 'A'));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			
			int a = st.nextToken().charAt(0) - 'A';
			int b = st.nextToken().charAt(0) - 'A';
			int c = st.nextToken().charAt(0) - 'A';
			
			arr[a][0] = b;
			arr[a][1] = c;
		}
		
		pre(0);
		System.out.print("\n");
		mid(0);
		System.out.print("\n");
		aft(0);
	}

}
