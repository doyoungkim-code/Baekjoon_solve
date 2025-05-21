#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int N;
	cin >> N;
	vector <int> v(N, 0);
	for (int i = 0; i < N; ++i)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());
	
	int M;
	cin >> M;
	for (int i = 0; i < M; ++i)
	{
		int k;
		cin >> k;
		if (binary_search(v.begin(), v.end(), k))
		{
			cout << "1\n";
		}
		else
		{
			cout << "0\n";
		}
	}
}