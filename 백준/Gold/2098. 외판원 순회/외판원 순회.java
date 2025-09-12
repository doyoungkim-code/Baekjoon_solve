import java.io.*;
import java.util.*;

public class Main {

	static int N; // 도시 수
	final static int INF = 1000000000;
	static int[][] dist; // 도시 간 이동 비용
	static int[][] memo; // 메모이제이션
	
	static int tsp(int cur, int visited)
	{
		if (visited == (1 << N) - 1) // 전부 방문
		{
			if (dist[cur][0] == 0)
				return INF; // 현재 위치에서 출발지로 가는 경로가 없다.
			
			return dist[cur][0]; // 출발지로 가는 비용 반환
		}
		
		if (memo[cur][visited] != -1) // 최적경로 계산이 되어있는 경우는 바로 값 반환
		{
			return memo[cur][visited];
		}
		
		memo[cur][visited] = INF; // 최소비용 계산 시작을 위해 INF로 바꾸고 시작한다.
		
		for (int next = 0; next < N; ++next)
		{
			if ((visited & (1 << next)) == 0 && dist[cur][next] != 0) // 아직 방문 안했고, 가는 길이 존재하면
			{
				int cost = dist[cur][next] + tsp(next, visited | (1 << next)); // 현재에서 다음 도시갈 비용과, 다음 도시에서 나머지 도시들을 방문하는 최소 비용을 더해준다.
				
				memo[cur][visited] = Math.min(memo[cur][visited], cost); // 기존 계산된 최소비용과 새로 계산된 비용을 비교, 갱신
			}
		}
		return memo[cur][visited];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dist = new int[N][N];
		memo = new int[N][1 << N]; // 모든 방문 상태에 대해서 봐야하므로, 비트마스킹으로 N개 (1 << N)
		
		for (int i = 0; i < N; i ++) {
			Arrays.fill(memo[i], -1);
		}
		
		for (int i = 0; i < N; ++i)	
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j)
			{
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(0, 1 << 0));
	}
}