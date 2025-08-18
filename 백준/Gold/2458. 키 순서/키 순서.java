import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] result;
	static List<List<Integer>> bigList;
	static List<List<Integer>> smallList;
	
	static int bigBfs(int num)
	{
		int ret = 0;
		boolean[] visited = new boolean[N + 1];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.add(num);
		visited[num] = true;
		
		while (!dq.isEmpty())
		{
			int dqPoll = dq.poll();
			for (int i = 0; i < bigList.get(dqPoll).size(); ++i)
			{
				int listPoll = bigList.get(dqPoll).get(i);
				if (!visited[listPoll])
				{
					dq.add(listPoll);
					visited[listPoll] = true;
					ret ++;
				}
			}
		}
		return ret;
	}
	
	static int smallBfs(int num)
	{
		int ret = 0;
		boolean[] visited = new boolean[N + 1];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		dq.add(num);
		visited[num] = true;
		
		while (!dq.isEmpty())
		{
			int dqPoll = dq.poll();
			for (int i = 0; i < smallList.get(dqPoll).size(); ++i)
			{
				int listPoll = smallList.get(dqPoll).get(i);
				if (!visited[listPoll])
				{
					dq.add(listPoll);
					visited[listPoll] = true;
					ret ++;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[N + 1];
		bigList = new ArrayList<>();
		smallList = new ArrayList<>();
		for (int i = 1; i <= N + 1; ++i)
		{
			bigList.add(new ArrayList<>());
			smallList.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= M; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bigList.get(a).add(b);
			smallList.get(b).add(a);
		}
		
		for (int i = 1; i <= N; ++i)
		{
			result[i] += bigBfs(i);
			result[i] += smallBfs(i);
		}
		
		int resultAll = 0;
		
		for (int i = 1; i <= N; ++i)
		{
			if (result[i] == N - 1)
				resultAll ++;
		}
		System.out.println(resultAll);
	}
}
