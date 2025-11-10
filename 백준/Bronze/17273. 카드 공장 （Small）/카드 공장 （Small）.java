import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] now = new boolean[N];
		int[] cardF = new int[N];
		int[] cardB = new int[N];		
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			cardF[i] = Integer.parseInt(st.nextToken());
			cardB[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < M; ++i)
		{
			int input = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < N; ++j)
			{
				if (!now[j] && input >= cardF[j])
					now[j] = true;
				else if (now[j] && input >= cardB[j])
					now[j] = false;
			}
		}
		
		int sum = 0;
		
		for (int i = 0; i < N; ++i)
		{
			if (!now[i])
				sum += cardF[i];
			else
				sum += cardB[i];
		}
		
		System.out.println(sum);
	}
}
