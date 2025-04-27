#include <iostream>

int N, M;
int nums[8];
int visited[8] = {0, };

void dfs(int depth)
{
    if (depth == M)
    {
        for (int i = 0; i < depth; i ++)
            std::cout << nums[i] << " ";
        std::cout << "\n";
        return ;
    }
    for (int i = 0; i < N; i ++){
        if (!visited[i]){
            nums[depth] = i + 1;
            visited[i] = 1;
            dfs(depth + 1);
            visited[i] = 0;
        }
    }
}

int main(void){
    std::cin >> N >> M;
    dfs(0);
}
