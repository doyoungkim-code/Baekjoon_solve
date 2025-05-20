#include <iostream>

using namespace std;

int zero_count[41];
int one_count[41];

void fibonacci() {
	zero_count[0] = 1;
	one_count[0] = 0;
	zero_count[1] = 0;
	one_count[1] = 1;
	for (int i = 2; i <= 40; i++)
	{
		zero_count[i] = zero_count[i - 1] + zero_count[i - 2];
		one_count[i] = one_count[i - 1] + one_count[i - 2];
	}
}

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);

	int T, N;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> N;
		fibonacci();
		cout << zero_count[N] << " " << one_count[N] << "\n";
	}
}