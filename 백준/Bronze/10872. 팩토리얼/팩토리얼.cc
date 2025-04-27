#include <iostream>

int main(void){
    int n;
    int res = 1;
    std::cin >> n;
    for (int i = n; i > 0; i --)
    {
        res = res * i;
    }
    std::cout << res;
}