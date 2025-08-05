import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; ++i) {
			int sum = 0;
			String str = br.readLine();
			for (int j = 0; j < str.length(); ++j) {
				if (str.charAt(j) == 'O')
				{
					int k = 1;
					while (j < str.length() && str.charAt(j) == 'O')
					{
						sum = sum + k;
						k ++;
						j ++;
					}
				}
			}
			System.out.println(sum);
		}
	}
}