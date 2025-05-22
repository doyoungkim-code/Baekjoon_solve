// 11659

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N, M;
	cin >> N >> M;
	vector <vector <int>> v(N + 1, vector <int>(N + 1, 0));
	for (int i = 1; i <= N; ++i)
	{
		int row_sum = 0;
		for (int j = 1; j <= N; ++j)
		{
			int a;
			cin >> a;
			row_sum = row_sum + a;
			v[i][j] = row_sum;
		}
	}

	for (int i = 0; i < M; ++i)
	{
		int sum = 0;
		int x1, y1, x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int j = x1; j <= x2; j++)
		{
			sum = sum + v[j][y2] - v[j][y1 - 1];
		}
		cout << sum << "\n";
	}
}