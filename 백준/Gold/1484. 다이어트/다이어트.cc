// 1484

#include <iostream>
#include <vector>

using namespace std;

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);
	long long G;
	
	cin >> G;

	bool found = false;
	long long diff = 0;
	long long left = 1;
	long long right = 2;
	
	while (left < right)
	{
		diff = right * right - left * left;

		if (diff == G)
		{
			cout << right << "\n";
			found = true;
			right++;
		}
		else if (diff < G)
			right++;
		else
			left++;
	}
	if (!found)
		cout << "-1";
}