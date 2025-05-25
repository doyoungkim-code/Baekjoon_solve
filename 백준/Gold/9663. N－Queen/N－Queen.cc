// 9663 N-Queen

#include <iostream>
#include <vector>

using namespace std;

int N;
int cnt = 0;

void dfs(int depth, vector <vector <bool>> &chess)
{
	if (depth == N)
	{
		cnt++;
		return;
	}
	for (int i = 0; i < N; ++i)
	{
		if (!chess[depth][i])
		{
			vector <pair <int, int>> modified;

			for (int j = depth + 1; j < N; ++j)
			{
				if (!chess[j][i])
				{
					chess[j][i] = true;
					modified.push_back({ j, i });
				}
				if (i - (j - depth) >= 0 && !chess[j][i - (j - depth)])
				{
					chess[j][i - (j - depth)] = true;
					modified.push_back({ j, i - (j - depth) });
				}
				if (i + (j - depth) < N && !chess[j][i + (j - depth)])
				{
					chess[j][i + (j - depth)] = true;
					modified.push_back({ j, i + (j - depth) });
				}
			}
			dfs(depth + 1, chess);
			for (auto k = modified.begin(); k != modified.end(); ++k)
				chess[k -> first][k -> second] = false;
		}
	}
}

int main(void)
{

	cin >> N;
	vector <vector <bool>> chess(N, vector <bool>(N, false));
	
	dfs(0, chess);
	cout << cnt;
}