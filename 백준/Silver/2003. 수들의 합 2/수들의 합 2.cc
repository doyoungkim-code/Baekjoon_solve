// 2003

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	int N, M;
	cin >> N >> M;
	vector <int> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}

	int left = 0;
	int right = 0;
	int cnt = 0;
	int sum = 0;
	while (right <= N)
	{
		if (sum == M)
		{
			cnt++;
			sum = sum - v[left];
			left++;
		}
		else if (sum > M)
		{
			sum = sum - v[left];
			left++;
		}
		else
		{
			if (right == N)
				break;
			sum = sum + v[right];
			right++;
		}
	}
	cout << cnt;
}