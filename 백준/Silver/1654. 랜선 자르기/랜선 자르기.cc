// 1654

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int K, N;
	cin >> K >> N;
	vector <int> v(K);
	for (int i = 0; i < K; ++i)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	
	int result = 0;
	int sum = 0;
	long long low = 1;
	long long high = v[K - 1];

	while (low <= high)
	{
		sum = 0;
		long long mid = (low + high) / 2;

		for (int i = 0; i < K; ++i)
		{
			sum = sum + (v[i] / mid);
		}
		if (sum >= N)
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