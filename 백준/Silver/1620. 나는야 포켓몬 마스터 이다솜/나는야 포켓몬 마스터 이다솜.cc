#include <iostream>
#include <string>
#include <map>

int main(void){
    int N, M;
    std::string name;
    std::map <std::string, int> m;
    std::map <int, std::string> m_rev;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N >> M;
    for (int i = 1; i <= N; i ++)
    {
        std::cin >> name;
        m.insert({name, i});
        m_rev.insert({i, name});
    }
    for (int i = 0; i < M; i ++)
    {
        std::cin >> name;
        if (name[0] >= '0' && name[0] <= '9')
            std::cout << m_rev.find(stoi(name)) -> second << "\n";
        else if ((name[0] >= 'A' && name[0] <= 'Z') || (name[0] >= 'a' && name[0] <= 'z'))
            std::cout << m.find(name) -> second << "\n";
    }
}