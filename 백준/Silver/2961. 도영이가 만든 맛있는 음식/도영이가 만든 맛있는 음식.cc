// 2961

#include <iostream>
#include <vector>

int N, len;
int min = 100000000;
std::vector <std::pair<int, int>> v;
std::vector <std::pair<int, int>> v_b;
std::vector <bool> visited = {false, };

void backtrack(int len, int depth)
{
    int s_sum = 1;
    int ss_sum = 0;

    if (depth >= len)
    {
        for (int i = 0; i < len; i ++)
        {
            s_sum = s_sum * v_b[i].first;
            ss_sum = ss_sum + v_b[i].second;
        }
        if (abs(s_sum - ss_sum) <= min)
            min = abs(s_sum - ss_sum);
        return;
    }
    for (int i = 0; i < N; i ++)
    {
        if (!visited[i])
        {
            visited[i] = true;
            v_b.push_back(v[i]);
            backtrack(len, depth + 1);
            visited[i] = false;
            v_b.pop_back();
        }
    }
}

int main(void){
    int s, ss;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    for (int i = 0; i < N; i ++)
    {
        std::cin >> s >> ss;
        v.push_back({s, ss});
    }
    for (len = 1; len <= N; len ++)
    {
        backtrack(len, 0);
    }
    std::cout << min;
}