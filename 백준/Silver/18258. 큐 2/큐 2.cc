#include <iostream>
#include <string>
#include <queue>

int main(void){
    int n, num;
    std::string s;
    std::queue <int> q;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> n;

    for (int i = 0; i < n; i ++){
        std::cin >> s;
        if (s == "push"){
            std::cin >> num;
            q.push(num);
        }
        else if (s == "pop"){
            if (q.empty())
                std::cout << -1 << "\n";
            else {
                std::cout << q.front() << "\n";
                q.pop();
            }
        }
        else if (s == "size"){
            std::cout << q.size() << "\n";
        }
        else if (s == "empty"){
            std::cout << q.empty() << "\n";
        }
        else if (s == "front"){
            if (q.empty())
                std::cout << -1 << "\n";
            else
                std::cout << q.front() << "\n";
        }
        else if (s == "back"){
            if (q.empty())
                std::cout << -1 << "\n";
            else
                std::cout << q.back() << "\n";
        }
    }
}