// 2606

#include <iostream>
#include <vector>

using namespace std;

int cnt = 0;
vector <int> nodes[101];
vector <bool> visited;

void dfs(int start)
{
	for (int i = 0; i < nodes[start].size(); ++i)
	{
		if (!visited[nodes[start][i]])
		{
			visited[nodes[start][i]] = true;
			cnt++;
			dfs(nodes[start][i]);
		}
	}
}

int main(void)
{
	int N, M;
	cin >> N >> M;
	visited = vector <bool>(N + 1, false);
	for (int i = 1; i <= M; ++i)
	{
		int a, b;
		cin >> a >> b;
		nodes[a].push_back(b);
		nodes[b].push_back(a);
	}
	visited[1] = true;
	dfs(1);
	cout << cnt;
}