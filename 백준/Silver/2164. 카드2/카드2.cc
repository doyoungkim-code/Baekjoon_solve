#include <iostream>
#include <queue>

int main(void){
    int n;
    std::queue <int> q;

    std::cin >> n;
    for (int i = 0; i < n; i ++)
    {
        q.push(i + 1);
    }
    while (q.size() > 1)
    {
        q.pop();
        if (q.size() == 1)
            break ;
        q.push(q.front());
        q.pop();
    }
    std::cout << q.front() << "\n";
}