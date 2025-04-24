#include <iostream>
#include <map>

int main(void){
    int N, M, num;
    std::map <int, int> m;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    for (int i = 0; i < N; i++)
    {
        std::cin >> num;
        auto it = m.insert({num, 1});
        if (!(it.second))
            it.first -> second ++;
    }
    std::cin >> M;
    for (int i = 0; i < M; i++)
    {
        std::cin >> num;
        auto it = m.find(num);
        std::cout << it -> second << " ";
    }
}