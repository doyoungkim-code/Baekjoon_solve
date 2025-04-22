#include <iostream>

int main(void){
    int n, a, b;
    std::ios::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cin >> n;
    for (int i = 0; i < n; i ++)
    {
        std::cin >> a >> b;
        std::cout << a + b << "\n";
    }
}