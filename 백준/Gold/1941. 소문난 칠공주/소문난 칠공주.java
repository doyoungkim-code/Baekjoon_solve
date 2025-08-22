import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	
	static int[][] girls;
	static int[] res;
	static boolean[] visited;
	static boolean[][] visitedBfs;
	static int cnt;
	
	static boolean bfs(int[] result)
	{
		// 3. 7개가 다 골라졌다면, 7개가 다 이어져있는지 bfs로 판별!
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		boolean[][] visitedBfs = new boolean[5][5];
		ArrayDeque <Integer> dq = new ArrayDeque<>();
		
		int[][] girlsBfs = new int[5][5];
		for (int i = 0; i < 7; ++i)
		{
			girlsBfs[(result[i] - 1) / 5][(result[i] - 1) % 5] = 1;
		}
		
		int length = 1;
		dq.add(result[0]);
		visitedBfs[(result[0] - 1) / 5][(result[0] - 1) % 5] = true;
		
		while (!dq.isEmpty() && length <= 7)
		{
			int pollData = dq.poll();
			
			for (int k = 0; k < 4; ++k)
			{
				int nx = ((pollData - 1) / 5) + dx[k];
				int ny = ((pollData - 1) % 5) + dy[k];
				
				if (nx >= 5 || nx < 0 || ny >= 5 || ny < 0)
					continue;
				if (!visitedBfs[nx][ny] && girlsBfs[nx][ny] == 1) 
				{
					dq.add(nx * 5 + ny + 1);
					visitedBfs[nx][ny] = true;
				}
			}
		}
		
		for (int i = 0; i < 7; ++i)
		{
			if (!visitedBfs[(result[i] - 1) / 5][(result[i] - 1) % 5])
				return false;
		}
		return true;
	}
	
	static void permutation(int depth, int Y)
	{
		// 2. 고로는 중 1, 0 인지 판별해서 0이 4이상 되면 멈추기
		if (Y > 3)
		{
			return ;
		}
		if (depth == 7)
		{
			if (bfs(res))
				cnt ++;
			return ;
		}
		
		for (int i = 1; i <= 25; ++i)
		{
			if (!visited[i] && (depth == 0 || (depth >= 1 && res[depth - 1] < i)))
			{
				visited[i] = true;
				res[depth] = i;
				int whatIs = girls[(i - 1) / 5][(i - 1) % 5];				
				if (whatIs == 1)
					permutation(depth + 1, Y);
				else
					permutation(depth + 1, Y + 1);
				visited[i] = false;
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        girls = new int[6][6];
        
        for (int i = 0; i < 5; ++i)
        {
        	String s = br.readLine();
        	for (int j = 0; j < 5; ++j)
        	{
        		char c = s.charAt(j);
        		if (c == 'S')
        			girls[i][j] = 1;
        	}
        }
        
        // 1. 25 개 중에 7 개 고르기!
        res = new int[8];
        visited = new boolean[26];
        permutation(0, 0);
        System.out.println(cnt);
        
        
    }
}
