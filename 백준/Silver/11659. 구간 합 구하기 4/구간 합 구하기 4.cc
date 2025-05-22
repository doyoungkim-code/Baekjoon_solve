// 11659

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N, M;
	int sum = 0;
	cin >> N >> M;
	vector <int> v(N + 1, 0);
	for (int i = 1; i <= N; ++i)
	{
		int n;
		cin >> n;
		sum = sum + n;
		v[i] = sum;
	}
	
	for (int i = 0; i < M; ++i)
	{
		int a, b;
		cin >> a >> b;
		cout << v[b] - v[a - 1] << "\n";
	}
}