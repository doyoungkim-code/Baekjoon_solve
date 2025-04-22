#include <iostream>

int main(void){
    int t, m, s;
    int result_t, result_m;
    std::cin >> t >> m >> s;
    result_m = m + s;
    result_t = t;
    while (result_m >= 60)
    {
        result_t ++;
        result_m = result_m - 60;
    }
    while (result_t >= 24)
        result_t = result_t - 24;
    std::cout << result_t << " " << result_m;
}