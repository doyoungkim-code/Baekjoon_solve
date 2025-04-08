#include <iostream>
#include <deque>

int main(void){
    std::deque <int> dq;
    int n, com, input;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> n;
    for (int i = 0; i < n; i ++){
        std::cin >> com;
        switch (com) {
        case 1:
            std::cin >> input;
            dq.push_front(input);
            break ;
        case 2:
            std::cin >> input;
            dq.push_back(input);
            break ;
        case 3:
            if (dq.empty()){
                std::cout << "-1\n";
                break ;
            }
            std::cout << dq.front() << "\n";
            dq.pop_front();
            break ;
        case 4:
            if (dq.empty()){
                std::cout << "-1\n";
                break ;
            }
            std::cout << dq.back() << "\n";
            dq.pop_back();
            break ;
        case 5:
            std::cout << dq.size() << "\n";
            break ;
        case 6:
            if (dq.empty())
                std::cout << "1\n";
            else
                std::cout << "0\n";
            break ;
        case 7:
            if (dq.empty()){
                std::cout << "-1\n";
                break ;
            }
            std::cout << dq.front() << "\n";
            break ;
        case 8:
            if (dq.empty()){
                std::cout << "-1\n";
                break ;
            }
            std::cout << dq.back() << "\n";
            break ;
        }
    }  
}