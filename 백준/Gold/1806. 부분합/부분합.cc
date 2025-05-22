// 11659

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N, S;
	cin >> N >> S;
	vector <int> v(N + 1, 0);
	int sum = 0;
	for (int i = 1; i <= N; ++i)
	{
		int a;
		cin >> a;
		sum = sum + a;
		v[i] = sum;
	}

	int left = 1;
	int right = 1;
	int now_sum = 0;
	int min_len = N + 1;
	while (right <= N)
	{
		now_sum = v[right] - v[left - 1];
		if (now_sum < S)
		{
			right++;
		}
		else
		{
			if (right - left + 1 < min_len)
				min_len = right - left + 1;
			left++;
		}
		if (left == right)
		{
			if (v[right] - v[left - 1] >= S)
			{
				min_len = 1;
				break;
			}
			right++;
		}
	}
	if (min_len == N + 1)
		cout << 0;
	else
		cout << min_len;
}