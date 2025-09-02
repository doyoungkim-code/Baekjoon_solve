import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<List<Integer>> combs;
	static List<List<Integer>> city;
	static int[] population;
	
	static boolean bfs(List<Integer> comb)
	{
		boolean[] visited = new boolean[N + 1];
		
		ArrayDeque <Integer> dq = new ArrayDeque<>();
		dq.add(comb.get(0));
		visited[comb.get(0)] = true;
		
		int count = 1;
		while (!dq.isEmpty())
		{
			int pollData = dq.poll();
			
			for (int i = 0; i < city.get(pollData).size(); ++i)
			{
				int cityNum = city.get(pollData).get(i);
				
				if (!visited[cityNum] && comb.contains(cityNum))
				{
					dq.add(cityNum);
					visited[cityNum] = true;
					count ++;
				}
			}
		}
		return (count == comb.size());
	}
	
	static void combination()
	{
		for (int i = 0; i < (1 << N); ++i)
		{
			List <Integer> lst = new ArrayList<>();
			for (int j = 0; j < N; ++j)
			{
				if ((i & (1 << j)) != 0)
				{
					lst.add(j);
				}
			}
			if (lst.size() != 0 && lst.size() != N)
				combs.add(lst);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		population = new int[N + 1];
		combs = new ArrayList<>();
		city = new ArrayList<>();
		for (int i = 0; i <= N; ++i)
		{
			city.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i)
		{
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int nums = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < nums; ++j)
			{
				city.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		combination();
		
		int min = 2147483647;
		for (int i = 0; i < combs.size(); ++i)
		{
			int combApop = 0;
			int combBpop = 0;
			List <Integer> combB = new ArrayList<>();
			for (int j = 1; j <= N; ++j)
			{
				if (!combs.get(i).contains(j))
				{
					combBpop += population[j];
					combB.add(j);
				}
				else
					combApop += population[j];
			}
			
			if (bfs(combs.get(i)) && bfs(combB))
			{
				int diff = Math.abs(combApop - combBpop);
				if (diff < min)
					min = diff;
			}			
		}
		if (min == 2147483647)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}