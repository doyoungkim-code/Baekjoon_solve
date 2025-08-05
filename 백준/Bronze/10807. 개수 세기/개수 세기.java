
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int v = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			if (Integer.parseInt(str[i]) == v)
			{
				sum ++;
			}
		}
		System.out.println(sum);
	}
}
