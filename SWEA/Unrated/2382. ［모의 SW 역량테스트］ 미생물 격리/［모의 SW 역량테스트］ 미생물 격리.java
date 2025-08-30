import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; // 맵 크기 N * N
	static int M; // 시간
	static int K; // 초기 군집 수
	static Micro[] microList; // 전체 군집 리스트 (크기 K 배열 고정)
	static Micro[][] map; // 초기값 : null
	static int[] dr = {0, -1, 1, 0, 0}; // 0 : X, 1 : 상, 2 : 하, 3 : 좌, 4 : 우
	static int[] dc = {0, 0, 0, -1, 1};
	
	static class Micro implements Comparable<Micro> {
		int row;
		int col;
		int num;
		int dir;
		boolean isDead;
		
		public Micro(int row, int col, int num, int dir){
			super();
			this.row = row;
			this.col = col;
			this.num = num;
			this.dir = dir;
		}

		@Override
		public int compareTo(Micro o) {
			return Integer.compare(o.num, this.num);
		}
	}
	
	static int cycle()
	{
		int time = M;
		int nr;
		int nc;
		int remainNum = 0;
		
		while (time-- > 0) // M 시간만큼 돌리기 위한 반복
		{
			Arrays.sort(microList);
			for (Micro cur : microList) // 미생물 리스트 전부 이동
			{
				if (cur.isDead)
					continue;
				
				nr = cur.row += dr[cur.dir];
				nc = cur.col += dc[cur.dir];
				
				// 약품 칸 처리
				if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1)
				{
					cur.num = cur.num/2;
					if (cur.num == 0) {
						cur.isDead = true;
						continue;
					}
					// 상1 -> 하2, 하2-> 상1, 좌3 -> 우4, 우4 -> 좌3 => 홀수는 +1, 짝수는 -1
					if (cur.dir % 2 == 1)
						cur.dir ++;
					else
						cur.dir --;
				}
				if (map[nr][nc] == null) // 그 위치에 처음 도착하는 군집
					map[nr][nc] = cur;
				else // 그 셀에 나중 도착하는 군집일 경우
				{						
					map[nr][nc].num += cur.num;
					cur.isDead = true;
				}
			}
            remainNum = reset(); // 살아있는 미생물 수 받기
		}
		return remainNum;
	}
	
	static int reset() {
		int total = 0;
		
		for (int r = 0; r < N; ++r)
		{
			for (int c = 0; c < N; ++c)
			{
				if (map[r][c] == null)
					continue;
				total += map[r][c].num;
				map[r][c] = null;
			}
		}
		return total;
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int tc = 1; tc <= T; ++tc)
    	{
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		microList = new Micro[K];
    		map = new Micro[N][N];
    		
    		for (int k = 0; k < K; ++k)
    		{
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			int num = Integer.parseInt(st.nextToken());
    			int dir = Integer.parseInt(st.nextToken());
    			
    			microList[k] = new Micro(x, y, num, dir);
    		}
 
    		System.out.println("#" + tc + " " + cycle());
    	}
	}
}
