import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true)
		{
			st = new StringTokenizer(br.readLine());
			
			int b = Integer.parseInt(st.nextToken());
			if (b == 0)
				return ;

			String p = st.nextToken();
			String m = st.nextToken();
			
			int mNum = 0;
			for (int i = 0; i < m.length(); ++i)
			{
				mNum = mNum * b + (int)(m.charAt(i) - '0');
			}
			
			int res = 0;
			for (int i = 0; i < p.length(); ++i)
			{
				res = (res * b + (int)(p.charAt(i) - '0')) % mNum;
			}
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			do
			{
				dq.add(res % b);
				res = res / b;
			} while (res > 0);
			
			while (!dq.isEmpty())
				System.out.print(dq.pollLast());
			System.out.print("\n");
		}
	} 
}
