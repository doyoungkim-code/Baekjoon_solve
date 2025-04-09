#include <iostream>
#include <deque>
#include <algorithm>

int main(void){
    int n, num, next;
    std::deque <std::pair <int, int>> dq;
    std::cin >> n;
    for (int i = 0; i < n; i ++){
        std::cin >> num;
        dq.push_back({num, i + 1});
    }
    for (int i = 0; i < n; i ++){
        next = dq.front().first;
        std::cout << dq.front().second << " ";
        dq.pop_front();
        if (next > 0){
            for (int j = 0; j < next - 1; j ++){
                dq.push_back(dq.front());
                dq.pop_front();
            }
        }
        else {
            for (int j = 0; j < - next; j ++){
                dq.push_front(dq.back());
                dq.pop_back();
            }
        }
    }
}