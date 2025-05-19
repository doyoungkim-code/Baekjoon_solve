// SWEA 5215

#include <iostream>
#include <vector>

using namespace std;

int max_like = 0;

void dfs(int idx, vector <pair <int, int>> &v, int kal, int like, int N, int L)
{
    if (kal > L)
        return;
    if (kal <= L)
    {
        if (like > max_like)
        {
            max_like = like;
        }
    }
    for (int i = idx; i < N; ++ i)
    {
        dfs(i + 1, v, kal + v[i].second, like + v[i].first, N, L);
    }
}

int main(int argc, char** argv)
{
    cin.tie(0);
    ios::sync_with_stdio(0);

	int test_case;
	int T;
	cin>>T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
        max_like = 0;
        int N, L;
        cin >> N >> L;
        vector <pair <int, int>> v(N, {0, 0});
        for (int i = 0; i < N; ++ i)
        {
            cin >> v[i].first >> v[i].second;
        }
        dfs(0, v, 0, 0, N, L);
        cout << "#" << test_case << " " << max_like << "\n";
	}
	return 0;
}