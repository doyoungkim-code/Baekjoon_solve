#include <iostream>
#include <vector>

using namespace std;

void pre_func(vector <int> &res)
{
	res[1] = 1;
	res[2] = 2;
	res[3] = 4;
	for (int i = 4; i <= 11; ++i)
	{
		res[i] = res[i - 1] + res[i - 2] + res[i - 3];
	}
}

int main(void)
{
	vector <int> res(12);

	pre_func(res);
	int T;
	cin >> T;

	for (int i = 0; i < T; ++i)
	{
		int n;
		cin >> n;
		cout << res[n] << "\n";
	}
}