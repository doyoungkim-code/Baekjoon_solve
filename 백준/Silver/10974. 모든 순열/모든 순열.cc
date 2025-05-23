// 10974

#include <iostream>
#include <vector>

using namespace std;

vector <int> result;
vector <bool> visited;

void backtrack(int depth, int N)
{
	if (depth == N)
	{
		for (int i = 0; i < N; i++)
		{
			cout << result[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 0; i < N; i++)
	{
		if (!visited[i])
		{
			result.push_back(i + 1);
			visited[i] = true;
			backtrack(depth + 1, N);
			result.pop_back();
			visited[i] = false;
		}
	}
}

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N;
	cin >> N;
	vector <int> v(N);
	visited = vector <bool> (N, false);
	for (int i = 0; i < N; i++)
	{
		v[i] = i + 1;
	}
	backtrack(0, N);
}