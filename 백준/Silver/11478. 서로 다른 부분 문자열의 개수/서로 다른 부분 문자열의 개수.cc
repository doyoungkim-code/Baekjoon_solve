#include <iostream>
#include <set>
#include <string>

int main(void){
    std::string s;
    std::set <std::string> st;
    std::cin.tie(NULL);
    std::ios::sync_with_stdio(false);
    std::cin >> s;
    
    for (int i = 0; i < s.length(); i ++)
    {
        for (int j = 0; j < s.length() - i; j ++)
        {
            st.insert(s.substr(i, j + 1));
        }
    }
    std::cout << st.size();
}