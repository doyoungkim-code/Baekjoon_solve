import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] gold = new int[T][2];
		Set<Integer> xSet = new HashSet<>();
		Set<Integer> ySet = new HashSet<>();
		
		for (int i = 0; i < T; ++i)
		{
			st = new StringTokenizer(br.readLine());
			gold[i][0] = Integer.parseInt(st.nextToken());
			gold[i][1] = Integer.parseInt(st.nextToken());
			
			xSet.add(gold[i][0]);
			ySet.add(gold[i][1]);
			xSet.add(0 > (gold[i][0] - K) ? 0 : (gold[i][0] - K));
			ySet.add(0 > (gold[i][1] - K) ? 0 : (gold[i][1] - K));
		}
		
		int max= -1;
		int resX = 0;
		int resY = 0;
		
		for (int x : xSet)
		{
			if (x < 0 || x > N || x + K > N)
				continue;
			for (int y : ySet)
			{
				if (y < 0 || y > M || y + K > M)
					continue;
				int count = 0;
				for (int i = 0; i < T; ++i)
				{
					int goldX = gold[i][0];
					int goldY = gold[i][1];
					
					if (x <= goldX && goldX <= x + K && y <= goldY && goldY <= y + K)
					{
						count++;
					}
				}
				if (count > max)
				{
					max = count;
					resX = x;
					resY = y;
				}
			}
		}
		System.out.println(resX + " " + (resY + K));
		System.out.println(max);
	}
}