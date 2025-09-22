import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; ++i)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		while (K != 0)
		{
			for (int i = N - 1; i >= 0; --i)
			{
				if (K - arr[i] >= 0)
				{
					K = K - arr[i];
					cnt ++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
