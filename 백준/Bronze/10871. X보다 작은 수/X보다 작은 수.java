import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int X = Integer.parseInt(str[1]);
		
		String[] str1 = br.readLine().split(" ");
		for (int i = 0; i < N; i ++)
		{
			int num = Integer.parseInt(str1[i]);
				if (X > num)
					sb.append(num).append(" ");
		}
		System.out.println(sb);
	}
}