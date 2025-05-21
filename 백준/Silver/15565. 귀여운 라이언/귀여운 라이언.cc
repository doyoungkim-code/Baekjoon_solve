// 15565

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	int N, K;
	cin >> N >> K;
	vector <int> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}

	int cnt = 0;
	int left = 0;
	int right = 0;
	int min = N + 1;
	
	while (right < N)
	{
		if (v[right] == 1)
		{
			cnt++;
		}
		while (cnt >= K)
		{
			if (min > right - left + 1)
				min = right - left + 1;
			if (v[left] == 1)
			{
				cnt--;
			}
			left++;
		}
		right++;
	}
	if (min == N + 1)
		cout << "-1";
	else
		cout << min;
	return (0);
}