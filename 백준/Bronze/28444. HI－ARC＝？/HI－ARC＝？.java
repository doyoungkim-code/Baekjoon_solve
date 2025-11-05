import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[5];
		
		for (int i = 0; i < 5; ++i)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(arr[0] * arr[1] - arr[2] * arr[3] * arr[4]);
	}

}
