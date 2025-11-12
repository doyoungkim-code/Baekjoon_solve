import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int res = 0;
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			res += Math.max(a, b);
			
			int[] arr = new int[5];
			for (int j = 0; j < 5; ++j)
			{
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			res += arr[3] + arr[4];
			
			if (max < res)
				max = res;
		}
		System.out.println(max);
	}
}
