// 1182

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int L, C;
vector <char> v;
vector <char> result;

void backtrack(int depth, int index, int mo_count, int ja_count)
{
	if (depth == L)
	{
		if (mo_count >= 1 && ja_count >= 2)
		{
			for (int i = 0; i < L; ++i)
			{
				cout << result[i];
			}
			cout << "\n";
		}
		return;
	}
	for (int i = index; i < C; ++i)
	{
		int mo = mo_count;
		int ja = ja_count;
		if (v[i] == 'a' || v[i] == 'e' || v[i] == 'i' || v[i] == 'o' || v[i] == 'u')
			mo++;
		else
			ja++;
		result.push_back(v[i]);
		backtrack(depth + 1, i + 1, mo, ja);
		result.pop_back();
	}
}

int main(void)
{
	cin.tie(0);
	ios::sync_with_stdio(0);
	
	cin >> L >> C;
	v = vector <char> (C);
	for (int i = 0; i < C; ++i)
	{
		cin >> v[i];
	}
	sort(v.begin(), v.end());

	backtrack(0, 0, 0, 0);
}