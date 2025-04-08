#include <iostream>
#include <queue>

int main(void){
    std::queue <int> q;
    int n, k;
    std::cin >> n >> k;
    
    for (int i = 1; i <= n; i ++)
        q.push(i);
    std::cout << "<";
    while (!q.empty())
    {
        for (int i = 0; i < k - 1; i ++)
        {
            q.push(q.front());
            q.pop();
        }
        std::cout << q.front();
        q.pop();
        if (!q.empty())
            std::cout << ", ";
    }
    std::cout << ">\n";
}