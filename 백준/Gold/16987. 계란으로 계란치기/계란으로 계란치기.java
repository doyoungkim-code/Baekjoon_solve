import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int max;
	static List <Egg> eggList;
	
	static class Egg{
		int hp;
		int atk;
		
		public Egg(int hp, int atk) {
			super();
			this.hp = hp;
			this.atk = atk;
		}
	}
	
	static void dfs(int depth)
	{
		if (depth == N)
		{
			int broken = 0;
			for (int i = 0; i < N; ++i)
			{
				if(eggList.get(i).hp <= 0)
					broken ++;
			}
			if (max < broken)
				max = broken;
			return;
		}
		if (eggList.get(depth).hp <= 0)
		{
			dfs(depth + 1);
			return;
		}
		boolean hitcheck = false;
		for (int i = 0; i < N; ++i)
		{
			if (i == depth)
				continue;
			
			if (eggList.get(i).hp > 0)
			{
				hitcheck = true;
				eggList.get(depth).hp -= eggList.get(i).atk;
				eggList.get(i).hp -= eggList.get(depth).atk;
				dfs(depth + 1);
				eggList.get(depth).hp += eggList.get(i).atk;
				eggList.get(i).hp += eggList.get(depth).atk;
			}
		}
		if (!hitcheck)
		{
			dfs(depth + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		eggList = new ArrayList<>();
		
		for (int i = 0; i < N; ++i)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			eggList.add(new Egg(a, b));
		}
		
		dfs(0);
		
		System.out.println(max);
	}

}
