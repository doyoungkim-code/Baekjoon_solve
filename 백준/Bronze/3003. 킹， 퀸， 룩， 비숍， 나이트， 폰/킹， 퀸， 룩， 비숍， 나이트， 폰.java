
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] chess = new int[6];
		int[] need = {1, 1, 2, 2, 2, 8};
		int[] res = new int[6];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < 6; i ++)
		{
			chess[i] = Integer.parseInt(str[i]);
			res[i] = need[i] - chess[i];
		}
		for (int i = 0; i < 6; i ++)
		{
			System.out.print(res[i] + " ");
		}
	}
}
