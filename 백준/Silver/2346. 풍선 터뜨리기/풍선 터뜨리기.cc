#include <iostream>
#include <deque>

int main(void){
    int n, num, next;
    std::deque <int> dq;
    std::deque <int> dq_index;
    std::cin >> n;
    for (int i = 0; i < n; i ++){
        std::cin >> num;
        dq.push_back(num);
        dq_index.push_back(i + 1);
    }
    for (int i = 0; i < n; i ++){
        next = dq.front();
        if (next > 0){
            dq.pop_front();
            std::cout << dq_index.front() << " ";
            dq_index.pop_front();
            for (int j = 0; j < next - 1; j ++){
                dq.push_back(dq.front());
                dq.pop_front();
                dq_index.push_back(dq_index.front());
                dq_index.pop_front();
            }
        }
        else {
            dq.pop_front();
            std::cout << dq_index.front() << " ";
            dq_index.pop_front();
            for (int j = 0; j < - next; j ++){
                dq.push_front(dq.back());
                dq.pop_back();
                dq_index.push_front(dq_index.back());
                dq_index.pop_back();
            }
        }
    }
}