#include <iostream>

int main(void){
    int n, k;
    int res = 1;
    std::cin >> n >> k;
    for (int i = n; i > 0; i --)
    {
        res = res * i;
    }
    for (int i = k; i > 0; i --)
    {
        res = res / i;
    }
    for (int i = n - k; i > 0; i --)
    {
        res = res / i;
    }
    std::cout << res;
}