// 1182

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector <int> v;
int result = 0;

void backtrack(int index, int N, int S, int sum, int depth)
{
	if (sum == S && depth > 0)
	{
		result++;
	}
	for (int i = index; i <= N; ++i)
	{
			sum = sum + v[i];
			backtrack(i + 1, N, S, sum, depth + 1);
			sum = sum - v[i];
	}
}

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	int N, S;
	cin >> N >> S;
	v = vector <int> (N + 1, 0);
	for (int i = 1; i <= N; ++i)
	{
		cin >> v[i];
	}
	backtrack(1, N, S, 0, 0);
	cout << result;
}