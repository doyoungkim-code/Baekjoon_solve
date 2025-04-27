#include <iostream>

long long a, b, c, k;

long long func(long long b){
    if (b == 0)
        return (1);
    else if (b == 1)
        return (a % c);
    if (b % 2 == 0)
    {
        return (func(b / 2) * func(b / 2) % c);
    }
    else
    {
        return (func(b / 2) * func(b / 2) % c * a % c);
    }
}

int main(void){
    std::cin >> a >> b >> c;
    std::cout << func(b);
}