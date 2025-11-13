import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean res = true;
		String str = br.readLine();
		char pre = 'z';
		for (int i = 0; i < N; ++i)
		{
			char now = str.charAt(i);
			if ((i == 0 || i == N - 1) && now != 'a')
				res = false;
			if (now == pre)
				res = false;
			else
				pre = now;
			
			if (now == 'a')
			{
				A --;
				if (A < 0)
					res = false;
			}
			else if (now == 'b')
			{
				B --;
				if (B < 0)
					res = false;
			}
			else if (now == 'c')
			{
				C --;
				if (C < 0)
					res = false;
			}
			else if (now == 'd')
			{
				D --;
				if (D < 0)
					res = false;
			}
		}
		if (res)
			System.out.println("Yes");
		else
			System.out.println("No");
	} 
}
