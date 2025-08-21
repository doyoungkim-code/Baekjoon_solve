import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static ArrayList<Integer>[] list;
	static int[] inD;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		inD = new int[N + 1];
		
		for (int i = 1; i <= N; ++i)
		{
			list[i] = new ArrayList();
		}
		
		int from;
		int to;
		
		for (int i = 0; i < M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			inD[to]++;
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 1; i <= N; ++i)
		{
			if (inD[i] == 0)
			{
				// 모든 진입차수 0 인 애들 다 큐에 넣기
				dq.offer(i);
			}
		}
		// 큐 사이즈가 0이면 위상정렬 불가
		
		ArrayList<Integer> res = new ArrayList<>();
		int idx;
		while(!dq.isEmpty())
		{
			idx = dq.poll();
			res.add(idx);
			for (int i : list[idx])
			{
				inD[i]--;
				if (inD[i] == 0)
				{
					dq.offer(i);
				}
			}
		}
		// res.size() == N 일때만 정렬이 다 된 것.
		for (int i : res)
		{
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
