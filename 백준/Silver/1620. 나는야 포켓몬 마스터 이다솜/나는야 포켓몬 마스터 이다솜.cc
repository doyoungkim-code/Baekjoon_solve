#include <iostream>
#include <string>
#include <map>

int main(void){
    int N, M;
    std::string input;
    std::string name[100001];
    std::map <std::string, int> m;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> N >> M;
    for (int i = 1; i <= N; i ++)
    {
        std::cin >> name[i];
        m.insert({name[i], i});
    }
    for (int i = 0; i < M; i ++)
    {
        std::cin >> input;
        if (input[0] >= '0' && input[0] <= '9')
            std::cout << name[stoi(input)] << "\n";
        else if ((input[0] >= 'A' && input[0] <= 'Z') || (input[0] >= 'a' && input[0] <= 'z'))
            std::cout << m.find(input) -> second << "\n";
    }
}