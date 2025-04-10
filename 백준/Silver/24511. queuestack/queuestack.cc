#include <iostream>
#include <deque>

int main(void){
    int N, M, value;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N;
    std::deque <int> dq;
    int* q_or_st = new int[N];
    for (int i = 0; i < N; i ++)
        std::cin >> q_or_st[i];
    for (int i = 0; i < N; i ++)
    {
        std::cin >> value;
        if (q_or_st[i] == 0)
            dq.push_back(value);
    }
    std::cin >> M;
    for (int i = 0; i < M; i ++)
    {
        std::cin >> value;
        dq.push_front(value);
        std::cout << dq.back() << " ";
        dq.pop_back();
    }
}