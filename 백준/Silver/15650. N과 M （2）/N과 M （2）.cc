#include <iostream>
#include <vector>

int N, M;
std::vector <int> num;
std::vector <bool> visited = {false, };

void backtrack(int depth)
{
    if (depth == M)
    {
        for (int i = 0; i < depth; i ++)
            std::cout << num[i] << " ";
        std::cout << "\n";
    }
    for (int i = 0; i < N; i ++)
    {
        if (!visited[i])
        {
            if (depth != 0 && num[depth - 1] >= i + 1)
                continue ;
            num.push_back(i + 1);
            visited[i] = true;
            backtrack(depth + 1);
            num.pop_back();
            visited[i] = false;
        }
    }
}
int main(void)
{
    std::cin >> N >> M;
    backtrack(0);
}
