// 1253

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	int N;
	cin >> N;
	vector <long long> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	int cnt = 0;

	for (int i = 0; i < N; i++)
	{
		int left = 0;
		int right = N - 1;

		while (left < right)
		{
			if (left == i)
			{
				left++;
				continue;
			}
			if (right == i)
			{
				right--;
				continue;
			}
			long long value = v[left] + v[right];
			if (value == v[i])
			{
				cnt++;
				break;
			}
			else if (value > v[i])
				right--;
			else
				left++;
		}
	}
	cout << cnt;
}