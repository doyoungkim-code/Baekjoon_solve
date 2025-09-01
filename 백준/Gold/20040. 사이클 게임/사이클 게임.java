import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;
	
	static int find(int a)
	{
		if (parents[a] == a)
			return a;
		return (parents[a] = find(parents[a]));
	}
	
	static boolean union(int a, int b)
	{
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB)
			return false;
		
		parents[rootB] = rootA;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		// parents 파싱
		for (int i = 0; i < n; ++i)
		{
			parents[i] = i;
		}
		
		boolean flag = false;
		int numTong = 0;
		
		for (int i = 0; i < m; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			numTong ++;
			
			if (!union(a, b))
			{
				flag = true;
				break;
			}
		}
		
		if (flag)
			System.out.println(numTong);
		else
			System.out.println("0");
	}

}
