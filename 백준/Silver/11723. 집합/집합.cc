#include <iostream>
#include <set>

int main(void){
    int n, input;
    std::string s;
    std::set <int> st;
    std::set <int> allst = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);

    std::cin >> n;
    for (int i = 0; i < n; i ++)
    {
        std::cin >> s;
        if (s == "add")
        {
            std::cin >> input;
            st.insert(input);
        }
        else if (s == "remove")
        {
            std::cin >> input;
            st.erase(input);
        }
        else if (s == "check")
        {
            std::cin >> input;
            if (st.find(input) != st.end())
                std::cout << "1\n";
            else
                std::cout << "0\n";
        }
        else if (s == "toggle")
        {
            std::cin >> input;
            if (st.find(input) != st.end())
                st.erase(input);
            else
                st.insert(input);
        }
        else if (s == "all")
        {
            st = allst;
        }
        else if (s == "empty")
        {
            st.clear();
        }
    }
}