#include <iostream>
#include <set>

int main(void){
    int N, M, num, n_intersection = 0;
    std::set <int> s;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N >> M;
    for (int i = 0; i < N; i ++)
    {
        std::cin >> num;
        s.insert(num);
    }
    for (int i = 0; i < M; i ++)
    {
        std::cin >> num;
        if (s.find(num) != s.end())
            n_intersection ++;
    }
    std::cout << N + M - (2 * n_intersection);
}