#include <iostream>

int main(void){
    int n;
    int res = 1;
    std::cin >> n;
    for (int i = 0; i < n; i ++)
        res = res * 2;
    std::cout << res;
}