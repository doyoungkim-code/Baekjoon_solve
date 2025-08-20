import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static List<List<Integer>> arr;
	
	static int bfs(int startNode)
	{
		int maxBread = 1;
		ArrayDeque <Integer> dq = new ArrayDeque<>();
		int[] visited = new int[101];
		
		visited[startNode] = 1;
		dq.offer(startNode);
		
		while (!dq.isEmpty())
		{
			int pollData = dq.poll();
			for (int i = 0; i < arr.get(pollData).size(); ++i)
			{
				int innerData = arr.get(pollData).get(i);
				if (visited[innerData] == 0)
				{
					visited[innerData] = visited[pollData] + 1;
					dq.offer(innerData);
					if (maxBread < visited[innerData])
						maxBread = visited[innerData];
				}
			}
		}
		
		int maxValue = 0;
		for (int i = 0; i < visited.length; ++i)
		{
			if (visited[i] == maxBread)
			{
				if (maxValue < i)
					maxValue = i;
			}
		}
		return maxValue;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; ++tc)
		{
			st = new StringTokenizer(br.readLine());
			
			arr = new ArrayList<>();
			for (int i = 1; i <= 101; ++i)
			{
				arr.add(new ArrayList<>());
			}
			
			// 테스트케이스 별 데이터 길이와 시작점
			int dataLength = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < dataLength / 2; ++i)
			{
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr.get(a).add(b);
			}
			
			System.out.println("#" + tc + " " + bfs(startNode));
		}
	}

}
