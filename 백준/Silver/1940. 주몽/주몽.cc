#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int N, M;
	int cnt = 0;
	cin >> N >> M;
	vector <int> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	int a = 0;
	int b = N - 1;
	while (a < b)
	{
		if (v[a] + v[b] == M)
		{
			a++;
			b--;
			cnt++;
		}
		else if (v[a] + v[b] < M)
			a++;
		else
			b--;
	}
	cout << cnt;
}