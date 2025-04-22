#include <iostream>

int main(void){
    int a, b, c, max, result;
    std::cin >> a >> b >> c;
    if (a == b)
    {
        if (a == c)
            result = 10000 + (a * 1000);
        else
            result = 1000 + (a * 100);
    }
    else if (b == c)
    {
        if (b == a)
            result = 10000 + (b * 1000);
        else
            result = 1000 + (b * 100);
    }
    else if (c == a)
    {
        if (c == b)
            result = 10000 + (c * 1000);
        else
            result = 1000 + (c * 100);
    }
    else
    {
        max = a;
        if (b > max)
            max = b;
        if (c > max)
            max = c;
        result = max * 100;
    }
    std::cout << result;
}