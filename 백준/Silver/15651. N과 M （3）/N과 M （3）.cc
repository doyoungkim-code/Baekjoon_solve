#include <iostream>
#include <vector>

int N, M;
std::vector <int> v;

void backtrack(int depth){
    if (depth == M)
    {
        for (int i = 0; i < depth; i ++)
        {
            std::cout << v[i] << " ";
        }
        std::cout << "\n";
        return ;
    }
    for (int i = 0; i < N; i ++)
    {
        v.push_back(i + 1);
        backtrack(depth + 1);
        v.pop_back();
    }
}

int main(void){
    std::cin >> N >> M;
    backtrack(0);
}