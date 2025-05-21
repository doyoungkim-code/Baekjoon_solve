// 2805

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N, M, result;
	cin >> N >> M;
	vector <int> v(N, 0);
	for (int i = 0; i < N; ++i)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	
	int low = 0;
	int high = v[N - 1];

	while (low <= high)
	{
		long long sum = 0;

		int mid = (low + high) / 2;
		for (int i = 0; i < N; ++i)
		{
			if (v[i] > mid)
			{
				sum = sum + v[i] - mid;
			}
		}
		if (sum >= M)
		{
			result = mid;
			low = mid + 1;
		}
		else
		{
			high = mid - 1;
		}
	}
	cout << result;
}