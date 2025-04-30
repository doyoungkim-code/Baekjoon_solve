// 12891

#include <iostream>
#include <map>

int P, S, result;
int num[4];
std::string DNA;
std::map <char, int> acgt;
std::map <char, int> need_acgt;

int ok_password(void){
    int ok = 0;
    auto it_n = need_acgt.find('A');
    auto it = acgt.find('A');
    for (int i = 0; i < 4; i++)
    {
        if (it_n -> second <= it -> second)
            ok ++;
        it_n ++;
        it ++;
    }
    return (ok == 4);
}

int main(void)
{
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    std::cin >> S >> P;
    std::cin >> DNA;
    for (int i = 0; i < 4; i ++)
    {
        std::cin >> num[i];
    }
    need_acgt.insert({'A', num[0]});
    need_acgt.insert({'C', num[1]});
    need_acgt.insert({'G', num[2]});
    need_acgt.insert({'T', num[3]});
    acgt.insert({'A', 0});
    acgt.insert({'C', 0});
    acgt.insert({'G', 0});
    acgt.insert({'T', 0});

    for (int j = 0; j < P; j ++)
    {
        (acgt.find(DNA[j]) -> second) ++;
    }
    if (ok_password())
        result ++;
    for (int i = 1; i < S; i ++)
    {
        if (i + P - 1 >= S)
            break ;
        acgt.find(DNA[i - 1]) -> second --;
        acgt.find(DNA[i + P - 1]) -> second ++;
        if (ok_password())
            result ++;
    }
    std::cout << result;
} 
