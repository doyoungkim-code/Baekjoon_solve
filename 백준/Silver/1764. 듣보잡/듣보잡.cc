#include <iostream>
#include <map>

int main(void){
    int N, M, num = 0;
    std::string name;
    std::map <std::string, bool> m;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N >> M;
    for (int i = 0; i < N; i ++)
    {
        std::cin >> name;
        m.insert({name, false});
    }
    for (int i = 0; i < M; i ++)
    {
        std::cin >> name;
        auto it = m.find(name);
        if (it != m.end())
        {
            (it -> second) = true;
            num ++;
        }
    }
    std::cout << num << "\n";
    for (auto it = m.begin(); it != m.end(); it ++)
    {
        if (it -> second == true)
            std::cout << it -> first << "\n";
    }
}